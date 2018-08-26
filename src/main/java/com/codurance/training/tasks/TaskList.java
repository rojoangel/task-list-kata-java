package com.codurance.training.tasks;

import com.codurance.training.CommandLineInstruction;
import com.codurance.training.InstructionFactory;
import com.codurance.training.instruction.Instruction;

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
                Instruction show = InstructionFactory.from(instruction);
                show.execute(tasks, out);
                break;
            case "add":
                Instruction add = InstructionFactory.from(instruction);
                add.execute(tasks, out);
                break;
            case "check":
                Instruction check = InstructionFactory.from(instruction);
                check.execute(tasks, out);
                break;
            case "uncheck":
                Instruction uncheck = InstructionFactory.from(instruction);
                uncheck.execute(tasks, out);
                break;
            case "help":
                Instruction help = InstructionFactory.from(instruction);
                help.execute(tasks, out);
                break;
            case "deadline":
                Instruction deadline = InstructionFactory.from(instruction);
                deadline.execute(tasks, out);
                break;
            case "today":
                Instruction today = InstructionFactory.from(instruction);
                today.execute(tasks, out);
                break;
            default:
                error(command);
                break;
        }
    }

    private void error(String command) {
        out.printf("I don't know what the instruction \"%s\" is.", command);
        out.println();
    }
}
