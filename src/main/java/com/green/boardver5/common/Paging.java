package com.green.boardver5.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

@Data
public class Paging {
    private int page ;
    private int size ;

    public Paging(Integer page, Integer size){
        this.page = page == null ? 0 : page ;
        this.size = size == null ? 10 : size ;
        this.startIdx = ( this.page - 1 ) < 0 ?  0 : ( this.page - 1 ) * this.size ;
    }
    @JsonIgnore
    private int startIdx ;
}
