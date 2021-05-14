package pl.recompiled.jpatipsdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor(access = PRIVATE)
public class Post {

    @Id
    private UUID id;
    private UUID author;
    private String text;

    public static Post newInstance(UUID author, String text) {
        Post post = new Post();
        post.id = UUID.randomUUID();
        post.author = author;
        post.text = text;
        return post;
    }

}
