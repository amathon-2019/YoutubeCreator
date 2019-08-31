package ga.amathon.youtube.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SubscriptionItemSnippet {

	private LocalDateTime publishedAt;
	private String title;
	private String description;
	private ResourceId resourceId;
}
