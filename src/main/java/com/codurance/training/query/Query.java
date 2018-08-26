package com.codurance.training.query;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface Query {
    void execute(Map<String, List<Task>> tasks, PrintWriter out);
}
