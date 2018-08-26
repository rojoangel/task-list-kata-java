package com.codurance.training;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandLineInstructionTest {

    @Test
    public void should_create_a_command_line_instruction_with_no_arguments() {
        CommandLineInstruction instruction = new CommandLineInstruction("show");
        assertEquals("show", instruction.getCommand());
        assertArrayEquals(new String[]{}, instruction.getArguments());
    }

    @Test
    public void should_create_a_command_line_instruction_with_one_arguments() {
        CommandLineInstruction instruction = new CommandLineInstruction("check 1");
        assertEquals("check", instruction.getCommand());
        assertArrayEquals(new String[]{"1"}, instruction.getArguments());
    }

    @Test
    public void should_create_a_command_line_instruction_with_two_arguments() {
        CommandLineInstruction instruction = new CommandLineInstruction("add project secrets");
        assertEquals("add", instruction.getCommand());
        assertArrayEquals(new String[]{"project", "secrets"}, instruction.getArguments());
    }

    @Test
    public void should_create_a_command_line_instruction_with_three_arguments() {
        CommandLineInstruction instruction = new CommandLineInstruction("add task training SOLID");
        assertEquals("add", instruction.getCommand());
        assertArrayEquals(new String[]{"task", "training", "SOLID"}, instruction.getArguments());
    }
}
