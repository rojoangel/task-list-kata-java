package com.codurance.training.tasks;

import com.codurance.training.projects.Project;

import java.util.*;

public class TaskList {

    private Map<String, List<Task>> tasks;
    private List<Project> projects;

    public TaskList() {
        tasks = new LinkedHashMap<>();
        projects = new ArrayList<>();
    }

    public Map<String, List<Task>> getTasks() {
        return tasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(String name) {
        tasks.put(name, new ArrayList<>());
        projects.add(new Project(name));
    }
}
