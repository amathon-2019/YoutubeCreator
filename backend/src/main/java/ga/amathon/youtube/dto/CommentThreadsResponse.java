package ga.amathon.youtube.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentThreadsResponse implements Comparable<CommentThreadsResponse> {

	private String authorId;
	private String authorName;
	// TODO: order로 하지 말고, YouTube API에서 주는 publishedAt 그대로 정렬한 다음 가중치 줄 방법은 없을지?
	private Integer order;
	private Integer likeCount;
	private Integer totalPoint;

	@Override
	public int compareTo(final CommentThreadsResponse o) {
		if (this.totalPoint < o.getTotalPoint()) {
			return 1;
		} else if (this.totalPoint > o.getTotalPoint()) {
			return -1;
		}
		return 0;
	}
}
