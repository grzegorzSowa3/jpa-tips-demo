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

    @Test
    void shouldCreatePostWithMentionedUsers() throws Exception {
        this.mockMvc.perform(
                post("/posts")
                        .header("userId", userId)
                        .content("""
                                {"text": "Sample post",
                                "mentionedUsers": [
                                	"5d6101d3-d7b2-4eab-aedf-9cacf19713bb",
                                	"90d32548-b10d-4746-bbfe-8494217e504d",
                                	"1ed15d33-74b3-4271-80f0-231762158790",
                                	"9ce98893-71fb-4061-ba63-4bbd5bcb5aab"
                                ]}
                                """)
                        .contentType(MediaType.APPLICATION_JSON));
    }

}
