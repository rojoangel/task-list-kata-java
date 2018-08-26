package com.codurance.training.tasks;

import com.codurance.training.CommandLineInstruction;
import com.codurance.training.InstructionFactory;
import com.codurance.training.command.Command;
import com.codurance.training.query.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    public static long LAST_ID = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
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

    private void execute(String commandLine) {
        CommandLineInstruction instruction = new CommandLineInstruction(commandLine);
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (instruction.getCommand()) {
            case "show":
                Query show = InstructionFactory.queryFrom(instruction);
                show.execute(tasks, out);
                break;
            case "add":
                Command add = InstructionFactory.commandFrom(instruction);
                add.execute(tasks, out);
                break;
            case "check":
                Command check = InstructionFactory.commandFrom(instruction);
                check.execute(tasks, out);
                break;
            case "uncheck":
                Command uncheck = InstructionFactory.commandFrom(instruction);
                uncheck.execute(tasks, out);
                break;
            case "help":
                Query help = InstructionFactory.queryFrom(instruction);
                help.execute(tasks, out);
                break;
            case "deadline":
                Command deadline = InstructionFactory.commandFrom(instruction);
                deadline.execute(tasks, out);
                break;
            case "today":
                Query today = InstructionFactory.queryFrom(instruction);
                today.execute(tasks, out);
                break;
            default:
                error(command);
                break;
        }
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
