package com.codurance.training;

import com.codurance.training.instruction.*;

public class InstructionFactory {

    public static Instruction from(CommandLine instruction) {

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
            case "today":
                return new Today();
            case "show":
                return new Show();
            case "help":
                return new Help();
            default:
                return new NotFound(instruction.getCommand());
        }
    }
}
