package com.example.demo.toDoList;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("toDoList")
@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasksList(TaskStatusDTO taskStatusDTO){
        return taskService.getTasksList(taskStatusDTO);
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDataDTO taskDataDTO){
        return taskService.createTask(taskDataDTO);
    }

    @PutMapping("{id}")
    public Task updateTask(@PathVariable("id") Long id, @RequestBody TaskDataDTO taskDataDTO){
        return taskService.updateTask(id, taskDataDTO);
    }

    @DeleteMapping("{id}")
    public Task deleteTask(@PathVariable("id") Long id){
        return taskService.deleteTask(id);
    }
}
