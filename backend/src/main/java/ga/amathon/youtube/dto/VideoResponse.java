package ga.amathon.youtube.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VideoResponse {

	private String kind;
	private String etag;
	private List<VideoResponseItem> items;
}
