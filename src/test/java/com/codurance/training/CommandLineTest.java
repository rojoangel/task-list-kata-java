package com.codurance.training;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandLineTest {

    @Test
    public void should_create_a_command_line_instruction_with_no_arguments() {
        CommandLine instruction = new CommandLine("show");
        assertEquals("show", instruction.getCommand());
        assertArrayEquals(new String[]{}, instruction.getArguments());
    }

    @Test
    public void should_create_a_command_line_instruction_with_one_arguments() {
        CommandLine instruction = new CommandLine("check 1");
        assertEquals("check", instruction.getCommand());
        assertArrayEquals(new String[]{"1"}, instruction.getArguments());
    }

    @Test
    public void should_create_a_command_line_instruction_with_two_arguments() {
        CommandLine instruction = new CommandLine("add project secrets");
        assertEquals("add", instruction.getCommand());
        assertArrayEquals(new String[]{"project", "secrets"}, instruction.getArguments());
    }

    @Test
    public void should_create_a_command_line_instruction_with_three_arguments() {
        CommandLine instruction = new CommandLine("add task training SOLID");
        assertEquals("add", instruction.getCommand());
        assertArrayEquals(new String[]{"task", "training", "SOLID"}, instruction.getArguments());
    }
}
