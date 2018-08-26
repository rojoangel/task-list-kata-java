package com.codurance.training.projects;

import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {

    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) &&
                Objects.equals(tasks, project.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tasks);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
