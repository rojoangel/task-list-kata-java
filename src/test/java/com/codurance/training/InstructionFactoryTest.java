package com.codurance.training;

import com.codurance.training.instructions.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionFactoryTest {

    @Test
    public void should_create_a_deadline_instruction() {
        CommandLine instruction = new CommandLine("deadline 1 20180101");
        Instruction deadline = InstructionFactory.from(instruction);
        assertEquals(new DeadLine("1", "20180101"), deadline);
    }

    @Test
    public void should_create_a_today_instruction() {
        CommandLine instruction = new CommandLine("today");
        Instruction today = InstructionFactory.from(instruction);
        assertEquals(new Today(), today);
    }

    @Test
    public void shoud_create_a_show_instruction() {
        CommandLine instruction = new CommandLine("show");
        Instruction show = InstructionFactory.from(instruction);
        assertEquals(new Show(), show);
    }

    @Test
    public void should_create_a_check_instruction() {
        CommandLine instruction = new CommandLine("check 1");
        Instruction check = InstructionFactory.from(instruction);
        assertEquals(new Check("1"), check);
    }

    @Test
    public void should_create_an_uncheck_instruction() {
        CommandLine instruction = new CommandLine("uncheck 1");
        Instruction uncheck = InstructionFactory.from(instruction);
        assertEquals(new Uncheck("1"), uncheck);
    }

    @Test
    public void should_create_a_help_instruction() {
        CommandLine instruction = new CommandLine("help");
        Instruction help = InstructionFactory.from(instruction);
        assertEquals(new Help(), help);
    }

    @Test
    public void should_create_an_add_project_instruction() {
        CommandLine instruction = new CommandLine("add project training");
        Instruction add = InstructionFactory.from(instruction);
        assertEquals(new AddProject("training"), add);
    }

    @Test
    public void should_create_an_add_task_instruction() {
        CommandLine instruction = new CommandLine("add task training Four Elements of Simple Design");
        Instruction add = InstructionFactory.from(instruction);
        assertEquals(new AddTask("training", "Four Elements of Simple Design"), add);
    }

    @Test
    public void should_create_a_not_found_instruction() {
        CommandLine instruction = new CommandLine("hello world");
        Instruction notFound = InstructionFactory.from(instruction);
        assertEquals(new NotFound("hello"), notFound);
    }

}