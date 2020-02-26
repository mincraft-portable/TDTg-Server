package com.minecraftportable.TDTg.user.controller;


import com.minecraftportable.TDTg.base.entity.Result;
import com.minecraftportable.TDTg.user.entity.User;
import com.minecraftportable.TDTg.user.entity.UserSignInVO;
import com.minecraftportable.TDTg.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
@Api(value = "用户api",tags = "用户api")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public Result userLogin(@RequestParam("deviceId")String deviceId){
        User user = iUserService.IsUserExist(deviceId);
        if (user != null){
            return new Result().success(user);
        }else{
            return new Result().fail("User not exist",50001);
        }
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/signIn")
    public Result userSignIn(@RequestBody UserSignInVO userSignInVO){
        System.out.println("test,vo:"+userSignInVO);
        if (iUserService.UserSignIn(userSignInVO)){
            return new Result().success();
        }else{
            return new Result().fail("User already existed",50002);
        }

    }
}
