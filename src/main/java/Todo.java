public class Todo extends Task {
    public Todo(String text) {
        super(text);
    }

    public Todo(String text, Boolean done) {
        super(text, done);
    }

    @Override
    public String getType() { return "T"; }

    @Override
    public String toString() {
        return String.format("[T][%s] %s", this.getIcon(), this.getText());
    }
}
