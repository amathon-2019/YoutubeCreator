package ga.amathon.youtube.service;

import ga.amathon.youtube.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

	@Value("${youtube.apiKey}")
	private String apiKey;

	private final int MAX_RESULTS = 100;

	private RestTemplate restTemplate = new RestTemplate();

	public List<CommentThreadsResponse> getTotalCommentThreadsBy(final String videoId) {
		List<CommentThreadsResponse> commentThreadsResponses = new ArrayList<>();
//		RestTemplate restTemplate = new RestTemplate();
		String nextPageToken = "";
		int order = 1;
		while (nextPageToken != null) {
			CommentThreads commentThreads = restTemplate.getForObject(
				"https://www.googleapis.com/youtube/v3/commentThreads?key=" + apiKey +
					"&part=snippet" +
					"&maxResults=" + MAX_RESULTS +
					"&videoId=" + videoId +
					"&textFormat=plainText" +
					"&pageToken=" + nextPageToken
				, CommentThreads.class);
			nextPageToken = commentThreads.getNextPageToken();

			for (CommentItem item : commentThreads.getItems()) {
				CommentThreadsResponse response = CommentThreadsResponse.builder()
					.authorId(item.getSnippet().getTopLevelComment().getSnippet().getAuthorChannelId().getValue())
					.authorName(item.getSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName())
					.order(order++)
					.likeCount(item.getSnippet().getTopLevelComment().getSnippet().getLikeCount())
					.build();
				response.setTotalPoint(
					response.getLikeCount() + response.getOrder()
				);
				commentThreadsResponses.add(response);
			}
		}

		return commentThreadsResponses;
	}

	public String getChannelInfoByVideoId(String videoId) {
		VideoResponse videoResponse = restTemplate.getForObject(
			"https://www.googleapis.com/youtube/v3/videos?key=" + apiKey +
				"&id=" + videoId +
				"&part=snippet", VideoResponse.class
		);

		return videoResponse.getItems().get(0).getSnippets().getChannelId();
	}

	public void fliterUnsubscribedCommentAuthor(
		List<CommentThreadsResponse> commentThreadsResponses, String channelId) {
//		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getForObject(
			"https://www.googleapis.com/youtube/v3/videos?key=" + apiKey +
				"&part=snippet" +
				"&maxResults=2" +
				"&channelId=" + channelId,
			Subscriptions.class
		);
	}
}
