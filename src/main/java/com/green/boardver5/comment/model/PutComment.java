package com.green.boardver5.comment.model;

import lombok.Data;

@Data
public class PutComment {
    private String contents;
    private long writerId;
    private long commentId;
}
