package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * Represents an exit Command. An <code>ExitCommand</code> saves the current task
 * list and prints a goodbye message to the console.
 */
public class ExitCommand extends Command {
    public ExitCommand() {
    }

    /**
     * Saves the current task list and prints and goodbye message.
     * @param tasks list of tasks given.
     * @param ui ui object given.
     * @param storage storage given.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        storage.save(tasks);
        String message = "Bye. Hope to see you again soon!";
        ui.print(message);
    }
}
