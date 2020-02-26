package com.minecraftportable.TDTg.event.service;

import com.minecraftportable.TDTg.event.entity.Event;
import com.baomidou.mybatisplus.extension.service.IService;
import com.minecraftportable.TDTg.event.entity.EventAddVO;
import com.minecraftportable.TDTg.event.entity.EventDeleteVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
public interface IEventService extends IService<Event> {
    int addEvent(EventAddVO eventAddVO);
    boolean deleteEvent(EventDeleteVO eventDeleteVO);
}
