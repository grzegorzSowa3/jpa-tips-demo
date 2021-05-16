package pl.recompiled.jpatipsdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Long createPost(UUID userId, CreatePostDto dto) {
        final Post post = Post.newInstance(userId, dto.getText());
        return postRepository.save(post).getId();
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(NotFoundException::new);
    }

}
