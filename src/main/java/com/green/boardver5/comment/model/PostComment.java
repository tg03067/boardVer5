package com.green.boardver5.comment.model;

import lombok.Data;

@Data
public class PostComment {
    private String contents;
    private long writerId;
    private long boardId;
}
