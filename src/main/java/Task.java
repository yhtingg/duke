import java.util.Hashtable;

public abstract class Task {
    private String text;
    protected Boolean done;

    public static Hashtable<Boolean, String> icons = new Hashtable<>() {{
        put(true, "✓");
        put(false, "✗");
    }};

    public Task(String text) {
        this.text = text;
        this.done = false;
    }

    public Task(String text, Boolean done) {
        this.text = text;
        this.done = done;
    }

    public void markAsDone() {
        this.done = true;
    }

    public String getText() {
        return this.text;
    }

    public Boolean isDone() {
        return this.done;
    }

    public String getIcon() {
        return icons.get(this.done);
    }

    public String getDate() {
        if (this instanceof Deadline) {
            return ((Deadline) this).getDate();
        } else if (this instanceof Event) {
            return ((Event) this).getDate();
        } else {
            return null;
        }
    }

    public abstract String getType();
}
