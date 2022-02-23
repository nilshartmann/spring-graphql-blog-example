package nh.graphql.blogexample.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Comment {

  @Id
  private String id;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  private Post post;

  @OneToOne(fetch = FetchType.LAZY)
  @NotNull
  private User writtenBy;

  @NotNull
  private LocalDateTime createdAt;

  private String comment;

  protected Comment() {}

  public Comment(String id, Post post, User writtenBy, String comment) {
    this.id = id;
    this.post = post;
    this.writtenBy = writtenBy;
    this.comment = comment;
    this.createdAt = LocalDateTime.now();
  }

  public User getWrittenBy() {
    return writtenBy;
  }

  public String getComment() {
    return comment;
  }
}
