package nh.graphql.blogexample.graphql;

public record NewCommentInput(String userId, String postId, String comment) {
}
