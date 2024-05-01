package com.green.boardver5.board;

import com.green.boardver5.board.model.*;
import com.green.boardver5.common.Paging;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    public final BoardMapper mapper;

    public int postBoard(PostBoard p){
        return mapper.postBoard(p);
    }
    public int delBoard(DelBoard boardId){
        return mapper.delBoard(boardId);
    }
    public int putBoard(PutBoard p){
        return mapper.putBoard(p);
    }
    public List<GetBoardList> getBoardList(Paging p){
        return mapper.getBoardList(p);
    }
    public GetBoardOne getBoardOne(long boardId){
        GetBoardOne result = mapper.getBoardOne(boardId);
        if(result != null){
            mapper.patchBoardHits(boardId);
        }
        return result;
    }
}
