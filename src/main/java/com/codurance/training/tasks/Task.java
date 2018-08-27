package com.codurance.training.tasks;

import java.util.Date;
import java.util.Objects;

public final class Task {
    private final long id;
    private final String description;
    private boolean done = false;
    private Date deadLine;

    public Task(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void done() {
        this.done = true;
    }

    public void pending() {
        this.done = false;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                done == task.done &&
                Objects.equals(description, task.description) &&
                Objects.equals(deadLine, task.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, done, deadLine);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", deadLine=" + deadLine +
                '}';
    }
}
