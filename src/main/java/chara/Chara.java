package chara;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chara.exception.BadFormatException;
import chara.exception.CharaException;
import chara.exception.EmptyDescriptionException;
import chara.exception.UnknownCommandException;
import chara.task.Deadline;
import chara.task.Event;
import chara.task.Task;
import chara.task.Todo;

public class Chara {
    public static long lineLen = 80;

    private static final Path SAVE_PATH = Paths.get("data", "chara.txt");

    /**
     * Prints a horizontal line of underscores with the given length.
     *
     * @param length number of underscores to print
     */
    public static void printLine(long length) {
        for (long i = 0; i < length; i += 1) {
            System.out.print('_');
        }
        System.out.println();
    }

    /**
     * Prints the introduction message and character greeting at program start.
     */
    public static void printIntro() {
        printLine(lineLen);
        String logo = """
                  ____ _   _    _    ____   _   \s
                 / ___| | | |  / \\  |  _ \\ / \\  \s
                | |   | |_| | / _ \\ | |_) / _ \\ \s
                | |___|  _  |/ ___ \\|  _ < ___ \\\s
                 \\____|_| |_/_/   \\_\\_| \\_\\_/ \\_\\
                """;
        String charaSprite = """
                ⣿⣿⡿⠛⠉⠉⠉⠉⠉⠉⠉⠛⣿⣿⣿
                ⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠹⣿
                ⡏⠁⠀⣤⣶⣦⠀⣤⣤⣤⡀⠀⠀⠀⢿
                ⠁⠀⣶⣿⡇⢸⣿⣿⡇⢸⣿⠀⣀⡆⠀
                ⠀⠀⣿⣿⣷⡞⢿⠿⠓⣾⣿⡶⠋⠁⠀
                ⡀⢀⠀⠉⠩⠿⠶⣶⣿⠏⠉⠀⢀⡀⣀
                ⣧⣼⣦⣤⣤⡤⠐⠿⠿⠠⢤⣤⣸⣧⣿
                ⣿⣿⠛⣭⠉⡵⠤⡤⠤⡴⣤⠉⡝⢻⣿
                ⣿⡇⠇⠀⣿⣿⣿⣿⣿⣿⣿⡄⠸⠇⣿
                ⣿⡇⠒⠀⠁⠈⠀⠁⠈⠀⠀⠁⠐⠂⣿
                ⣿⣿⣿⠀⠀⠀⢠⣤⠀⠀⠀⠀⢸⣿⣿
                ⣿⣿⣿⣶⠒⠀⠰⣿⠀⠀⠀⠒⣾⣿⣿""";
        System.out.println(logo);
        System.out.println(charaSprite);
        System.out.println("Chara: Greetings.");
        System.out.println("Chara: I am Chara! =)");
        printLine(lineLen);
    }

    /**
     * Prints the outro message and character farewell at program end.
     */
    public static void printOutro() {
        System.out.println("Chara: Let us erase this chat, and move on to the next =)");
        String dogSprite = """
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠀⠀⢸⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣷⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣤⣾⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡿⠿⠿⢿⣿⣿⣿⣿⡿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⡇⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣯⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣷⣶⣶⣾⣿⣿⣿⣿⣷⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⠛⠛⠛⠛⠛⢛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣤⣤⣤⣤⣤⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠿⠿⠿⣿⣿⠀⠀⠀⠀⠀⠸⣿⣿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣿⣿⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣶⣶⡆⠈⠉⠀⠀⠀⠈⠉⠉⠉⠁⢰⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣧⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠛⠛⠛⠛⠛⢛⣿⣿⣿⣿⣟⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⢻⣿⣿⣿⣿⡟⠛⠛⠛⠛⠛⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀""";
        System.out.println(dogSprite);
        printLine(lineLen);
    }

    /**
     * Prints the current list of tasks with their indices.
     *
     * @param tasks ArrayList of tasks
     */
    public static void printList(List<Task> tasks) {
        for (int i = 0; i < tasks.size(); i += 1) {
            System.out.print((i + 1) + ". ");
            tasks.get(i).printTask();
            System.out.println();
        }
    }

