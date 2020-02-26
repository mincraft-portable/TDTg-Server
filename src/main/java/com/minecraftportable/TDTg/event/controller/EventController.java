package com.minecraftportable.TDTg.event.controller;


import com.minecraftportable.TDTg.base.entity.Result;
import com.minecraftportable.TDTg.event.entity.Event;
import com.minecraftportable.TDTg.event.entity.EventAddVO;
import com.minecraftportable.TDTg.event.entity.EventDeleteVO;
import com.minecraftportable.TDTg.event.service.IEventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zeshawn
 * @since 2020-02-25
 */
@Api(value = "事件api",tags = "事件api")
@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    IEventService iEventService;

    @ApiOperation(value = "添加事件")
    @PostMapping
    public Result addEvent(@RequestBody EventAddVO eventAddVO){
        int eventId = iEventService.addEvent(eventAddVO);
        if (eventId !=-1){
            return new Result().success(eventId);
        }else{
            return new Result().fail("Event add fail",50011);
        }
    }

    @ApiOperation(value = "删除事件")
    @DeleteMapping
    public Result deleteEvent(@RequestBody EventDeleteVO eventDeleteVO){
        if (iEventService.deleteEvent(eventDeleteVO)){
            return new Result().success();
        }else{
            return new Result().fail("Event delete fail",50012);
        }
    }

    @ApiOperation(value = "修改事件")
    @PutMapping
    public Result modifyEvent(@RequestBody Event event){

        return iEventService.updateById(event)?new Result().success():new Result().fail("modify event fail",50013);
    }

    @ApiOperation(value = "获取事件信息")
    @GetMapping
    public Result getEvent(@RequestParam("eventId") Integer eventId){
        Event event = iEventService.getById(eventId);
        return event==null?new Result().fail("event does not exist",50010):new Result().success(event);
    }


}
