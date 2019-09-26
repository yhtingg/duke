package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
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
        Command listCommand = new ListCommand();
        listCommand.execute(matchingTasks, ui, storage);
    }
}
