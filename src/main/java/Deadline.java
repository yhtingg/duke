public class Deadline extends Task {
    private String datetime;

    public Deadline(String text, String datetime) {
        super(text);
        this.datetime = datetime;
    }

    public String getDate() {
        return this.datetime;
    }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", this.getIcon(), this.getText(), this.datetime);
    }
}
