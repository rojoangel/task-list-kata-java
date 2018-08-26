package com.codurance.training.tasks;

import com.codurance.training.CommandLine;
import com.codurance.training.instruction.Instruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static com.codurance.training.InstructionFactory.from;

public final class TaskListApplication implements Runnable {
    private static final String QUIT = "quit";

    private final TaskList taskList = new TaskList();
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskListApplication(in, out).run();
    }

    public TaskListApplication(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String input) {
        CommandLine commandLine = new CommandLine(input);
        Instruction instruction = from(commandLine);
        instruction.execute(taskList, out);
    }
}
