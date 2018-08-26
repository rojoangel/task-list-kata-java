package com.codurance.training.instruction;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NotFound implements Instruction {

    private String command;

    public NotFound(String command) {
        this.command = command;
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        out.printf("I don't know what the instruction \"%s\" is.", command);
        out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotFound aNotFound = (NotFound) o;
        return Objects.equals(command, aNotFound.command);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }
}