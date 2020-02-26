package com.minecraftportable.TDTg.user.service;

import com.minecraftportable.TDTg.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.minecraftportable.TDTg.user.entity.UserSignInVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
public interface IUserService extends IService<User> {
    User IsUserExist(String deviceId);
    boolean UserSignIn(UserSignInVO userSignInVO);
}
