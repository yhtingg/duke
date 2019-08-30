package duke;

import duke.command.*;

import java.util.Arrays;

public class Parser {
    public static Command parse(String command) throws DukeException {
        if (command.equals("bye")) {
            return new ExitCommand();
        } else if (command.equals("list")) {
            return new ListCommand();
        } else {
            // check if the first word of the line is 'done'
            String[] commandList = command.split(" ");
            String firstWord = commandList[0];
            switch (firstWord) {
            case "done":
                if (commandList.length == 1) {
                    throw new DukeException("☹ OOPS!!! The task index cannot be empty.");
                }
                return new DoneCommand(Integer.valueOf(commandList[1]));
            case "delete":
                if (commandList.length == 1) {
                    throw new DukeException("☹ OOPS!!! The task index cannot be empty.");
                }
                return new DeleteCommand(Integer.valueOf(commandList[1]));
            case "find":
                String keyword = String.join(" ", Arrays.copyOfRange(commandList, 1, commandList.length));
                return new FindCommand(keyword);
            default:
                return new AddCommand(command);
            }
        }
    }
}
