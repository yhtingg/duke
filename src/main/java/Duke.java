import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Integer;

public class Duke {
    public static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        greet();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("bye")) {
            if (command.equals("list")) {
                list();
            } else {
                // check if the first word of the line is 'done'
                String[] commandList = command.split(" ");
                if (commandList[0].equals("done")) {
                    done(Integer.valueOf(commandList[1]));
                } else {
                    add(command);
                }
            }
            command = scanner.nextLine();
        }

        exit();
    }

    public static void greet() {
        String message = "Hello! I'm Duke\n     What can I do for you?";
        print(message);
    }

    public static void echo(String message) {
        print(message);
    }

    public static void exit() {
        String message = "Bye. Hope to see you again soon!";
        print(message);
    }

    public static void add(String task) {
        tasks.add(new Task(task));
        print(String.format("added: %s", task));
    }

    public static void list() {
        List<String> list = new ArrayList<>();
        list.add("Here are the tasks in your list:");
        int index = 1;
        for (Task task : tasks) {
            String message;
            if (task.isDone()) {
                message = String.format("%d.[✓] %s", index, task.getText());
            } else {
                message = String.format("%d.[✗] %s", index, task.getText());
            }
            list.add(message);
            index += 1;
        }
        System.out.println(new Message(list));
    }

    public static void done(int num) {
        Task task = tasks.get(num - 1);
        task.markAsDone();
        List<String> list = new ArrayList<>();
        list.add("Nice! I've marked this task as done:");
        list.add(String.format("  [✓] %s", task.getText()));
        System.out.println(new Message(list));
    }

    public static void print(String message) {
        List<String> list = new ArrayList<>();
        list.add(message);
        System.out.println(new Message(list));
    }
}
