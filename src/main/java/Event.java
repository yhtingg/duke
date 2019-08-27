public class Event extends Task {
    private String datetime;

    public Event(String text, String datetime) {
        super(text);
        this.datetime = datetime;
    }

    public Event(String text, Boolean done, String datetime) {
        super(text, done);
        this.datetime = datetime;
    }

    public String getDate() {
        return this.datetime;
    }

    @Override
    public String getType() { return "E"; }

    @Override
    public String toString() {
        return String.format("[E][%s] %s (at: %s)", this.getIcon(), this.getText(), this.datetime);
    }
}
