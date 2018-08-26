package com.codurance.training.command;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DeadLine implements Command {

    private final String taskId;
    private final String deadLine;

    public DeadLine(String taskId, String deadLine) {
        this.taskId = taskId;
        this.deadLine = deadLine;
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeadLine deadLine1 = (DeadLine) o;
        return Objects.equals(taskId, deadLine1.taskId) &&
                Objects.equals(deadLine, deadLine1.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, deadLine);
    }
}
