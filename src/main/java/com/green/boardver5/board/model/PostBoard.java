package com.green.boardver5.board.model;

import lombok.Data;

@Data
public class PostBoard {
    private String title;
    private String contents;
    private long writerId;
}
