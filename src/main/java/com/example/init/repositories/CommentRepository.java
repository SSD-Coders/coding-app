package com.example.init.repositories;

import com.example.init.models.Comment;
import com.example.init.models.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CommentRepository  extends JpaRepository<Comment , Long> {
//    List<Post> findByPost(Post post, Sort sort);
}
