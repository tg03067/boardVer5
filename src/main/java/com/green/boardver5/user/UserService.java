package com.green.boardver5.user;

import com.green.boardver5.user.model.PatchUserPassword;
import com.green.boardver5.user.model.UserEntity;
import com.green.boardver5.user.model.PostUser;
import com.green.boardver5.user.model.UserSignIn;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public int postUser(PostUser p){
        String hashPassword = BCrypt.hashpw(p.getUpw(), BCrypt.gensalt());
        p.setUpw(hashPassword);
        return mapper.postUesr(p);
    }
    public int getUserById(UserSignIn p){
        UserEntity entity = mapper.getUserById(p.getUid());

        if(entity == null ){ // 아이디 확인
            return 2;
        }
        if(!BCrypt.checkpw(p.getUpw(), entity.getUpw())){ // 비밀번호 확인
            return 3;
        }
        return 1;
    }
    public int patchUserPassword(PatchUserPassword p){
        UserEntity entity = mapper.getUserById(p.getUid());

        if (entity == null){ //아이디를 확인해 주세요
            return 2;
        }
        if (!BCrypt.checkpw(p.getCurrentPw(), entity.getUpw())){ //기존 비밀번호 확인
            return 3;
        }

        String hashPassword = BCrypt.hashpw(p.getNewPw(), BCrypt.gensalt());
        p.setNewPw(hashPassword);
        p.setUserId(entity.getUserId());
        return mapper.patchUserPassword(p);
    }
}
