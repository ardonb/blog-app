package com.ardonb.springbootblogapp.controller;

import com.ardonb.springbootblogapp.model.Post;
import com.ardonb.springbootblogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model){
        Optional<Post> optionalPost = postService.getById(id);

        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            return "post";
        } else {
            return "404";
        }
    }
}
