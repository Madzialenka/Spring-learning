package com.example.demo.toDoList;

import java.time.LocalDateTime;

public class TaskDataDTO {
    private String whatToDo;
    private Status status;

    public TaskDataDTO() {
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
