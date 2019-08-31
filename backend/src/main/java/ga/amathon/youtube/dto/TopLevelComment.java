package ga.amathon.youtube.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopLevelComment {

	private String kind;
	private String etag;
	private String id;
	private TopLevelCommentSnippet snippet;
}
