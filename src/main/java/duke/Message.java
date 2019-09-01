package duke;

import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;

public class Message {
    private List<String> strings;

    public Message(List<String> strings) {
        this.strings = strings;
    }

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
