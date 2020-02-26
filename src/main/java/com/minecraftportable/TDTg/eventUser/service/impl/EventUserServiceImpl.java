package com.minecraftportable.TDTg.eventUser.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.minecraftportable.TDTg.event.entity.Event;
import com.minecraftportable.TDTg.eventUser.entity.EventUser;
import com.minecraftportable.TDTg.eventUser.mapper.EventUserMapper;
import com.minecraftportable.TDTg.eventUser.service.IEventUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minecraftportable.TDTg.user.entity.User;
import com.minecraftportable.TDTg.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
@Service
public class EventUserServiceImpl extends ServiceImpl<EventUserMapper, EventUser> implements IEventUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EventUserMapper eventUserMapper;

    @Override
    public List<User> getUsersByEvent(Integer eventId) {
        List<EventUser> eventUserList = eventUserMapper.selectList(Wrappers.<EventUser>lambdaQuery().eq(EventUser::getEventId,eventId));
        List<User> userList = new ArrayList<>();
        for (EventUser e:eventUserList) {
            User user = userMapper.selectById(e.getUserId());
            userList.add(user);
        }
        return userList;
    }
}
