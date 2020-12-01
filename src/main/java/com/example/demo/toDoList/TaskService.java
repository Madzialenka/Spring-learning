package com.example.demo.toDoList;

import java.util.List;

public interface TaskService {

    List<Task> getTasksList(TaskStatusDTO taskStatusDTO);

    Task createTask(TaskDataDTO taskDataDTO);

    Task updateTask(Long id, TaskDataDTO taskDataDTO);

    Task deleteTask(Long id);
}
