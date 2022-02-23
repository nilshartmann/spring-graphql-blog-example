package nh.graphql.blogexample.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class Post {

  @Id
  private String id;

  @NotNull
  private String title;

  @NotNull
  private String body;

  @OneToOne(fetch = FetchType.LAZY)
  @NotNull
  private User writtenBy;

  @NotNull
  private LocalDateTime createdAt;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Comment> comments = new LinkedList<>();

  protected Post() {}

  public Post(String id, User user, String title, String body) {
    this.id = id;
    this.writtenBy = user;
    this.title = title;
    this.body = body;
    this.createdAt = LocalDateTime.now();
  }

  public Comment addComment(User user, String comment) {
    Comment newComment = new Comment(
      UUID.randomUUID().toString(),
      this,
      user, comment);
    this.comments.add(newComment);

    return newComment;
  }

  public String getId() {
    return id;
  }

  public User getWrittenBy() {
    return writtenBy;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }
}
