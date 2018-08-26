package com.codurance.training.tasks;

import com.codurance.training.exceptions.ProjectNotFoundException;
import com.codurance.training.projects.Project;

import java.util.*;

public class TaskList {

    private long lastId = 0;

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
        projects.add(new Project(name));

        // parallel change to be removed
        tasks.put(name, new ArrayList<>());
    }

    public void addTask(String projectName, String taskDescription) throws ProjectNotFoundException{

        long nextId = nextId();
        Project project = findProjectByName(projectName);
        if (project == null) {
            throw new ProjectNotFoundException(projectName);
        }
        project.addTask(new Task(nextId, taskDescription, false));

        // parallel change to be removed
        List<Task> projectTasks = getTasks().get(projectName);

        if (projectTasks == null) {
            throw new ProjectNotFoundException(projectName);
        }
        projectTasks.add(new Task(nextId, taskDescription, false));

    }

    private long nextId() {
        return ++lastId;
    }

    private Project findProjectByName(String projectName) {
        return projects.stream()
                .filter(project -> projectName.equals(project.getName()))
                .findAny()
                .orElse(null);
    }
}
