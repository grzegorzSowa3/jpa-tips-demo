package pl.recompiled.jpatipsdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final NotificationRepository notificationRepository;

    public UUID createPost(UUID userId, CreatePostDto dto) {
        final Post post = Post.newInstance(userId, dto.getText());
        final UUID postId = postRepository.save(post).getId();
        if (dto.getMentionedUsers()!= null && ! dto.getMentionedUsers().isEmpty()) {
            final List<Notification> notifications = dto.getMentionedUsers().stream()
                    .map(user -> new Notification(user, "You are mentioned in a post!",
                            String.format("https://localhost:8080/posts/%s", post.getId())))
                    .collect(Collectors.toList());
            notificationRepository.saveAll(notifications);
        }
        return postId;
    }

    public Post getPost(UUID postId) {
        return postRepository.findById(postId).orElseThrow(NotFoundException::new);
    }

}
