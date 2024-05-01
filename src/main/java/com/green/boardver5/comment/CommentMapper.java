package com.green.boardver5.comment;

import com.green.boardver5.comment.model.*;
import com.green.boardver5.common.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int postComment(PostComment p);
    int putComment(PutComment p);
    int delComment(DelComment p);
    List<GetCommentList> getComment(CommentPaging p);
}
