package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskListTest {

    @Test
    public void should_have_no_project_when_created() {
        TaskList taskList = new TaskList();
        assertArrayEquals(new String[]{}, taskList.getProjects());
    }

    @Test
    public void should_add_a_project() {
        TaskList taskList = new TaskList();
        taskList.addProject("secrets");
        assertArrayEquals(new String[]{"secrets"}, taskList.getProjects());
    }
}