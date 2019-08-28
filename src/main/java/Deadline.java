public class Deadline extends Task {
    private Date date;

    public Deadline(String text, Date date) {
        super(text);
        this.date = date;
    }

    public Deadline(String text, Boolean done, Date date) {
        super(text, done);
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public String getType() { return "D"; }

    @Override
    public String toString() {
        return String.format("[D][%s] %s (by: %s)", this.getIcon(), this.getText(), this.date);
    }
}
