package nh.graphql.blogexample.graphql;

import nh.graphql.blogexample.domain.BlogService;
import nh.graphql.blogexample.domain.Comment;
import nh.graphql.blogexample.domain.Post;
import nh.graphql.blogexample.domain.PostRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogGraphQLController {

  private PostRepository postRepository;
  private BlogService blogService;


  public BlogGraphQLController(PostRepository postRepository, BlogService blogService) {
    this.postRepository = postRepository;
    this.blogService = blogService;
  }

  @QueryMapping
  public List<Post> posts(@Argument Optional<Integer> size,
                          @Argument Optional<Integer> page) {
    Pageable pageable = PageRequest.of(
      page.orElse(0),
      size.orElse(10));
    return postRepository.findAll(pageable).getContent();
  }

  @SchemaMapping
  public String excerpt(Post post, @Argument int maxLength) {
    var body = post.getBody();
    if (body.length()<maxLength) {
      return body;
    }

    return body.substring(0, maxLength);
  }

  @QueryMapping
  public Optional<Post> post() {
    return postRepository.findFirstByOrderByCreatedAtDesc();
  }
//
  @MutationMapping
  public Comment newComment(@Argument NewCommentInput input) {
    return blogService.addComment(
      input.userId(),
      input.postId(),
      input.comment());
  }
}
