package com.codurance.training.command;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AddTask implements Command {

    private final String projectId;
    private final String taskDescription;

    public AddTask(String projectId, String taskDescription) {
        this.projectId = projectId;
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        List<Task> projectTasks = tasks.get(projectId);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", projectId);
            out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), taskDescription, false));

    }

    private long nextId() {
        return ++TaskList.LAST_ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTask addTask = (AddTask) o;
        return Objects.equals(projectId, addTask.projectId) &&
                Objects.equals(taskDescription, addTask.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, taskDescription);
    }

    @Override
    public String toString() {
        return "AddTask{" +
                "projectId='" + projectId + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
