package com.minecraftportable.TDTg.event.service.impl;

import com.minecraftportable.TDTg.event.entity.Event;
import com.minecraftportable.TDTg.event.entity.EventAddVO;
import com.minecraftportable.TDTg.event.entity.EventDeleteVO;
import com.minecraftportable.TDTg.event.mapper.EventMapper;
import com.minecraftportable.TDTg.event.service.IEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minecraftportable.TDTg.eventUser.entity.EventUser;
import com.minecraftportable.TDTg.eventUser.mapper.EventUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements IEventService {

    @Autowired
    EventMapper eventMapper;

    @Autowired
    EventUserMapper eventUserMapper;


    @Override
    public int addEvent(EventAddVO eventAddVO) {
        try {
            Event event = new Event();
            event.setEventInfo(eventAddVO.getEventInfo());
            event.setEventStatus(true);
            event.setEventTitle(eventAddVO.getEventTitle());
            event.setEventCreator(eventAddVO.getUserToken());
            eventMapper.insert(event);
            int eventId =event.getEventId();
            System.out.println(eventId);
            EventUser eventUser = new EventUser();
            eventUser.setEventId(eventId);
            eventUser.setUserId(eventAddVO.getUserToken());
            eventUserMapper.insert(eventUser);
            return eventId;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public boolean deleteEvent(EventDeleteVO eventDeleteVO) {
        String userToken = eventDeleteVO.getUserToken();
        Integer eventId = eventDeleteVO.getEventId();
        Event event = eventMapper.selectById(eventId);
        if (event == null) return false;
        if (event.getEventCreator().equals(userToken)){
            eventMapper.deleteById(eventId);
            return true;
        }
        return false;
    }
}
