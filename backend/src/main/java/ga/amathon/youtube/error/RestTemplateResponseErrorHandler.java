package ga.amathon.youtube.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(final ClientHttpResponse response) throws IOException {
		return (
			response.getStatusCode().series() == CLIENT_ERROR
				|| response.getStatusCode().series() == SERVER_ERROR);
	}

	@Override
	public void handleError(final ClientHttpResponse response) throws IOException {
		if (response.getStatusCode()
			.series() == HttpStatus.Series.SERVER_ERROR) {
			// handle SERVER_ERROR
		} else if (response.getStatusCode()
			.series() == HttpStatus.Series.CLIENT_ERROR) {
			// handle CLIENT_ERROR
			if (response.getStatusCode() == HttpStatus.NOT_FOUND) {

			}
		}
	}
}
