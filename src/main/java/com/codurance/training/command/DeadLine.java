package com.codurance.training.command;

import java.util.Objects;

public class DeadLine implements Command {

    private final String taskId;
    private final String deadLine;

    public DeadLine(String... arguments) {

        this.taskId = arguments[0];
        this.deadLine = arguments[1];
    }

    @Override
    public void execute() {

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
