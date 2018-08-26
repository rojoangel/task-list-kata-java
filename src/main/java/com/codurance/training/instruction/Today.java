package com.codurance.training.instruction;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class Today implements Instruction {

    @Override
    public void execute(TaskList tasks, PrintWriter out) {
        out.println();
    }

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
    public String toString() {
        return "Today{}";
    }
}
