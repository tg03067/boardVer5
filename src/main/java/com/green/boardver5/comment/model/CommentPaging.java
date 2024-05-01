package com.green.boardver5.comment.model;

import com.green.boardver5.common.Paging;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class CommentPaging extends Paging {
    private long boardId;

    public CommentPaging(Integer page, Integer size, long boardId){
        super(page, size);
        this.boardId = boardId;
    }
}
