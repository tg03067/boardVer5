package com.green.boardver5.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PatchUserPassword {
    @JsonIgnore
    private long userId;

    private String uid;
    private String newPw;
    private String currentPw;
}
