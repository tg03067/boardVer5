package com.green.boardver5.board.model;

import lombok.Data;

@Data
public class GetBoardOne {
    private String contents;
    private long boardId;
    private String title;
    private String writerId;
    private String writerNm;
    private long hits;
    private String createdAt;
    private String updatedAt;
}
