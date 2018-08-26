package com.codurance.training;

import com.codurance.training.command.Check;
import com.codurance.training.command.Command;
import com.codurance.training.command.DeadLine;
import com.codurance.training.command.Uncheck;
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
            default:
                return null;
        }
    }

}
