package com.codurance.training;

import com.codurance.training.command.*;
import com.codurance.training.query.Help;
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

    @Test
    public void should_create_an_uncheck_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("uncheck 1");
        Command uncheck = InstructionFactory.commandFrom(instruction);
        assertEquals(new Uncheck("1"), uncheck);
    }

    @Test
    public void should_create_a_help_query() {
        CommandLineInstruction instruction = new CommandLineInstruction("help");
        Query help = InstructionFactory.queryFrom(instruction);
        assertEquals(new Help(), help);
    }

    @Test
    public void should_create_an_add_project_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("add project training");
        Command add = InstructionFactory.commandFrom(instruction);
        assertEquals(new AddProject("training"), add);
    }

    @Test
    public void should_create_an_add_task_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("add task training Four Elements of Simple Design");
        Command add = InstructionFactory.commandFrom(instruction);
        assertEquals(new AddTask("training", "Four Elements of Simple Design"), add);
    }
}