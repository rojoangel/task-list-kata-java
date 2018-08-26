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
        Command command = InstructionFactory.commandFrom("deadline 1 20180101");
        assertEquals(new DeadLine("1", "20180101"), command);
    }

    @Test
    public void should_create_a_today_query() {
        Query command = InstructionFactory.queryFrom("today");
        assertEquals(new Today(), command);
    }

}