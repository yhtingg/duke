import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showLoadingError() {
        print("There is no saved task list. I've created a new one for you.");
    }

    public void showError(String error) {
        print(error);
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        greet();
    }

    public String readCommand() {
        return this.scanner.nextLine();
    }

    public static void greet() {
        String message = "Hello! I'm Duke\n     What can I do for you?";
        print(message);
    }

    public static void print(String message) {
        List<String> list = new ArrayList<>();
        list.add(message);
        System.out.println(new Message(list));
    }
}
