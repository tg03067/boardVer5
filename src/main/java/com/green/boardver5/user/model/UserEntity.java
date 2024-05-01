package com.green.boardver5.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private long userId;
    private String uid;
    private String upw;
    private String nm;
    private String createdAt;
    private String updatedAt;
}
