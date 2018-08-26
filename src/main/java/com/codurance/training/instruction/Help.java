package com.codurance.training.instruction;

import com.codurance.training.instruction.Instruction;
import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Help implements Instruction {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println("  deadline <task ID> <deadline>");
        out.println("  today");

        out.println();
    }

    @Override
    public String toString() {
        return "Help{}";
    }
}
