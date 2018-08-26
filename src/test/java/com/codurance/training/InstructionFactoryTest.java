package com.codurance.training;

import com.codurance.training.instruction.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionFactoryTest {

    @Test
    public void should_create_a_deadline_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("deadline 1 20180101");
        Instruction deadline = InstructionFactory.from(instruction);
        assertEquals(new DeadLine("1", "20180101"), deadline);
    }

    @Test
    public void should_create_a_today_query() {
        CommandLineInstruction instruction = new CommandLineInstruction("today");
        Instruction today = InstructionFactory.from(instruction);
        assertEquals(new Today(), today);
    }

    @Test
    public void shoud_create_a_show_query() {
        CommandLineInstruction instruction = new CommandLineInstruction("show");
        Instruction show = InstructionFactory.from(instruction);
        assertEquals(new Show(), show);
    }

    @Test
    public void should_create_a_check_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("check 1");
        Instruction check = InstructionFactory.from(instruction);
        assertEquals(new Check("1"), check);
    }

    @Test
    public void should_create_an_uncheck_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("uncheck 1");
        Instruction uncheck = InstructionFactory.from(instruction);
        assertEquals(new Uncheck("1"), uncheck);
    }

    @Test
    public void should_create_a_help_query() {
        CommandLineInstruction instruction = new CommandLineInstruction("help");
        Instruction help = InstructionFactory.from(instruction);
        assertEquals(new Help(), help);
    }

    @Test
    public void should_create_an_add_project_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("add project training");
        Instruction add = InstructionFactory.from(instruction);
        assertEquals(new AddProject("training"), add);
    }

    @Test
    public void should_create_an_add_task_command() {
        CommandLineInstruction instruction = new CommandLineInstruction("add task training Four Elements of Simple Design");
        Instruction add = InstructionFactory.from(instruction);
        assertEquals(new AddTask("training", "Four Elements of Simple Design"), add);
    }
}