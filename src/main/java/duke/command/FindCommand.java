package duke.command;

import duke.Message;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

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
        List<String> list = new ArrayList<>();
        list.add("Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : matchingTasks.getTasks()) {
            String message = String.format("%d.%s", index, task);
            list.add(message);
            index += 1;
        }
        ui.print(new Message(list));
    }
}
