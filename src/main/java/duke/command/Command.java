package duke.command;

import duke.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {
    static void print(String message) {
        List<String> list = new ArrayList<>();
        list.add(message);
        System.out.println(new Message(list));
    }

    public boolean isExit() {
        return this instanceof ExitCommand;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
