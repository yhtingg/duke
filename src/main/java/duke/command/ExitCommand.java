package duke.command;

import duke.Storage;
import duke.Ui;
import duke.task.Task;

import java.util.List;

/**
 * Represents an exit Command. An <code>ExitCommand</code> saves the current task
 * list and prints a goodbye message to the console.
 */
public class ExitCommand extends Command<List<Task>> {
    public ExitCommand() {
    }

    /**
     * Saves the current task list and prints and goodbye message.
     * @param tasks list of tasks given.
     * @param ui ui object given.
     * @param storage storage given.
     */
    @Override
    public void execute(List<Task> tasks, Ui ui, Storage storage) {
        storage.save(tasks);
        String message = "Bye. Hope to see you again soon!";
        ui.print(message);
    }

    /**
     * Overriding equals to compare two ExitCommand objects.
     * @param o object to be compared with current ExitCommand instance.
     * @return True if o is an instance of ExitCommand.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof ExitCommand;
    }
}
