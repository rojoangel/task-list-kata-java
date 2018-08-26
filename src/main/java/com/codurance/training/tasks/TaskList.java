package com.codurance.training.tasks;

import com.codurance.training.exceptions.ProjectNotFoundException;
import com.codurance.training.exceptions.TaskNotFoundException;
import com.codurance.training.projects.Project;

import java.util.*;

public class TaskList {

    private long lastId = 0;

    private List<Project> projects;
    private Map<Long, Task> tasksById;

    public TaskList() {
        projects = new ArrayList<>();
        tasksById = new HashMap<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(String name) {
        projects.add(new Project(name));
    }

    public void addTask(String projectName, String taskDescription) throws ProjectNotFoundException{

        long nextId = nextId();
        Project project = findProjectByName(projectName);
        if (project == null) {
            throw new ProjectNotFoundException(projectName);
        }
        Task task = new Task(nextId, taskDescription);
        project.addTask(task);
        tasksById.put(task.getId(), task);
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

    public void markAsDone(String taskId) throws TaskNotFoundException {

        Task task = findTaskById(Long.parseLong(taskId));
        if (task == null) {
            throw new TaskNotFoundException(taskId);
        }
        task.done();
    }

    private Task findTaskById(Long id) {
        return tasksById.get(id);
    }

    public void markAsPending(String taskId) throws TaskNotFoundException {
        Task task = findTaskById(Long.parseLong(taskId));
        if (task == null) {
            throw new TaskNotFoundException(taskId);
        }
        task.pending();
    }
}
