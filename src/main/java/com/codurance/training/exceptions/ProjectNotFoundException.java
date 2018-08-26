package com.codurance.training.exceptions;

public class ProjectNotFoundException extends Exception {
    private String projectName;

    public ProjectNotFoundException(String projectName) {
        this.projectName = projectName;
    }
}
