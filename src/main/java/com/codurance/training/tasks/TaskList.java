package com.codurance.training.tasks;

import com.codurance.training.exceptions.ProjectNotFoundException;
import com.codurance.training.exceptions.TaskNotFoundException;
import com.codurance.training.projects.Project;

import java.util.*;

public class TaskList {

    private long lastId = 0;

    private Map<String, List<Task>> tasks;
    private List<Project> projects;
    private Map<Long, Task> tasksById;

    public TaskList() {
        projects = new ArrayList<>();
        tasksById = new HashMap<>();

        // parallel change to be deleted
        tasks = new LinkedHashMap<>();
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
        Task task = new Task(nextId, taskDescription, false);
        project.addTask(task);
        tasksById.put(task.getId(), task);

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

    public void markAsdone(String taskId) throws TaskNotFoundException {

        Task task = findTaskById(Long.parseLong(taskId));
        if (task == null) {
            throw new TaskNotFoundException(taskId);
        }
        task.done();

        // Parallel change to be removed
        int id = Integer.parseInt(taskId);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task myTask : project.getValue()) {
                if (myTask.getId() == id) {
                    myTask.done();
                    return;
                }
            }
        }
        throw new TaskNotFoundException(taskId);
    }

    private Task findTaskById(Long id) {
        return tasksById.get(id);
    }
}
