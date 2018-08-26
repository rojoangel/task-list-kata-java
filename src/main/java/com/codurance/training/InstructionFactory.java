package com.codurance.training;

import com.codurance.training.command.Command;
import com.codurance.training.command.DeadLine;
import com.codurance.training.query.Query;
import com.codurance.training.query.Today;

public class InstructionFactory {

    public static Command commandFrom(String commandLine) {

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

    public static Query queryFrom(String commandLine) {
        String[] commandRest = commandLine.split(" ");
        String command = commandRest[0];

        switch (command) {
            case "today":
                return new Today();
            default:
                return null;
        }
    }

}
