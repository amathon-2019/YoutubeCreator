package ga.amathon.youtube.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoResponseItem {

	private String kind;
	private String id;
	private VideoResponseItemSnippet snippets;
}
