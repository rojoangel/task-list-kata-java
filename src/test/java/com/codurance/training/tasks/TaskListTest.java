package com.codurance.training.tasks;

import com.codurance.training.exceptions.ProjectNotFoundException;
import com.codurance.training.exceptions.TaskNotFoundException;
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

    @Test(expected = ProjectNotFoundException.class)
    public void should_fail_when_project_does_not_exist() throws Exception{
        TaskList taskList = new TaskList();
        taskList.addTask("secrets", "one task");
    }

    @Test
    public void should_add_a_task_when_project_exists() throws Exception {
        Project project = new Project("secrets");
        project.addTask(new Task(1, "one task", false));
        List<Project> projects = Arrays.asList(project);

        TaskList taskList = new TaskList();
        taskList.addProject("secrets");
        taskList.addTask("secrets", "one task");
        assertEquals(projects, taskList.getProjects());
    }

    @Test(expected = TaskNotFoundException.class)
    public void should_fail_marking_as_done_when_task_does_not_exist() throws Exception {
        TaskList taskList = new TaskList();
        taskList.markAsdone("1");
    }

    @Test
    public void should_mark_as_done_a_task_when_found() throws Exception {
        Project project = new Project("secrets");
        project.addTask(new Task(1, "one task", true));
        List<Project> projects = Arrays.asList(project);

        TaskList taskList = new TaskList();
        taskList.addProject("secrets");
        taskList.addTask("secrets", "one task");
        taskList.markAsdone("1");

        assertEquals(projects, taskList.getProjects());
    }
}