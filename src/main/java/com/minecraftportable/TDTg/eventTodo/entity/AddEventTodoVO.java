package com.minecraftportable.TDTg.eventTodo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: xzx
 * @Description:
 * @Date: Created in 22:37 2020/2/25
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class AddEventTodoVO {
    private Integer eventId;

    private String todoName;
}
