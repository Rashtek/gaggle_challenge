package cafe.touhou.gaggle_challenge;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Message {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

	private String message;
	private String timestamp;

	public Message() {
		this.message = "Welcome to the machine.";
		this.timestamp = OffsetDateTime.now()
			.truncatedTo(ChronoUnit.SECONDS)
			.format(FORMATTER);
	}

	public Message(String message, String timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}