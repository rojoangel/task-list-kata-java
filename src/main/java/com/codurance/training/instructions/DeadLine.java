package com.codurance.training.instructions;

import com.codurance.training.exceptions.TaskNotFoundException;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DeadLine implements Instruction {

    private final String taskId;
    private final Date deadLine;

    public DeadLine(String taskId, String deadLine) throws IllegalArgumentException {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            this.taskId = taskId;
            this.deadLine = dateFormat.parse(deadLine);
        } catch (ParseException pEx) {
            throw new IllegalArgumentException(
                    String.format("%s is not a valid date", deadLine),
                    pEx);
        }
    }

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        try {
            tasks.addDeadLine(taskId, deadLine);
        } catch (TaskNotFoundException ex) {
            out.printf(ex.getMessage());
            out.println();
        }

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

    @Override
    public String toString() {
        return "DeadLine{" +
                "taskId='" + taskId + '\'' +
                ", deadLine='" + deadLine + '\'' +
                '}';
    }
}
