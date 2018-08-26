package com.codurance.training.query;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Today implements Query {

    @Override
    public void execute(Map<String, List<Task>> tasks, PrintWriter out) {
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
}
