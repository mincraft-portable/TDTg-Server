package com.minecraftportable.TDTg.eventUser.service;

import com.minecraftportable.TDTg.eventUser.entity.EventUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.minecraftportable.TDTg.user.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
public interface IEventUserService extends IService<EventUser> {
    List<User> getUsersByEvent(Integer eventId);
}
