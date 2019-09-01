package duke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    Ui() {
        this.scanner = new Scanner(System.in);
    }

    void showLoadingError() {
        print("There is no saved task list. I've created a new one for you.");
    }

    void showError(String error) {
        print(error);
    }

    void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        greet();
    }

    String readCommand() {
        return this.scanner.nextLine();
    }

    private static void greet() {
        String message = "Hello! I'm Duke.\n     What can I do for you?";
        print(message);
    }

    public static void print(String message) {
        List<String> list = new ArrayList<>();
        list.add(message);
        System.out.println(new Message(list));
    }
}
