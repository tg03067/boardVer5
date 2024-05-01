package com.green.boardver5.comment;

import com.green.boardver5.comment.model.*;
import com.green.boardver5.common.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper mapper;

    public int postComment(PostComment p){
        return mapper.postComment(p);
    }
    public int putComment(PutComment p){
        return mapper.putComment(p);
    }
    public int delComment(DelComment p){
        return mapper.delComment(p);
    }
    public List<GetCommentList> getComment(CommentPaging p){
        return mapper.getComment(p);
    }
}
