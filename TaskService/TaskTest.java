package TaskService;
/*
 * This JUnit test class verifies that the Task class correctly enforces
 * all field constraints and allows valid updates for name and description.
 */

import static org.junit.Assert.*;  // JUnit 4
import org.junit.Test;             // JUnit 4 annotation

public class TaskTest {

    // = = Valid Task Creation = =
    @Test
    public void testValidTaskCreation() {
        Task task = new Task("12345", "Complete Project", "Finish the project by next week.");

        assertEquals("12345", task.getTaskId());
        assertEquals("Complete Project", task.getName());
        assertEquals("Finish the project by next week.", task.getDescription());
    }

    // = = Invalid Constructor Tests = =

    @Test
    public void testInvalidTaskIdTooLong() {
        try {
            new Task("12345678901", "Complete Project", "Finish the project by next week.");
            fail("Expected IllegalArgumentException for taskId longer than 10 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidTaskIdNull() {
        try {
            new Task(null, "Complete Project", "Finish the project by next week.");
            fail("Expected IllegalArgumentException for null taskId.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidNameTooLong() {
        try {
            new Task("12345", "ThisNameIsWayTooLongForTheLimit", "Finish the project by next week.");
            fail("Expected IllegalArgumentException for name longer than 20 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidNameNull() {
        try {
            new Task("12345", null, "Finish the project by next week.");
            fail("Expected IllegalArgumentException for null name.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidDescriptionTooLong() {
        try {
            new Task("12345", "Complete Project",
                    "This description is way too long and should definitely exceed the fifty-character limit enforced by validation.");
            fail("Expected IllegalArgumentException for description longer than 50 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidDescriptionNull() {
        try {
            new Task("12345", "Complete Project", null);
            fail("Expected IllegalArgumentException for null description.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // = = Valid Setter Tests = =
    @Test
    public void testValidSetters() {
        Task task = new Task("12345", "Complete Project", "Finish the project by next week.");

        task.setName("Update Project");
        task.setDescription("Updated description for the task.");

        assertEquals("Update Project", task.getName());
        assertEquals("Updated description for the task.", task.getDescription());
    }

    // = = Invalid Setter Tests = =
    @Test
    public void testInvalidSetNameTooLong() {
        Task task = new Task("12345", "Complete Project", "Finish the project by next week.");

        try {
            task.setName("ThisNameIsWayTooLongForTheLimit");
            fail("Expected IllegalArgumentException for name longer than 20 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidSetDescriptionTooLong() {
        Task task = new Task("12345", "Complete Project", "Finish the project by next week.");

        try {
            task.setDescription("This description is way too long and should definitely exceed the fifty-character limit enforced by validation.");
            fail("Expected IllegalArgumentException for description longer than 50 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
