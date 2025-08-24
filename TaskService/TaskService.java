package TaskService;
/*
 * This class manages Task objects in an in memory collection.
 * It supports adding tasks with unique IDs, deleting by ID,
 * and updating allowed fields (name, description).
 */

import java.util.HashMap;
import java.util.Random;

public class TaskService {

    // = = Fields = =
    private HashMap<String, Task> tasks = new HashMap<>();

    // = = Add Task = =
    public void addTask(String name, String description) {
        String taskId;

        // Generate a unique 10-character ID
        do {
            taskId = generateTaskId();
        } while (tasks.containsKey(taskId)); // Repeat until unique ID

        Task newTask = new Task(taskId, name, description);
        tasks.put(taskId, newTask);
    }

    // = = Delete Task = =
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasks.remove(taskId);
    }

    // = = Update Task = =
    public void updateTask(String taskId, String name, String description) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }

        // Update only allowed fields (validate via setters)
        if (name != null) {
            task.setName(name);
        }
        if (description != null) {
            task.setDescription(description);
        }
    }

    // = = Private Helper Method (ID Generator) = =
    private String generateTaskId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder id = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            id.append(characters.charAt(random.nextInt(characters.length())));
        }
        return id.toString();
    }

    // = = Getter for Testing = =
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }

    public HashMap<String, Task> getAllTasks() {
        return tasks;
    }
}
