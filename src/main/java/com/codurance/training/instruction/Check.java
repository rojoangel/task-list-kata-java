package com.codurance.training.instruction;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Check implements Instruction {
    private String taskId;

    public Check(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        boolean done = true;
        int id = Integer.parseInt(taskId);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
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
        Check check = (Check) o;
        return Objects.equals(taskId, check.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    @Override
    public String toString() {
        return "Check{" +
                "taskId='" + taskId + '\'' +
                '}';
    }
}
