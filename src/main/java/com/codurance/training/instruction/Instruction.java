package com.codurance.training.instruction;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public interface Instruction {
    void execute(TaskList tasks, PrintWriter out);
}
