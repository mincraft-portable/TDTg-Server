package com.minecraftportable.TDTg.eventTodo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EventTodo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "event_todo_id", type = IdType.AUTO)
    private Integer eventTodoId;

    private Integer eventId;

    private String todoName;

    private Boolean status;


}
