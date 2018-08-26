package com.codurance.training.tasks;

import com.codurance.training.projects.Project;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TaskListTest {

    @Test
    public void should_have_no_project_when_created() {
        List<Project> projects = Arrays.asList(new Project[]{});
        TaskList taskList = new TaskList();
        assertEquals(projects, taskList.getProjects());
    }

    @Test
    public void should_add_a_project() {
        List<Project> projects = Arrays.asList(new Project("secrets"));
        TaskList taskList = new TaskList();
        taskList.addProject("secrets");
        assertEquals(projects, taskList.getProjects());
    }
}