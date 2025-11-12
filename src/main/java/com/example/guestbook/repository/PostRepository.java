package com.example.guestbook.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.guestbook.entity.Post;
public interface PostRepository extends JpaRepository<Post, Long> {}