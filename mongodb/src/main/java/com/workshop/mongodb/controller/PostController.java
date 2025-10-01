package com.workshop.mongodb.controller;

import com.workshop.mongodb.dto.PostDTO;
import com.workshop.mongodb.dto.UserDTO;
import com.workshop.mongodb.models.entities.Post;
import com.workshop.mongodb.services.PostService;
import com.workshop.mongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO>findById(@PathVariable String id){
        PostDTO postDTO = postService.findById(String.valueOf(id));
        return ResponseEntity.ok().body(postDTO);

    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>>findByTitle(@RequestParam(value = "text", defaultValue = "")String text){
        List<PostDTO> result = postService.findByTitle(text);
        return ResponseEntity.ok().body(result);

    }

    @GetMapping(value="/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="start", defaultValue="") String start,
            @RequestParam(value="end", defaultValue="") String end) {
        List<PostDTO> list = postService.fullSearch(text, start, end);
        return ResponseEntity.ok().body(list);
    }





}
