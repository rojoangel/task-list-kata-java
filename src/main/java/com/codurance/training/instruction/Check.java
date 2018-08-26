package com.codurance.training.instruction;

import com.codurance.training.exceptions.TaskNotFoundException;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.Objects;

public class Check implements Instruction {
    private String taskId;

    public Check(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        try {
            tasks.markAsdone(taskId);
        } catch (TaskNotFoundException ex) {
            out.printf(ex.getMessage());
            out.println();
        }
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
