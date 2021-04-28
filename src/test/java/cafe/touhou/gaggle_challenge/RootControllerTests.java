package cafe.touhou.gaggle_challenge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.OffsetDateTime;

import static
	org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static
	org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(RootController.class)
class RootControllerTests {

	@Autowired
	private MockMvc mockMVC;

	@Test
	void correctMessageAndTimestamp() throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		Message msg = new Message();
		String res = this.mockMVC.perform(get("/"))
			.andExpect(status().isOk())
			.andReturn()
			.getResponse()
			.getContentAsString();

		Message recvd_msg = objMapper.readValue(res, Message.class);

		Assertions.assertThat(recvd_msg.getMessage())
			.isEqualTo(msg.getMessage());
		
		long received = OffsetDateTime.parse(recvd_msg.getTimestamp(), Message.FORMATTER).toEpochSecond();
		long expected = OffsetDateTime.parse(msg.getTimestamp(), Message.FORMATTER).toEpochSecond();

		/*
			The test could be run such that a new second ticks before we receive
			the object from the RootController. Unlikely as it is, allow the
			received message timestamp to be up to one second ahead.
		*/
		Assertions.assertThat(received - expected).isLessThanOrEqualTo(1);
	}

}
