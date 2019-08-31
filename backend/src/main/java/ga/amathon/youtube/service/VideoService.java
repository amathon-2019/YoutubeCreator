package ga.amathon.youtube.service;

import ga.amathon.youtube.dto.*;
import ga.amathon.youtube.error.RestTemplateResponseErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VideoService {

	@Value("${youtube.apiKey}")
	private String apiKey;

	private RestTemplate restTemplate;

	public VideoService(final RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder
			.errorHandler(new RestTemplateResponseErrorHandler())
			.build();
	}

	public List<CommentThreadsResponse> getTotalCommentThreadsBy(final String videoId) {
		List<CommentThreadsResponse> commentThreadsResponses = new ArrayList<>();

		String nextPageToken = "";
		int order = 1;
		while (nextPageToken != null) {
			CommentThreads commentThreads = restTemplate.getForObject(
				"https://www.googleapis.com/youtube/v3/commentThreads?key=" + apiKey +
					"&part=snippet" +
					"&maxResults=100" +
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

	public String getChannelIdByVideoId(String videoId) {
		log.info("getChannelIdByVideoId() -> videoId: " + videoId);
		VideoResponse videoResponse = restTemplate.getForObject(
			"https://www.googleapis.com/youtube/v3/videos?key=" + apiKey +
				"&id=" + videoId +
				"&part=snippet", VideoResponse.class
		);

		if (videoResponse == null) {
			return "";
		}

		return videoResponse.getItems().get(0).getSnippet().getChannelId();
	}

	/**
	 * @param commentThreadsResponses 추첨 완료된 댓글들의 list
	 * @param originalChannelId 구독자 List를 가져올 기준이 되는 channelId
	 */
	public void filterUnsubscribedCommentAuthor(
		List<CommentThreadsResponse> commentThreadsResponses, String originalChannelId) {
		log.info("filterUnsubscribedCommentAuthor() -> originalChannelId: " + originalChannelId);

		String nextPageToken = "";
		for (CommentThreadsResponse response : commentThreadsResponses) {

			List<String> channelIds = new ArrayList<>();
			while (nextPageToken != null) {
				// 해당 channel의 구독자 정보
				Subscriptions subscriptions = restTemplate.getForObject(
					"https://www.googleapis.com/youtube/v3/subscriptions?key=" + apiKey +
						"&part=snippet" +
						"&maxResults=50" +
						"&channelId=" + response.getAuthorId() +
						"&pageToken=" + nextPageToken,
					Subscriptions.class
				);
				// 403 Exception handling
				if (subscriptions == null || subscriptions.getEtag() == null) {
					return;
				}

				nextPageToken = subscriptions.getNextPageToken();

				for (SubscriptionItem item : subscriptions.getItems()) {
					channelIds.add(item.getSnippet().getResourceId().getChannelId());
				}
			}

			if (!channelIds.contains(originalChannelId)) {
				removeResponse(commentThreadsResponses, channelIds);
			}
		}

	}

	private void removeResponse(final List<CommentThreadsResponse> commentThreadsResponses, final List<String> channelIds) {
		for (CommentThreadsResponse response : commentThreadsResponses) {
			if (!channelIds.contains(response.getAuthorId())) {
				commentThreadsResponses.remove(response);
			}
		}
	}
}
