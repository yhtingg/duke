package duke.command;

import duke.Datetime;
import duke.DukeException;
import duke.Message;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents an add Command. A <code>AddCommand</code> adds a task to the list of tasks.
 */
public class AddCommand extends Command {
    private String command;

    public AddCommand(String command) {
        this.command = command;
    }

    /**
     * Adds a Todo to the task list.
     * @param task todo to be added.
     * @param tasks task list to modify.
     * @return the todo that has been added.
     */
    private static Todo addTodo(String task, TaskList tasks) {
        Todo todo = new Todo(task);
        tasks.add(todo);
        return todo;
    }

    /**
     * Adds a Deadline to the task list.
     * @param task deadline to be added.
     * @param tasks task list to modify.
     * @return the deadline that has been added.
     * @throws DukeException if format of datetime supplied is invalid.
     */
    private static Deadline addDeadline(String task, TaskList tasks) throws DukeException {
        String[] attr = task.split(" /by ");
        assert attr.length == 2 : " Follow the format deadline {name} /by DD/MM/YYYY {Time in 24 hour format}";
        String text = attr[0];
        String datetime = attr[1];
        if (Datetime.matches(datetime)) {
            Deadline deadline = new Deadline(text, new Datetime(datetime));
            tasks.add(deadline);
            return deadline;
        } else {
            throw new DukeException("☹ OOPS!!! A valid datetime was not submitted.");
        }
    }

    /**
     * Adds an Event to the task list.
     * @param task event to be added.
     * @param tasks task list to modify.
     * @return the event that has been added.
     * @throws DukeException if format of datetime supplied is invalid.
     */
    private static Event addEvent(String task, TaskList tasks) throws DukeException {
        String[] attr = task.split(" /at ");
        assert attr.length == 2 : " Follow the format event {name} /at DD/MM/YYYY {Time in 24 hour format}";
        String text = attr[0];
        String datetime = attr[1];
        if (Datetime.matches(datetime)) {
            Event event = new Event(text, new Datetime(datetime));
            tasks.add(event);
            return event;
        } else {
            throw new DukeException("☹ OOPS!!! A valid datetime was not submitted.");
        }
    }

    /**
     * Handles the task appropriately by the task type.
     * @param tasks task list to modify.
     * @param taskType type of the task.
     * @param taskText text of the task.
     * @return the task that has been added.
     * @throws DukeException if task text is empty.
     */
    private Task addTask(TaskList tasks, String taskType, String taskText) throws DukeException {
        switch (taskType) {
        case "todo":
            if (taskText.isEmpty()) {
                throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
            }
            return addTodo(taskText, tasks);
        case "deadline":
            if (taskText.isEmpty()) {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
            }
            return addDeadline(taskText, tasks);
        case "event":
            if (taskText.isEmpty()) {
                throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.");
            }
            return addEvent(taskText, tasks);
        default:
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Adds the task into the task list.
     * @param tasks list of tasks given.
     * @param ui ui object given.
     * @param storage storage given.
     * @throws DukeException if task is empty or user is trying to add something
     *     other than a todo, deadline or event
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] commandList = this.command.split(" ");
        String taskType = commandList[0];
        String taskText = String.join(" ", Arrays.copyOfRange(commandList, 1, commandList.length));
        Task task = this.addTask(tasks, taskType, taskText);

        List<String> list = new ArrayList<>();
        list.add("Got it. I've added this task:");
        list.add(String.format("  %s", task));
        String noun = tasks.getSize() > 1 ? "tasks" : "task";
        list.add(String.format("Now you have %d %s in the list.", tasks.getSize(), noun));
        ui.print(new Message(list));
    }
}
