package com.green.boardver5.board;

import com.green.boardver5.board.model.*;
import com.green.boardver5.common.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int postBoard(PostBoard p);
    int delBoard(DelBoard boardId);
    int putBoard(PutBoard p);
    List<GetBoardList> getBoardList(Paging p);
    GetBoardOne getBoardOne(long boardId);
    int patchBoardHits(long p);
}
