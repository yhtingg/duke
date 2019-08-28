import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

public class Data {
    private String filepath;

    public Data(String filepath) {
        this.filepath = filepath;
    }

    public List<Task> read() {
        List<Task> tasks = new ArrayList<>();
        try (FileReader reader = new FileReader(this.filepath);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] task = line.split(" \\| ");
                String text = task[2];
                String taskType = task[0];
                Boolean done = task[1].equals("1");
                if (taskType.equals("T")) {
                    tasks.add(new Todo(text, done));
                } else if (taskType.equals("D")) {
                    tasks.add(new Deadline(text, done, new Date(task[3])));
                } else if (taskType.equals("E")) {
                    tasks.add(new Event(text, done, new Date(task[3])));
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return tasks;
    }

    public void save() {
        try (FileWriter writer = new FileWriter(this.filepath);
             BufferedWriter bw = new BufferedWriter(writer)) {
            String line;
            for (Task task : Duke.tasks) {
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
