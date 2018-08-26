package com.codurance.training.command;

public class CommandFactory {

    public static Command from(String commandLine) {

        String[] commandRest = commandLine.split(" ");
        String command = commandRest[0];

        switch (command) {
            case "deadline":
                String taskId = commandRest[1];
                String deadLine = commandRest[2];
                return new DeadLine(taskId, deadLine);
            default:
                return null;
        }
    }
}
