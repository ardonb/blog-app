package com.ardonb.springbootblogapp.config;

import com.ardonb.springbootblogapp.model.Post;
import com.ardonb.springbootblogapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception{
        List<Post> posts = postService.getAll();

        if(posts.size() == 0){
            Post post1 = new Post();
            post1.setTitle("Title of the post");
            post1.setBody(("This is the body of the post 1"));

            Post post2 = new Post();

            post2.setTitle("Title of the post 2");
            post2.setBody(("This is the body of the post 2"));

            postService.save(post1);
            postService.save(post2);
        }
    }

}
