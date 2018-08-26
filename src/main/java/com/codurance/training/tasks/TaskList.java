package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskList {

    private Map<String, List<Task>> tasks;

    public TaskList() {
        tasks = new LinkedHashMap<>();
    }

    public Map<String, List<Task>> getTasks() {
        return tasks;
    }

    public void addProject(String projectName) {
        tasks.put(projectName, new ArrayList<>());
    }

    public String[] getProjects() {
        return tasks.keySet().toArray(new String[]{});
    }
}
