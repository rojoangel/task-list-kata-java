package com.codurance.training;

import java.util.Arrays;

public class CommandLine {
    private String command;
    private String[] arguments = new String[]{};

    public CommandLine(String commandLine) {
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

    public String getMultiWordArgument(int index) {
        return String.join(" ",
                Arrays.copyOfRange(arguments, 2, arguments.length));
    }
}
