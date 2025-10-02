package com.workshop.mongodb.services;

import com.workshop.mongodb.dto.PostDTO;
import com.workshop.mongodb.exceptions.ResourceNotFoundException;
import com.workshop.mongodb.models.entities.Post;
import com.workshop.mongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public PostDTO findById(String id){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id does not exists"));

        return new PostDTO(post);
    }

    public List<PostDTO> findByTitle(String text){
        List<Post> posts = postRepository.searchTitle(text);
        return posts.stream().map(PostDTO::new).toList();
    }

    public List<PostDTO> fullSearch(String text, String start, String end){
        Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
        Instant endMoment = convertMoment(end, Instant.now());

        List<Post> posts = postRepository.fullSearch(text, startMoment, endMoment);
        return posts.stream().map(PostDTO::new).toList();
    }

    private Instant convertMoment(String originalString, Instant alternative) {
        try {
            return Instant.parse(originalString);

        } catch (Exception e) {
            return alternative;
        }
    }
}


