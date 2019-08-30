package duke.command;

import duke.*;
import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command {
    public ListCommand() {}

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        List<String> list = new ArrayList<>();
        list.add("Here are the tasks in your list:");
        int index = 1;
        for (Task task : tasks.getTasks()) {
            String message = String.format("%d.%s", index, task);
            list.add(message);
            index += 1;
        }
        System.out.println(new Message(list));
    }
}
