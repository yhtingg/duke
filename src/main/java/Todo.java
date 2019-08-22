public class Todo extends Task {
    public Todo(String text) {
        super(text);
    }

    @Override
    public String toString() {
        return String.format("[T][%s] %s", this.getIcon(), this.getText());
    }
}
