package duke.command;

import duke.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a command to be executed by Duke. A <code>Command</code> corresponds
 * to a specific set of actions to be performed by Duke, which will lead to various
 * outcomes as specified by the execution of the command.
 */
public abstract class Command {
    public static void print(String message) {
        List<String> list = new ArrayList<>();
        list.add(message);
        System.out.println(new Message(list));
    }

    /**
     * Returns true if the command is an exit command, else false;
     * @return true if the command is an exit command.
     */
    public boolean isExit() {
        return this instanceof ExitCommand;
    }

    /**
     * Performs the command.
     * @param tasks list of tasks given.
     * @param ui ui object given.
     * @param storage storage given.
     * @throws DukeException if the command is unable to execute completely.
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
