package cafe.touhou.gaggle_challenge;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public Message welcome() {
		return new Message();
	}
}
