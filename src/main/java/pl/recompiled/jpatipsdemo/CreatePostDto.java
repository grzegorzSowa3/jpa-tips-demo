package pl.recompiled.jpatipsdemo;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreatePostDto {

    private String text;
    private List<UUID> mentionedUsers;

}
