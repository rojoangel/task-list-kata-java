package com.codurance.training;

import com.codurance.training.command.*;
import com.codurance.training.query.Help;
import com.codurance.training.query.Query;
import com.codurance.training.query.Show;
import com.codurance.training.query.Today;

public class InstructionFactory {

    public static Command commandFrom(CommandLineInstruction instruction) {

        switch (instruction.getCommand()) {
            case "deadline":
                return new DeadLine(
                        instruction.getArgument(0),
                        instruction.getArgument(1));
            case "check":
                return new Check(
                        instruction.getArgument(0));
            case "uncheck":
                return new Uncheck(
                        instruction.getArgument(0));
            case "add":
                switch (instruction.getArgument(0)) {
                    case "project":
                        return new AddProject(
                                instruction.getArgument(1));
                    case "task":
                        return new AddTask(
                                instruction.getArgument(1),
                                instruction.getMultiWordArgument(2));
                        default:
                            return null;
                }
            default:
                return null;
        }
    }

    public static Query queryFrom(CommandLineInstruction instruction) {

        switch (instruction.getCommand()) {
            case "today":
                return new Today();
            case "show":
                return new Show();
            case "help":
                return new Help();
            default:
                return null;
        }
    }
}
