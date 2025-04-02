package io.sparta.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "p_post")
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Setter
    @Column(nullable = false)
    private boolean deleted = false;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
        this.updatedAt = updatedAt;
    }

}
