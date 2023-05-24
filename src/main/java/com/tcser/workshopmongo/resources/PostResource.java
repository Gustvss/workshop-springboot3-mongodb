package com.tcser.workshopmongo.resources;

import com.tcser.workshopmongo.dto.UserDTO;
import com.tcser.workshopmongo.entities.Post;
import com.tcser.workshopmongo.entities.User;
import com.tcser.workshopmongo.services.PostService;
import com.tcser.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> finById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}