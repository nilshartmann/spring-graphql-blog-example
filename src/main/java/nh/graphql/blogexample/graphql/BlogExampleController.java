package nh.graphql.blogexample.graphql;

import nh.graphql.blogexample.domain.BlogService;
import nh.graphql.blogexample.domain.Comment;
import nh.graphql.blogexample.domain.Post;
import nh.graphql.blogexample.domain.PostRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BlogExampleController {

  private PostRepository postRepository;
  private BlogService blogService;

  public BlogExampleController(PostRepository postRepository, BlogService blogService) {
    this.postRepository = postRepository;
    this.blogService = blogService;
  }

  @QueryMapping
  public List<Post> posts() {
    return postRepository.findAll();
  }

  @SchemaMapping
  public String excerpt(Post post, @Argument int maxLength) {
    return post.getBody().substring(0, maxLength);
  }

  record NewCommentInput(String userId, String postId, String comment) {}

  @MutationMapping
  public Comment newComment(@Argument NewCommentInput input) {
    return this.blogService.addComment(
      input.userId(),
      input.postId(),
      input.comment
    );
  }

}
