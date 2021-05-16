package pl.recompiled.jpatipsdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@RequiredArgsConstructor
class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final UUID userId;
    private final String message;
    private final String url;

}