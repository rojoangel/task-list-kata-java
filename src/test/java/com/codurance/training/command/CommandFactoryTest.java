package com.codurance.training.command;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommandFactoryTest {

    @Test
    public void should_create_a_deadline_command() {
        Command command = CommandFactory.from("deadline 1 20180101");
        assertEquals(new DeadLine("1", "20180101"), command);
    }
}