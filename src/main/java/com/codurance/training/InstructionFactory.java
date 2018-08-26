package com.codurance.training;

import com.codurance.training.command.Command;
import com.codurance.training.command.DeadLine;
import com.codurance.training.query.Query;
import com.codurance.training.query.Show;
import com.codurance.training.query.Today;

public class InstructionFactory {

    public static Command commandFrom(CommandLineInstruction instruction) {

        switch (instruction.getCommand()) {
            case "deadline":
                String taskId = instruction.getArgument(0);
                String deadLine = instruction.getArgument(1);
                return new DeadLine(taskId, deadLine);
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
