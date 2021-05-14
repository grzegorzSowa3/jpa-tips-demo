package pl.recompiled.jpatipsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class JpaTipsDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private String userId = UUID.randomUUID().toString();

	@Test
	void shouldCreateTenPosts() throws Exception {
		for (int i = 0; i < 10; i++) {
			this.mockMvc.perform(
					post("/posts")
							.header("userId", userId)
							.content(String.format("{\"text\": \"Sample post %d\"}", i))
							.contentType(MediaType.APPLICATION_JSON));
		}
	}

}
