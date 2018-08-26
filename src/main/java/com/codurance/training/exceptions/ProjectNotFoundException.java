package com.codurance.training.exceptions;

public class ProjectNotFoundException extends Exception {
    private String projectName;

    public ProjectNotFoundException(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String getMessage() {
        return String.format("Could not find a project with the name \"%s\".", projectName);
    }
}
