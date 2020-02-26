package com.minecraftportable.TDTg.eventTodo.service.impl;

import com.minecraftportable.TDTg.eventTodo.entity.AddEventTodoVO;
import com.minecraftportable.TDTg.eventTodo.entity.EventTodo;
import com.minecraftportable.TDTg.eventTodo.mapper.EventTodoMapper;
import com.minecraftportable.TDTg.eventTodo.service.IEventTodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class EventTodoServiceImpl extends ServiceImpl<EventTodoMapper, EventTodo> implements IEventTodoService {

    @Autowired
    EventTodoMapper eventTodoMapper;

    @Override
    public Integer addEventTodo(AddEventTodoVO addEventTodoVO) {
        EventTodo eventTodo = new EventTodo();
        eventTodo.setEventId(addEventTodoVO.getEventId());
        eventTodo.setTodoName(addEventTodoVO.getTodoName());
        eventTodo.setStatus(true);
        if(eventTodoMapper.insert(eventTodo)==1){
            return eventTodo.getEventTodoId();
        }
        return -1;
    }

    @Override
    public boolean finishEventTodo(Integer eventTodoId) {
        EventTodo eventTodo = eventTodoMapper.selectById(eventTodoId);
        if (eventTodo != null){
            eventTodo.setStatus(false);
            return true;
        }
        return false;
    }
}
