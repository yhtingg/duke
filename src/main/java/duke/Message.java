package duke;

import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a formatted message to be printed by Duke. A <code>Message</code>
 * corresponds to a list of strings to be formatted between two horizontal lines,
 * with each string concatenated with 4 white spaces at the front.
 */
public class Message {
    private List<String> strings = new ArrayList<>();

    public Message(List<String> strings) {
        this.strings = strings;
    }

    /**
     * Returns string representation of a Message.
     * @return string representation of a Message.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String line = "    ____________________________________________________________\n";
        sb.append(line);
        for (String string : strings) {
            sb.append(String.format("     %s\n", string));
        }
        sb.append(line);
        return sb.toString();
    }
}
