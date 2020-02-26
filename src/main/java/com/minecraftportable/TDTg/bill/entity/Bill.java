package com.minecraftportable.TDTg.bill.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "账单",description = "账单对象")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "bill_id", type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private Integer billId;

    @ApiModelProperty(value = "事件id",example = "10",required = true)
    private Integer eventId;

    @ApiModelProperty(value = "用户id",example = "388a4cdc5051cd95",required = true)
    private String userId;

    @ApiModelProperty(value = "todo id",example = "1",required = true)
    private Integer todoId;

    @ApiModelProperty(value = "金额",example = "12.6",required = true)
    private BigDecimal todoPrice;


}
