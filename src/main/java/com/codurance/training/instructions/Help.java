package com.codurance.training.instructions;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

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
    public void execute(TaskList tasks, PrintWriter out) {
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
