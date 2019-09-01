package duke.task;

import java.util.Hashtable;
import duke.Date;

/**
 * Represents a task in the task list. A <code>Task</code> corresponds to a
 * string of text and a boolean which marks its completion.
 */
public abstract class Task {
    private String text;
    protected boolean done;

    public static Hashtable<Boolean, String> icons = new Hashtable<>() {{
        put(true, "✓");
        put(false, "✗");
    }};

    public Task(String text) {
        this.text = text;
        this.done = false;
    }

    public Task(String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.done = true;
    }

    /**
     * Returns the string representation of the task content.
     * @return the string representation of the task context.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Returns the completion state of the Task.
     * @return the completion state of the Task.
     */
    public boolean isDone() {
        return this.done;
    }

    /**
     * Returns the icon representing the state of the Task.
     * @return the icon representing the state of the Task.
     */
    public String getIcon() {
        return icons.get(this.done);
    }

    /**
     * Returns the Date associated with the Task.
     * @return the Date associated with the Task.
     */
    public Date getDate() {
        if (this instanceof Deadline || this instanceof Event) {
            return this.getDate();
        } else {
            return null;
        }
    }

    /**
     * Returns the string representation of the type of Task.
     * @return the string representation of the type of Task.
     */
    public abstract String getType();
}
