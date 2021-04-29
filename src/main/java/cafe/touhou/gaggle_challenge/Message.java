package cafe.touhou.gaggle_challenge;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Message {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	private final String MESSAGE = "Welcome to the machine.";

	private final String timestamp;

	public Message() {
		timestamp = OffsetDateTime.now()
			.truncatedTo(ChronoUnit.SECONDS)
			.format(FORMATTER);
	}

	public String getMessage() {
		return MESSAGE;
	}

	public String getTimestamp() {
		return timestamp;
	}
}