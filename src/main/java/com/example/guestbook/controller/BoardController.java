package com.example.guestbook.controller;

import com.example.guestbook.entity.Post;
import com.example.guestbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public String list(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "list";
    }

    @GetMapping("/posts/new")
    public String form(Model model) {
        model.addAttribute("post", new Post());
        return "form"; 
}
    @PostMapping("/posts")
    public String save(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/posts"; 
    }

    @GetMapping("/posts/{id}")
    public String view(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "view"; 
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/posts";
    }
}
