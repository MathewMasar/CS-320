package TaskService;
/*
 * This class defines a Task object and enforces all required constraints.
 * Provides getters for all fields and setters for updatable ones (name, description).
 */

public class Task {

    // = = Fields = =
    private final String taskId;    // Cannot change after creation
    private String name;
    private String description;

    // = = Constructor = =
    public Task(String taskId, String name, String description) {
        validateTaskId(taskId);
        validateName(name);
        validateDescription(description);

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // = = Getters (all fields) = =
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // = = Setters (only updatable fields) = =
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    // = = Private Validation Methods = =
    private void validateTaskId(String taskId) {
        // Task ID cannot be null or longer than 10 characters
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null or longer than 10 characters.");
        }
    }

    private void validateName(String name) {
        // Name cannot be null or longer than 20 characters
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null or longer than 20 characters.");
        }
    }

    private void validateDescription(String description) {
        // Description cannot be null or longer than 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null or longer than 50 characters.");
        }
    }
}