package duke.task;

import duke.Date;

/**
 * Represents an Event in the task list.
 */
public class Event extends Task {
    private Date date;

    public Event(String text, Date date) {
        super(text);
        this.date = date;
    }

    public Event(String text, boolean done, Date date) {
        super(text, done);
        this.date = date;
    }

    /**
     * Returns the Date associated with the Event.
     * @return the Date associated with the Event.
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Returns the string representation of the Event type.
     * @return the string representation of the Event type.
     */
    @Override
    public String getType() { return "E"; }

    /**
     * Returns the string representation of am Event.
     * @return the string representation of am Event.
     */
    @Override
    public String toString() {
        return String.format("[E][%s] %s (at: %s)", this.getIcon(), this.getText(), this.date);
    }
}
