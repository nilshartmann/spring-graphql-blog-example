package nh.graphql.blogexample.graphql;

import nh.graphql.blogexample.domain.BlogService;
import nh.graphql.blogexample.domain.Post;
import nh.graphql.blogexample.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class B {

  @Autowired
  BlogService blogService;

  record NewPostInput(@Size(max=50) String title, String body){}

  record NewPostSuccess(Post newPost) {}

  record NewPostFailed(String error) {}

//  @MutationMapping
//  @PreAuthorized("hasRole('ROLE_USER')")
//  public Object newPost(@Valid @Argument NewPostInput input,
//                        @AuthenticationPrincipal User user) {
//    try {
//      Post newPost = blogService.addPost(
//        user.getId(),
//        input.title(),
//        input.body()
//      );
//
//      return new NewPostSuccess(newPost);
//    } catch (Exception ex) {
//      return new NewPostFailed(ex.getMessage());
//    }
//  }

}
