package nh.graphql.blogexample.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

  @Id
  private String id;

  @NotNull
  @Column(unique = true)
  private String username;

  @NotNull
  private String fullname;

  @NotNull
  private String password;

  protected User() {
  }

  public User(String id, String username, String fullname, String password) {
    this.id = id;
    this.username = username;
    this.fullname = fullname;
    this.password = password;
  }

  public String getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public String getFullname() {
    return fullname;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
}
