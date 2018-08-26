package com.codurance.training.projects;

import com.codurance.training.tasks.Task;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectTest {

    @Test
    public void should_add_a_task() {
        List<Task> tasks = Arrays.asList(new Task(1, "one task", false));

        Project project = new Project("project");
        project.addTask(new Task(1, "one task", false));

        assertEquals(tasks, project.getTasks());
    }
}