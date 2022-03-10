package nh.graphql.blogexample.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogService {

  private UserRepository userRepository;
  private PostRepository postRepository;

  public BlogService(UserRepository userRepository, PostRepository postRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  public Post addPost(String userId, String title, String body) {
    return null;
  }

  @Transactional
  public Comment addComment(String userId, String postId, String comment) {
    User user = userRepository.findById(userId).orElseThrow();
    Post post = postRepository.findById(postId).orElseThrow();

    Comment addedComment = post.addComment(user, comment);
    postRepository.save(post);

    return addedComment;
  }

}
