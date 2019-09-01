package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks. A <code>TaskList</code> corresponds to a list and
 * behaves like a regular list, with add, remove and get functionality.
 */
public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the list of tasks.
     * @return the list of tasks.
     */
    public List<Task> getTasks() {
        return this.tasks;
    }

    /**
     * Returns the size of the TaskList.
     * @return the size of the TaskList.
     */
    public int getSize() {
        return this.tasks.size();
    }

    /**
     * Adds a task to the TaskList.
     * @param task task to be added.
     */
    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * Returns the task at the index specified by the given int.
     * @param index index of task to be returned.
     * @return task at the given index.
     */
    public Task get(int index) {
        return this.tasks.get(index);
    }

    /**
     * Removes the task at the index specified by the given int.
     * @param index index of task to be removed.
     */
    public void remove(int index) {
        this.tasks.remove(index);
    }
}
