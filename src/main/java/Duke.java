import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        greet();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        while (!command.equals("bye")) {
            echo(command);
            command = scanner.next();
        }

        exit();
    }

    public static void greet() {
        String message = "Hello! I'm Duke\n     What can I do for you?";
        System.out.println(new Message(message));
    }

    public static void echo(String string) {
        System.out.println(new Message(string));
    }

    public static void exit() {
        String message = "Bye. Hope to see you again soon!";
        System.out.println(new Message(message));
    }
}
