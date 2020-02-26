package com.minecraftportable.TDTg.event.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: xzx
 * @Description:
 * @Date: Created in 19:38 2020/2/25
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class EventDeleteVO {
    private Integer eventId;
    private String userToken;
}
