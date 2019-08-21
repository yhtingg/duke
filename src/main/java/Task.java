public class Task {
    private String text;
    private boolean done;

    public Task(String text) {
        this.text = text;
        this.done = false;
    }

    public void markAsDone() {
        this.done = true;
    }

    public String getText() {
        return this.text;
    }

    public boolean isDone() {
        return this.done;
    }
}
