import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                add(command);
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

    public static void print(String message) {
        List<String> list = new ArrayList<>();
        list.add(message);
        System.out.println(new Message(list));
    }

    public static void add(String task) {
        tasks.add(new Task(task));
        print(String.format("added: %s", task));
    }

    public static void list() {
        List<String> list = new ArrayList<>();
        int index = 1;
        for (Task task : tasks) {
            list.add(String.format("%d. %s", index, task.text));;
            index += 1;
        }
        System.out.println(new Message(list));
    }
}
