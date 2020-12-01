package com.example.demo.toDoList;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    List<Task> tasks = new ArrayList<>(Arrays.asList(
            new Task(1L, "take out the rubbish", Status.TO_DO, LocalDateTime.now()),
            new Task(2L, "wash the dishes", Status.DONE, LocalDateTime.now()),
            new Task(3L, "vacuum", Status.IN_PROGRESS, LocalDateTime.now())
    ));

    @Override
    public List<Task> getTasksList(TaskStatusDTO taskStatusDTO) {
        return tasks.stream()
                .filter(task -> {
                    if(taskStatusDTO.getStatus() != null){
                        return task.getStatus().equals(taskStatusDTO.getStatus());
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Task createTask(TaskDataDTO taskDataDTO) {
        Long id = tasks.stream()
                .map(Task::getId)
                .max(Comparator.comparingLong(a -> a))
                .orElse(0L) + 1L;
        Task task = new Task(id, taskDataDTO.getWhatToDo(), taskDataDTO.getStatus(), LocalDateTime.now());
        tasks.add(task);
        return task;
    }

    @Override
    public Task updateTask(Long id, TaskDataDTO taskDataDTO) {
        Task taskToUpdate = getTaskById(id);
        taskToUpdate.setWhatToDo(taskDataDTO.getWhatToDo());
        taskToUpdate.setStatus(taskDataDTO.getStatus());
        taskToUpdate.setModificationTime(LocalDateTime.now());
        return taskToUpdate;
    }

    @Override
    public Task deleteTask(Long id) {
        Task taskToDelete = getTaskById(id);
        tasks.remove(taskToDelete);
        return taskToDelete;
    }

    private Task getTaskById(Long id){
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found with id:" + id));
    }
}
