package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Represents a find Command. A <code>FindCommand</code> has a user-specified
 * keyword and prints out all the tasks in the task list which contains the
 * keyword, in a readable table.
 */
public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Prints out all the tasks in the task list which contains the keyword.
     * @param tasks list of tasks given.
     * @param ui ui object given.
     * @param storage storage given.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        TaskList matchingTasks = new TaskList();
        for (Task task : tasks.getTasks()) {
            if (task.getText().contains(this.keyword)) {
                matchingTasks.add(task);
            }
        }
        if (matchingTasks.isEmpty()) {
            ui.print(String.format("Sorry! There are no tasks that matches '%s'.", this.keyword));
            return;
        }
        ListCommand listCommand = new ListCommand();
        listCommand.execute(matchingTasks, ui, storage);
    }

    /**
     * Overriding equals to compare two FindCommand objects.
     * @param o object to be compared with current FindCommand instance.
     * @return True if the keyword is equivalent.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof FindCommand && this.keyword == ((FindCommand) o).keyword;
    }
}
