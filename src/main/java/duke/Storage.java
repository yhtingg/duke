package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public List<Task> load() throws DukeException {
        List<Task> tasks = new ArrayList<>();
        try (FileReader reader = new FileReader(this.filepath);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] task = line.split(" \\| ");
                String text = task[2];
                String taskType = task[0];
                boolean done = task[1].equals("1");
                switch (taskType) {
                case "T":
                    tasks.add(new Todo(text, done));
                    break;
                case "D":
                    tasks.add(new Deadline(text, done, new Date(task[3])));
                    break;
                case "E":
                    tasks.add(new Event(text, done, new Date(task[3])));
                    break;
                default:
                    break;
                }
            }
            if (tasks.isEmpty()) {
                throw new DukeException("");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return tasks;
    }

    public void save(TaskList tasks) {
        try (FileWriter writer = new FileWriter(this.filepath);
             BufferedWriter bw = new BufferedWriter(writer)) {
            String line;
            for (Task task : tasks.getTasks()) {
                if (task instanceof Todo) {
                    line = String.format("%s | %d | %s\n", task.getType(), task.isDone() ? 1 : 0, task.getText());
                } else {
                    line = String.format("%s | %d | %s | %s\n", task.getType(), task.isDone() ? 1 : 0, task.getText(), task.getDate().getRawDate());
                }
                bw.write(line);
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
