package com.example.demo.toDoList;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String whatToDo;
    private Status status;
    private LocalDateTime modificationTime;

    public Task() {
    }

    public Task(Long id, String whatToDo, Status status, LocalDateTime modificationTime) {
        this.id = id;
        this.whatToDo = whatToDo;
        this.status = status;
        this.modificationTime = modificationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(LocalDateTime modificationTime) {
        this.modificationTime = modificationTime;
    }
}
