package com.codurance.training.exceptions;

public class TaskNotFoundException extends Exception {
    private String taskId;

    public TaskNotFoundException(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String getMessage() {
        return String.format("Could not find a task with an ID of %s.", taskId);
    }
}
