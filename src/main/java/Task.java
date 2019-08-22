import java.util.Hashtable;

public class Task {
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
}
