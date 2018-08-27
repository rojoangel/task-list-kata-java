package com.codurance.training.instructions;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;
import org.junit.Test;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

public class DeadLineTest {

    @Test
    public void should_add_deadline_when_task_found() throws Exception {
        TaskList tasks = new TaskList();
        tasks.addProject("secrets");
        tasks.addTask("secrets", "one task");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        TaskList expected = new TaskList();
        expected.addProject("secrets");
        Task task = new Task(1, "one task");
        task.setDeadLine(sdf.parse("20180101"));
        expected.getProjects().get(0).getTasks().add(task);

        DeadLine deadLine = new DeadLine("1", "20180101");
        deadLine.execute(tasks, new PrintWriter(System.out));

        assertEquals(expected, tasks);
    }
}