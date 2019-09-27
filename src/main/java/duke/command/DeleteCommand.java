package duke.command;

import duke.DukeException;
import duke.Message;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

/** Represents a delete Command. A <code>DeleteCommand</code> deletes a command
 * from the task list.
 */
public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes a command from the task list.
     * @param tasks list of tasks given.
     * @param ui ui object given.
     * @param storage storage given.
     * @throws DukeException if the given index is out of range.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (this.index > tasks.getSize()) {
            throw new DukeException("☹ OOPS!!! There is no such task.");
        }
        assert this.index >= 0 && this.index <= tasks.getSize() : "Index is out of range.";
        Task task = tasks.get(this.index - 1);
        tasks.remove(this.index - 1);

        List<String> list = new ArrayList<>();
        list.add("Noted. I've removed this task:");
        list.add(String.format("  %s", task));
        String noun = tasks.getSize() > 1 ? "tasks" : "task";
        list.add(String.format("Now you have %d %s in the list.", tasks.getSize(), noun));
        ui.print(new Message(list));
    }

    /**
     * Overriding equals to compare two DeleteCommand objects.
     * @param o object to be compared with current DeleteCommand instance.
     * @return True if the index is equivalent.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof DeleteCommand && this.index == ((DeleteCommand) o).index;
    }
}
