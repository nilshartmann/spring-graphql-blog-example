package nh.graphql.blogexample.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, String> {

  Optional<Post> findFirstByOrderByCreatedAtDesc();
}
