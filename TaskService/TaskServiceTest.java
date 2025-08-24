package TaskService;
/*
 * This JUnit test class verifies that the TaskService class correctly manages tasks.
 * It tests:
 *   - Adding a new task with a unique auto-generated taskId
 *   - Deleting a task by taskId (valid and nonexistent)
 *   - Updating allowed fields (name, description) for existing tasks
 */

import static org.junit.Assert.*;  // JUnit 4
import org.junit.Test;             // JUnit 4 annotation

public class TaskServiceTest {

    // = = Add Task Tests = =
    @Test
    public void testAddTaskValid() {
        TaskService service = new TaskService();

        // Add a task
        service.addTask("Complete Project", "Finish the project by next week.");

        // Retrieve the first task from the HashMap
        Task addedTask = service.getAllTasks().values().iterator().next();

        // Assertions
        assertNotNull(addedTask);
        assertEquals("Complete Project", addedTask.getName());
        assertEquals("Finish the project by next week.", addedTask.getDescription());
        assertNotNull(addedTask.getTaskId()); // ID should be auto-generated
        assertTrue(addedTask.getTaskId().length() <= 10);
    }

    // = = Delete Task Tests = =
    @Test
    public void testDeleteTaskValid() {
        TaskService service = new TaskService();

        // Add a task first
        service.addTask("Complete Project", "Finish the project by next week.");

        // Get the generated task ID
        String taskId = service.getAllTasks().keySet().iterator().next();

        // Delete the task
        service.deleteTask(taskId);

        // Verify it's deleted
        assertFalse(service.getAllTasks().containsKey(taskId));
    }

    @Test
    public void testDeleteTaskNonExistent() {
        TaskService service = new TaskService();

        try {
            service.deleteTask("ZZZZZZZZZZ"); // Random ID that doesn't exist
            fail("Expected IllegalArgumentException for deleting non-existent task.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // = = Update Task Tests = =
    @Test
    public void testUpdateTaskValid() {
        TaskService service = new TaskService();

        // Add a task first
        service.addTask("Complete Project", "Finish the project by next week.");

        // Get the generated task ID
        String taskId = service.getAllTasks().keySet().iterator().next();

        // Update the task
        service.updateTask(taskId, "Update Project", "Updated description for the task.");

        // Retrieve updated task
        Task updatedTask = service.getTask(taskId);

        // Assertions
        assertEquals("Update Project", updatedTask.getName());
        assertEquals("Updated description for the task.", updatedTask.getDescription());
    }

    @Test
    public void testUpdateTaskNonExistent() {
        TaskService service = new TaskService();

        try {
            service.updateTask("ZZZZZZZZZZ", "Update Project", "Updated description for the task.");
            fail("Expected IllegalArgumentException for updating non-existent task.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testUpdateTaskInvalidField() {
        TaskService service = new TaskService();

        // Add a valid task first
        service.addTask("Complete Project", "Finish the project by next week.");

        // Get the generated task ID
        String taskId = service.getAllTasks().keySet().iterator().next();

        try {
            // Attempt to update with invalid name (too long)
            service.updateTask(taskId, "ThisNameIsWayTooLongForTheLimit", null);
            fail("Expected IllegalArgumentException for name longer than 20 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
