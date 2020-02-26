package com.minecraftportable.TDTg.eventTodo.service;

import com.minecraftportable.TDTg.eventTodo.entity.AddEventTodoVO;
import com.minecraftportable.TDTg.eventTodo.entity.EventTodo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
public interface IEventTodoService extends IService<EventTodo> {
    Integer addEventTodo(AddEventTodoVO addEventTodoVO);
    boolean finishEventTodo(Integer eventTodoId);
}
