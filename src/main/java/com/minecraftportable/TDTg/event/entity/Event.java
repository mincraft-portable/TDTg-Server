package com.minecraftportable.TDTg.event.entity;

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
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "event_id", type = IdType.AUTO)
    private Integer eventId;

    private String eventTitle;

    private String eventInfo;

    private Boolean eventStatus;

    private String eventCreator;


}
