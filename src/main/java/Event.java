public class Event extends Task {
    private Date date;

    public Event(String text, Date date) {
        super(text);
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (at: %s)", this.getIcon(), this.getText(), this.date);
    }
}
