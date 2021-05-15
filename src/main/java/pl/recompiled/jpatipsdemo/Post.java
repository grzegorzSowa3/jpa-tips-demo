package pl.recompiled.jpatipsdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Getter
@NoArgsConstructor(access = PRIVATE)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private UUID author;
    private String text;

    public static Post newInstance(UUID author, String text) {
        Post post = new Post();
        post.author = author;
        post.text = text;
        return post;
    }

}
