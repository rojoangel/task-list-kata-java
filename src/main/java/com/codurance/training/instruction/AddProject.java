package com.codurance.training.instruction;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.Objects;

public class AddProject implements Instruction {
    private String projectName;

    public AddProject(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        tasks.addProject(projectName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProject that = (AddProject) o;
        return Objects.equals(projectName, that.projectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName);
    }

    @Override
    public String toString() {
        return "AddProject{" +
                "projectName='" + projectName + '\'' +
                '}';
    }
}
