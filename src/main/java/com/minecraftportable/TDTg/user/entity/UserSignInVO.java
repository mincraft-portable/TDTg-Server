package com.minecraftportable.TDTg.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: xzx
 * @Description:
 * @Date: Created in 17:03 2020/2/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserSignInVO {
    private static final long serialVersionUID = 1L;

    private String deviceId;

    private String userName;


}
