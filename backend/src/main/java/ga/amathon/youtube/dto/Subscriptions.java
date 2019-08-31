package ga.amathon.youtube.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Subscriptions {

	private String kind;
	private String etag;
	private String nextPageToken;
	private List<SubscriptionItem> items;
}
