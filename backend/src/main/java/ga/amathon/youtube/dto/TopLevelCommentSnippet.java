package ga.amathon.youtube.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TopLevelCommentSnippet {

	private String authorDisplayName;
	private String authorProfileImageUrl;
	private String authorChannelUrl;
	private AuthorChannelId authorChannelId;
	private String videoId;
	private String textDisplay;
	private String textOriginal;
	private int likeCount;
	private LocalDateTime publishedAt;
	private LocalDateTime updatedAt;
}
