package com.codurance.training;

import com.codurance.training.command.Command;
import com.codurance.training.command.DeadLine;
import com.codurance.training.query.Query;
import com.codurance.training.query.Today;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionFactoryTest {

    @Test
    public void should_create_a_deadline_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("deadline 1 20180101");
        Command command = InstructionFactory.commandFrom(instruction);
        assertEquals(new DeadLine("1", "20180101"), command);
    }

    @Test
    public void should_create_a_today_query() {
        CommandLineInstruction instruction = new CommandLineInstruction("today");
        Query command = InstructionFactory.queryFrom(instruction);
        assertEquals(new Today(), command);
    }

}