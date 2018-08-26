package com.codurance.training;

import com.codurance.training.command.Check;
import com.codurance.training.command.Command;
import com.codurance.training.command.DeadLine;
import com.codurance.training.query.Query;
import com.codurance.training.query.Show;
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
        Query query = InstructionFactory.queryFrom(instruction);
        assertEquals(new Today(), query);
    }

    @Test
    public void shoud_create_a_show_query() {
        CommandLineInstruction instruction = new CommandLineInstruction("show");
        Query show = InstructionFactory.queryFrom(instruction);
        assertEquals(new Show(), show);
    }

    @Test
    public void should_create_a_check_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("check 1");
        Command check = InstructionFactory.commandFrom(instruction);
        assertEquals(new Check("1"), check);
    }
}