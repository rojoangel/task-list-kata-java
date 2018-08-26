package com.codurance.training.tasks;

import com.codurance.training.exceptions.ProjectNotFoundException;
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
        projects.add(new Project(name));

        // parallel change to be removed
        tasks.put(name, new ArrayList<>());
    }

    public void addTask(String projectName, String taskDescription) throws ProjectNotFoundException{

        Project project = findProjectByName(projectName);
        if (project == null) {
            throw new ProjectNotFoundException(projectName);
        }
        project.addTask(new Task(1, taskDescription, false));

        // parallel change to be removed
        List<Task> projectTasks = getTasks().get(projectName);

        if (projectTasks == null) {
            throw new ProjectNotFoundException(projectName);
        }
        projectTasks.add(new Task(nextId(), taskDescription, false));

    }

    private long nextId() {
        return ++TaskListApplication.LAST_ID;
    }

    private Project findProjectByName(String projectName) {
        return projects.stream()
                .filter(project -> projectName.equals(project.getName()))
                .findAny()
                .orElse(null);
    }
}
