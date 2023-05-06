package com.example.dummy;

public class Task {
    public String task;
    public Boolean isDone;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Task(String task, Boolean isDone) {
        this.task = task;
        this.isDone = isDone;
    }
}
