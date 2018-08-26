package com.codurance.training.instruction;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class AddProject implements Instruction {
    private String projectId;

    public AddProject(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        tasks.addProject(projectId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProject that = (AddProject) o;
        return Objects.equals(projectId, that.projectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }

    @Override
    public String toString() {
        return "AddProject{" +
                "projectId='" + projectId + '\'' +
                '}';
    }
}
