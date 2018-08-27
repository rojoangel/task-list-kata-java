package com.codurance.training.tasks;

import com.codurance.training.exceptions.ProjectNotFoundException;
import com.codurance.training.exceptions.TaskNotFoundException;
import com.codurance.training.projects.Project;

import java.util.*;

public class TaskList {

    private long lastId = 0;

    private List<Project> projects;

    public TaskList() {
        projects = new ArrayList<>();
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
        for (Project project : projects) {
            for (Task task : project.getTasks()) {
                if (id.equals(task.getId())) {
                    return task;
                }
            }
        }
        return null;
    }

    public void markAsPending(String taskId) throws TaskNotFoundException {
        Task task = findTaskById(Long.parseLong(taskId));
        if (task == null) {
            throw new TaskNotFoundException(taskId);
        }
        task.pending();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(projects, taskList.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projects);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                ", projects=" + projects +
                '}';
    }
}
