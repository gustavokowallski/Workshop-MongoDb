package com.workshop.mongodb.config;

import com.workshop.mongodb.models.entities.Post;
import com.workshop.mongodb.models.entities.User;
import com.workshop.mongodb.models.entities.embedded.Author;
import com.workshop.mongodb.models.entities.embedded.Comment;
import com.workshop.mongodb.repositories.PostRepository;
import com.workshop.mongodb.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    private final UserRepository userRepository;
    private PostRepository postRepository;

    public TestConfig(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void init(){
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, new Author(maria), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", Instant.parse("2021-02-13T11:15:01Z"));
        Post post2 = new Post(null, new Author(maria), "Bom dia", "Acordei feliz hoje!", Instant.parse("2021-02-13T11:15:01Z"));

        Comment c1 = new Comment("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Author(alex));
        Comment c2 = new Comment("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Author(bob));
        Comment c3 = new Comment("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Author(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}
