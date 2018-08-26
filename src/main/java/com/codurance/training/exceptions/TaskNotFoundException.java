package com.codurance.training.exceptions;

public class TaskNotFoundException extends Exception {
    private String taskId;

    public TaskNotFoundException(String taskId) {
        this.taskId = taskId;
    }
}