    /**
     * Checks whether the given string can be parsed as an integer.
     *
     * @param input string to check
     * @return true if the string represents an integer, false otherwise
     */
    public static boolean isInteger(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Handles mark and unmark commands to change the completion status of tasks.
     * Throws a CharaException if the command is formatted incorrectly or refers to
     * an invalid task number.
     *
     * @param input user input string starting with "mark" or "unmark"
     * @param tasks the ArrayList of current tasks
     * @throws CharaException if the command format is invalid or the task number is out of range
     */
    private static void handleMarkCommands(String input, List<Task> tasks) throws CharaException {
        String[] parts = input.split("\\s+", 2);
        boolean hasTwoParts = parts.length == 2;
        boolean isMark = parts[0].equals("mark");
        boolean isUnmark = parts[0].equals("unmark");

        if (isMark || isUnmark) {
            if (!hasTwoParts || !isInteger(parts[1])) {
                throw new BadFormatException("Use this format: \"" + parts[0] + " <task_number>\" =)");
            }
            int taskNum = Integer.parseInt(parts[1].trim());
            if (taskNum <= 0 || taskNum > tasks.size()) {
                System.out.println("Chara: That task doesn't exist...");
                return;
            }
            Task t = tasks.get(taskNum - 1);
            if (isMark) {
                t.markAsDone();
                System.out.println("Chara: You never fail to impress!");
                System.out.print("Marked as done: ");
            } else {
                t.markAsNotDone();
                System.out.println("Chara: This feels familiar.");
                System.out.print("Unmarked as done: ");
            }
            t.printTask();
            System.out.println();
        }
    }

    /**
     * Creates the appropriate Task subclass (Todo, Deadline, Event) from user input.
     * Throws a chara.exception.CharaException if the input is not a valid command or has the wrong format.
     *
     * @param input user input string
     * @return the created chara.task.Task object
     * @throws CharaException if the input is invalid or does not match any command
     */
    private static Task createTaskFromInput(String input) throws CharaException {
        if (input.startsWith("todo")) {
            String description = input.substring("todo".length()).trim();
            if (description.isEmpty()) {
                throw new EmptyDescriptionException("todo");
            }
            return new Todo(description);
        }

        if (input.startsWith("deadline")) {
            String s = input.substring("deadline".length()).trim();
            if (!s.contains("/by")) {
                throw new BadFormatException(
                        "Use this format: \"deadline <description> /by <when>\" =)"
                );
            }
            String[] parts = s.split("/by", 2);
            String description = parts[0].trim();
            String by = parts[1].trim();
            if (description.isEmpty()) {
                throw new EmptyDescriptionException("deadline");
            }
            if (by.isEmpty()) {
                throw new BadFormatException("Your deadline needs a /by time!");
            }
            return new Deadline(description, by);
        }

        if (input.startsWith("event")) {
            String s = input.substring("event".length()).trim();
            if (!s.contains("/from") || !s.contains("/to")) {
                throw new BadFormatException(
                        "Use this format: \"event <description> /from <start> /to <end>\" =)"
                );
            }
            int fromIndex = s.indexOf("/from");
            int toIndex = s.indexOf("/to");
            String description = s.substring(0, fromIndex).trim();
            String from = s.substring(fromIndex + "/from".length(), toIndex).trim();
            String to = s.substring(toIndex + "/to".length()).trim();

            if (description.isEmpty()) {
                throw new EmptyDescriptionException("event");
            }
            if (from.isEmpty() || to.isEmpty()) {
                throw new BadFormatException(
                        "Your event needs both /from and /to times!!"
                );
            }
            return new Event(description, from, to);
        }

        // nothing matched
        throw new UnknownCommandException();
    }

    private static String taskPreview(Task t) {
        return t.getTaskTypeIcon() + t.getStatusIcon() + ' ' + t.getDescription();
    }

    private static void saveQuietly(List<Task> tasks) {
        try {
            Storage.save(tasks, SAVE_PATH);
        } catch (Exception e) {
            System.out.println("Chara: Couldn't SAVE to disk just now (it's okay, try again with more DETERMINATION!).");
        }
    }

    /**
     * Runs the main loop of the chatbot.
     * Continuously reads user input, processes commands, and manages the task list.
     * All invalid commands are handled by throwing and catching chara.exception.CharaException.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        printIntro();
        Scanner echo = new Scanner(System.in);

        List<Task> tasks = new ArrayList<>();
        try {
            tasks = Storage.load(SAVE_PATH);
        } catch (Exception e) {
            tasks = new ArrayList<>();
            System.out.println("Chara: A fresh start! (no save file yet).");
        }

        while (true) {
            System.out.print("User: ");
            String input = echo.nextLine().trim();

            if (input.equals("bye")) {
                printOutro();
                return;
            }

            if (input.equals("list")) {
                if (tasks.isEmpty()) {
                    System.out.println("Chara: Your list is empty, silly!");
                } else {
                    System.out.println("Chara: Here's your list! (What's it for anyway?)");
                    printList(tasks);
                }
                printLine(lineLen);
                continue;
            }

            try {
                if (input.startsWith("mark") || input.startsWith("unmark")) {
                    handleMarkCommands(input, tasks);
                    saveQuietly(tasks);
                    printLine(lineLen);
                    continue; // skip rest of loop, since it was a mark command
                }

                Task added = createTaskFromInput(input);
                tasks.add(added);  // no need for tasksLength or capacity checks
                System.out.println("Chara has added \"" + taskPreview(added) + "\" to your list.");
                System.out.println("Now you have " + tasks.size() + " task(s) in your list! =)");
                saveQuietly(tasks);

            } catch (CharaException e) {
                System.out.println("Chara: " + e.getMessage());
            }
            printLine(lineLen);
        }
    }
}