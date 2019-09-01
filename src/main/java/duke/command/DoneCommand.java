package duke.command;

import duke.*;
import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a done Command. A <code>DoneCommand</code> marks a task in the task
 * list as complete.
 */
public class DoneCommand extends Command {
    private int index;

    public DoneCommand(int index) {
        this.index = index;
    }

    /**
     * Marks a task in the task list as complete.
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
        Task task = tasks.get(this.index - 1);
        task.markAsDone();
        List<String> list = new ArrayList<>();
        list.add("Nice! I've marked this task as done:");
        list.add(String.format("  %s", task));
        System.out.println(new Message(list));
    }
}
