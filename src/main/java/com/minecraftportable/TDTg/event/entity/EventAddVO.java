package com.minecraftportable.TDTg.event.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: xzx
 * @Description:
 * @Date: Created in 17:31 2020/2/25
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class EventAddVO {
    private String eventTitle;
    private String eventInfo;
    private String userToken;

}
