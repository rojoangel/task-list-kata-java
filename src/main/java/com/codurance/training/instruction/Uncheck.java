package com.codurance.training.instruction;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Uncheck implements Instruction {
    private String taskId;

    public Uncheck(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        boolean done = false;
        int id = Integer.parseInt(taskId);
        for (Map.Entry<String, List<Task>> project : tasks.getTasks().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uncheck uncheck = (Uncheck) o;
        return Objects.equals(taskId, uncheck.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    @Override
    public String toString() {
        return "Uncheck{" +
                "taskId='" + taskId + '\'' +
                '}';
    }
}
