package com.example.guestbook.service;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.guestbook.entity.Post;
import com.example.guestbook.repository.PostRepository;
@Service
public class PostService {
    private final PostRepository repo;
    public PostService(PostRepository repo) { this.repo = repo; }
    public List<Post> list() { return repo.findAll(); }
    public Post save(Post post) { return repo.save(post); }
    public Post get(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
}