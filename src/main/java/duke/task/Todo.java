package duke.task;

/**
 * Represents a Todo in the task list.
 */
public class Todo extends Task {
    public Todo(String text) {
        super(text);
    }

    public Todo(String text, boolean done) {
        super(text, done);
    }

    /**
     * Returns the string representation of the Todo type.
     * @return the string representation of the Todo type.
     */
    @Override
    public String getType() { return "T"; }

    /**
     * Returns the string representation of a Todo.
     * @return the string representation of a Todo.
     */
    @Override
    public String toString() {
        return String.format("[T][%s] %s", this.getIcon(), this.getText());
    }
}
