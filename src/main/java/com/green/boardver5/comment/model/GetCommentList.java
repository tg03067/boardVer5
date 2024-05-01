package com.green.boardver5.comment.model;

import lombok.Data;

@Data
public class GetCommentList {
    private long boardId;
    private long commentId;
    private long writerId;
    private String contents;
    private String createdAt;
    private String updatedAt;
}
