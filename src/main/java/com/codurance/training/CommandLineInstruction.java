package com.codurance.training;

public class CommandLineInstruction {
    private String command;
    private String[] arguments = new String[]{};

    public CommandLineInstruction(String commandLine) {
        String[] commandLineParts = commandLine.split(" ", 2);
        command = commandLineParts[0];
        if (commandLineParts.length > 1) {
            arguments = commandLineParts[1].split(" ");
        }
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getArgument(int index) {
        return arguments[index];
    }
}
