package ga.amathon.youtube.controller;

import ga.amathon.youtube.dto.CommentThreadsResponse;
import ga.amathon.youtube.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/video", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class VideoController {

	@Value("${youtube.apiKey}")
	private String apiKey;

	private VideoService videoService;

	public VideoController(final VideoService videoService) {
		this.videoService = videoService;
	}

	/**
	 * 특정 video의 comment 관련 정보들을 가져와서,
	 * 각 comment마다 "id / order / likeCount" 등을 갖는 객체에 mapping한다.
	 * 해당 객체들을 List 형태로 return한다.
	 */
	@GetMapping("/{videoId}/comments")
	// TODO: 몇명까지 추첨할 것인지 입력값 받아서 그 개수만큼만 list에 담아서 리턴
	public List<CommentThreadsResponse> getComments(
		@PathVariable("videoId") String videoId) {

		List<CommentThreadsResponse> commentThreadsResponses = videoService.getTotalCommentThreadsBy(videoId);
		Collections.sort(commentThreadsResponses);

		String originalChannelId = videoService.getChannelIdByVideoId(videoId);
		videoService.filterUnsubscribedCommentAuthor(commentThreadsResponses, originalChannelId);

		// TODO: videoService.() 메소드를 사용하여,
		//  해당 채널을 구독하지 않은 사람 체크 후 remove

		// TODO: 추첨할 기준을 직접 선정하는 기능. 해당 기준 및 가중치를 입력값으로 받아서 계산

		return commentThreadsResponses;
	}
}














