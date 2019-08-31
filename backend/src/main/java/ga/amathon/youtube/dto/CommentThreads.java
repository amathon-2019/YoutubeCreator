package ga.amathon.youtube.dto;

import com.google.api.services.youtube.model.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentThreads {

	private String kind;
	private String etag;
	private String nextPageToken;
	private PageInfo pageInfo;
	private List<CommentItem> items;
}
