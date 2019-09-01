package duke.task;

import duke.Date;

/**
 * Represents a deadline in the task list.
 */
public class Deadline extends Task {
    private Date date;

    public Deadline(String text, Date date) {
        super(text);
        this.date = date;
    }

    public Deadline(String text, boolean done, Date date) {
        super(text, done);
        this.date = date;
    }

    /**
     * Returns the Date associated with the Deadline.
     * @return the Date associated with the Deadline.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Returns the string representation of the Deadline type.
     * @return the string representation of the Deadline type.
     */
    @Override
    public String getType() { return "D"; }

    /**
     * Returns the string representation of a Deadline.
     * @return the string representation of a Deadline.
     */
    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", this.getIcon(), this.getText(), this.date);
    }
}
