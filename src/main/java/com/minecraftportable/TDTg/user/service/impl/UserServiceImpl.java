package com.minecraftportable.TDTg.user.service.impl;

import com.minecraftportable.TDTg.user.entity.User;
import com.minecraftportable.TDTg.user.entity.UserSignInVO;
import com.minecraftportable.TDTg.user.mapper.UserMapper;
import com.minecraftportable.TDTg.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User IsUserExist(String deviceId) {
        String userToken = DigestUtils.md5DigestAsHex(deviceId.getBytes()).substring(8,24);
        return userMapper.selectById(userToken);
    }

    @Override
    public boolean UserSignIn(UserSignInVO userSignInVO) {
        String userToken = DigestUtils.md5DigestAsHex(userSignInVO.getDeviceId().getBytes()).substring(8,24);
        if(userMapper.selectById(userToken) == null){
            User user = new User();
            user.setUserName(userSignInVO.getUserName());
            user.setUserToken(userToken);
            userMapper.insert(user);
            return true;
        }
        return false;
    }
}
