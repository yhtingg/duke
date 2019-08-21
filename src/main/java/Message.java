import java.lang.StringBuilder;

public class Message {
    String string;

    public Message(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String line = "    ____________________________________________________________\n";
        sb.append(line);
        sb.append(String.format("     %s\n", this.string));
        sb.append(line);
        return sb.toString();
    }
}
