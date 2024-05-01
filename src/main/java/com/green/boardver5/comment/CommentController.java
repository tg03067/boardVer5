package com.green.boardver5.comment;

import com.green.boardver5.comment.model.*;
import com.green.boardver5.common.Paging;
import com.green.boardver5.common.ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {
    private final CommentService service;

    @PostMapping
    public ResultDto<Integer> postComment(@RequestBody PostComment p){
        int result = service.postComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @PutMapping
    public ResultDto<Integer> putComment(@RequestBody PutComment p){
        int result = service.putComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @DeleteMapping
    public ResultDto<Integer> delComment(@ModelAttribute("commentId")DelComment p){
        int result = service.delComment(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @GetMapping
    public ResultDto<List<GetCommentList>> getComment(@ModelAttribute CommentPaging p){
        List<GetCommentList> list = service.getComment(p);

        String row = String .format("row: %d", list.size());

        if(list.size() > 0 && p.getSize() != list.size()){
            row += String.format(", totalRow: %d", (p.getPage() - 1) * p.getSize() + list.size() ) ;
        }

        return ResultDto.<List<GetCommentList>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(row).
                resultData(list).build();
    }
}
//list.size > 0