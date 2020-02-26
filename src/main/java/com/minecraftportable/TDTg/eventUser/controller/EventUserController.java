package com.minecraftportable.TDTg.eventUser.controller;


import com.minecraftportable.TDTg.base.entity.Result;
import com.minecraftportable.TDTg.eventUser.entity.EventUser;
import com.minecraftportable.TDTg.eventUser.service.IEventUserService;
import io.swagger.annotations.Api;
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
@Api(value = "事件用户api",tags = "事件用户api")
@RestController
@RequestMapping("/eventUser")
public class EventUserController {

    @Autowired
    IEventUserService iEventUserService;

    @ApiOperation(value = "获取一个事件的全部参与用户")
    @GetMapping
    public Result getEventUser(@RequestParam("eventId") Integer eventId){
        return new Result().success(iEventUserService.getUsersByEvent(eventId));
    }

    @ApiOperation(value = "为指定事件添加指定用户")
    @PostMapping
    public Result addEventUser(@RequestBody EventUser eventUser){
        return iEventUserService.save(eventUser)?new Result().success():new Result().fail("invite user error",50020);
    }

    @ApiOperation(value = "删除某事件中的一个用户")
    @DeleteMapping
    public Result delEventUser(@RequestBody EventUser eventUser){
        return iEventUserService.removeById(eventUser)?new Result().success():new Result().fail("exit event error",50021);
    }



}
