package com.green.boardver5.user;

import com.green.boardver5.common.ResultDto;
import com.green.boardver5.user.model.PatchUserPassword;
import com.green.boardver5.user.model.UserEntity;
import com.green.boardver5.user.model.PostUser;
import com.green.boardver5.user.model.UserSignIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService service;

    @PostMapping("SignUp")
    public ResultDto<Integer> postUser(@RequestBody PostUser p){
        int result = service.postUser(p);

        return ResultDto.<Integer>builder().httpStatus(HttpStatus.OK).
                resultMsg(HttpStatus.OK.toString()).
                resultData(result).build();
    }
    @PostMapping("SignIn")
    public ResultDto<Integer> getUserById(@RequestBody UserSignIn p){
        int result = service.getUserById(p);

        String Msg = switch (result){
            case 1 -> "로그인 성공";
            case 2 -> "아이디 확인";
            case 3 -> "비밀번호 확인";
            default -> "ERROR";
        };

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(Msg).
                resultData(result).build();
    }
    @PatchMapping("PatchPassword")
    public ResultDto<Integer> patchUserPassword(@RequestBody PatchUserPassword p){
        int result = service.patchUserPassword(p);

        String Msg = switch (result){
            case 1 -> "비밀번호 변경 성공";
            case 2 -> "아이디를 확인해 주세요";
            case 3 -> "기존 비밀번호를 확인해 주세요";
            default -> "ERROR";
        };

        return ResultDto.<Integer>builder().
                httpStatus(HttpStatus.OK).
                resultMsg(Msg).
                resultData(result).build();
    }
}
