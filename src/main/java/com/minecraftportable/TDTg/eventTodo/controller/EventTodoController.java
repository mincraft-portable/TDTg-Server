package com.minecraftportable.TDTg.eventTodo.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.minecraftportable.TDTg.base.entity.Result;
import com.minecraftportable.TDTg.eventTodo.entity.AddEventTodoVO;
import com.minecraftportable.TDTg.eventTodo.entity.EventTodo;
import com.minecraftportable.TDTg.eventTodo.service.IEventTodoService;
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
@Api(value = "事件待办api",tags = "事件待办api")
@RestController
@RequestMapping("/eventTodo")
public class EventTodoController {
    @Autowired
    IEventTodoService iEventTodoService;

    @ApiOperation(value = "获取事件的全部待办")
    @GetMapping
    private Result getEventTodoList(@RequestParam("eventId")Integer eventId){
        return new Result().success(iEventTodoService.list(Wrappers.<EventTodo>lambdaQuery().eq(EventTodo::getEventId,eventId)));
    }

    @ApiOperation(value = "为指定事件添加待办")
    @PostMapping
    private Result addEventTodo(@RequestBody AddEventTodoVO addEventTodoVO){
        Integer insertedId = iEventTodoService.addEventTodo(addEventTodoVO);
        return insertedId==-1?new Result().fail("add event todo fail",50030):new Result().success(insertedId);
    }

    @ApiOperation(value = "将一件事件待办标记为完成状态")
    @PutMapping
    private Result finishEventTodo(@RequestParam("eventTodoId")Integer id){
        return iEventTodoService.finishEventTodo(id)?new Result().success():new Result().fail("finish event todo fail",50031);
    }

    @ApiOperation(value = "删除事件待办")
    @DeleteMapping
    private Result deleteEventTodo(@RequestParam("eventTodoId")Integer id){
        return iEventTodoService.removeById(id)?new Result().success():new Result().fail("delete event todo fail",50032);
    }
}
