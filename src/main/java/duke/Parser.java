package duke;

import duke.command.AddCommand;
import duke.command.Command;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.ExitCommand;
import duke.command.FindCommand;
import duke.command.ListCommand;

import java.util.Arrays;

/**
 * Represents a reader. A <code>Parser</code> parses and understands a given
 * string and tells the Ui which command to be run next.
 */
public class Parser {
    /**
     * Reads the given string and processes it accordingly to return
     * an appropriate Command.
     * @param command given string.
     * @return matching Command object as implied from the given string.
     * @throws DukeException if the format of the given string is invalid.
     */
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
                return new DoneCommand(Integer.parseInt(commandList[1]));
            case "delete":
                if (commandList.length == 1) {
                    throw new DukeException("☹ OOPS!!! The task index cannot be empty.");
                }
                return new DeleteCommand(Integer.parseInt(commandList[1]));
            case "find":
                String keyword = String.join(" ", Arrays.copyOfRange(commandList, 1, commandList.length));
                return new FindCommand(keyword);
            default:
                return new AddCommand(command);
            }
        }
    }
}
