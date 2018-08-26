package com.codurance.training.instruction;

import com.codurance.training.exceptions.ProjectNotFoundException;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.Objects;

public class AddTask implements Instruction {

    private final String projectName;
    private final String taskDescription;

    public AddTask(String projectName, String taskDescription) {
        this.projectName = projectName;
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        try {
            tasks.addTask(projectName, taskDescription);
        } catch(ProjectNotFoundException ex) {
            out.printf("Could not find a project with the name \"%s\".", projectName);
            out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTask addTask = (AddTask) o;
        return Objects.equals(projectName, addTask.projectName) &&
                Objects.equals(taskDescription, addTask.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, taskDescription);
    }

    @Override
    public String toString() {
        return "AddTask{" +
                "projectName='" + projectName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
