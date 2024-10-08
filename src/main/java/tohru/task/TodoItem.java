package tohru.task;

/**
 * Represents a to-do entry.
 */
public class TodoItem {
    /** Content that the entry stores. */
    private final String content;
    /** Status of the to-do item. */
    private boolean isCompleted;

    /**
     * Creates a new to-do item with the specified content.
     *
     * @param content The task description of the to-do item.
     */
    public TodoItem(String content) {
        assert (content != null && !content.isEmpty()) : "Description content should not be null or empty";

        this.content = content.trim();
        this.isCompleted = false;
    }

    /**
     * Searches the description for provided keyword.
     *
     * @param keyword Search term to filter by.
     * @return Boolean to check if keyword is in description.
     */
    public boolean contains(String keyword) {
        return this.content.contains(keyword);
    }

    /**
     * Sets the status of the to-do item.
     *
     * @param isCompleted Status to be set to the to-do item.
     */
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    /**
     * Gets the string representation of the entry.
     *
     * @return A string representation of the entry.
     */
    public String toString() {
        return String.format("[T] [%s] %s", this.isCompleted ? "X" : " ", content);
    }

    /**
     * Gets the string representation of the entry in the save format.
     *
     * @return A save string representation of the entry.
     */
    public String getSaveString() {
        return String.format("T | %s | %s", this.isCompleted ? "true" : "false", content);
    }
}
