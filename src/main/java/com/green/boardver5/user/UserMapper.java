package com.green.boardver5.user;

import com.green.boardver5.user.model.PatchUserPassword;
import com.green.boardver5.user.model.UserEntity;
import com.green.boardver5.user.model.PostUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUesr(PostUser p);
    UserEntity getUserById(String uid);
    int patchUserPassword(PatchUserPassword p);
}
