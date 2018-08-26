package com.codurance.training.instruction;

import com.codurance.training.exceptions.TaskNotFoundException;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.Objects;

public class Uncheck implements Instruction {
    private String taskId;

    public Uncheck(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        try {
            tasks.markAsPending(taskId);
        } catch (TaskNotFoundException ex) {
            out.printf(ex.getMessage());
            out.println();
        }
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
