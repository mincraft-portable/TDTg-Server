package com.minecraftportable.TDTg.bill.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.minecraftportable.TDTg.base.entity.Result;
import com.minecraftportable.TDTg.bill.entity.Bill;
import com.minecraftportable.TDTg.bill.service.IBillService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-26
 */
@Api(value = "账单api",tags = "账单api")
@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    IBillService iBillService;

    @ApiOperation(value = "获取事件账单",notes = "通过事件id获取一个事件的全部账单")
    @ApiImplicitParam(name = "eventId",required = true,dataType = "int",paramType = "query")
    @GetMapping
    public Result getBillsByEvent(@RequestParam("eventId") Integer id){
        List<Bill> ret = iBillService.list(Wrappers.<Bill>lambdaQuery().eq(Bill::getBillId,id));
        return new Result().success(ret);
    }

    @ApiOperation(value = "添加账单",notes = "添加账单")
    @PostMapping
    public Result newBill(@RequestBody Bill bill){
        return iBillService.save(bill)?new Result().success():new Result().fail("bill create fail",50040);
    }


}
