package com.green.boardver5.board;

import com.green.boardver5.board.model.*;
import com.green.boardver5.common.Paging;
import com.green.boardver5.common.ResultDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.jta.UserTransactionAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ResultDto<Integer> postBoard(@RequestBody PostBoard p){
        int result = service.postBoard(p);
        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @DeleteMapping
    public ResultDto<Integer> delBoard(@ModelAttribute DelBoard boardId){
        int result = service.delBoard(boardId);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @PutMapping
    public ResultDto<Integer> putBoard(@RequestBody PutBoard p){
        int result = service.putBoard(p);

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @GetMapping
    public ResultDto<List<GetBoardList>> getBoardList(@ModelAttribute Paging p){
        List<GetBoardList> list = service.getBoardList(p);

        return ResultDto.<List<GetBoardList>>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(list).build();
    }
    @GetMapping("board_id")
    public ResultDto<GetBoardOne> getBoardOne(@ModelAttribute(name = "boardId") long boardId){
        GetBoardOne result = service.getBoardOne(boardId);

        return ResultDto.<GetBoardOne>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
}
