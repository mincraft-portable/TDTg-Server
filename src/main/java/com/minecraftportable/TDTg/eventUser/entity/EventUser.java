package com.minecraftportable.TDTg.eventUser.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class EventUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "event_user_id",type = IdType.AUTO)
    private Integer eventUserId;

    private Integer eventId;

    private String userId;


}
