import java.util.Scanner;

public class Chara {
    public static long lineLen = 80;

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
     * @param list array of tasks
     * @param listLength number of tasks currently in the list
     */
    public static void printList(Task[] list, int listLength) {
        for (int i = 0; i < listLength; i += 1) {
            System.out.print(i + 1 + ". ");
            list[i].printTask();
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
     * Creates the appropriate Task subclass (Todo, Deadline, Event) from user input.
     * If the input does not match a valid syntax, returns null.
     *
     * @param input user input string
     * @return the created Task object, or null if input format does not match
     */
    private static boolean handleMarkCommands(String input, Task[] list, int listLength) {
        String[] parts = input.split("\\s+", 2);

        boolean hasTwoParts = parts.length == 2;
        boolean isMark = hasTwoParts && parts[0].equals("mark");
        boolean isUnmark = hasTwoParts && parts[0].equals("unmark");
        boolean hasNumber = hasTwoParts && isInteger(parts[1]);

        if ((isMark || isUnmark) && hasNumber) {
            int taskNum = Integer.parseInt(parts[1].trim());
            if (taskNum <= 0 || taskNum > listLength) {
                System.out.println("Chara: That task doesn't exist...");
                return true;
            }
            Task t = list[taskNum - 1];
            if (isMark) {
                t.markAsDone();
                System.out.println("Chara: You never fail to impress!");
            } else {
                t.markAsNotDone();
                System.out.println("Chara: This feels familiar.");
            }
            t.printTask();
            System.out.println();
            return true;
        }
        return false;
    }


    private static Task createTaskFromInput(String input) {
        if (input.startsWith("todo ")) {
            String description = input.substring("todo".length()).trim();
            return new Todo(description);
        }

        if (input.startsWith("deadline ") && input.contains("/by")) {
            String s = input.substring("deadline".length()).trim();
            String[] parts = s.split("/by", 2);
            String description = parts[0].trim();
            String by = parts[1].trim();
            return new Deadline(description, by);
        }

        if (input.startsWith("event ") && input.contains("/from") && input.contains("/to")) {
            String s = input.substring("event".length()).trim();
            int fromIndex = s.indexOf("/from");
            int toIndex = s.indexOf("/to");
            String description = s.substring(0, fromIndex).trim();
            String from = s.substring(fromIndex + "/from".length(), toIndex).trim();
            String to = s.substring(toIndex + "/to".length()).trim();
            return new Event(description, from, to);
        }

        return null;
    }

    private static String taskPreview(Task t) {
        return t.taskTypeIcon + t.statusIcon + ' ' + t.description;
    }

    /**
     * Runs the program loop that accepts user input and manages the task list.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        printIntro();
        Scanner echo = new Scanner(System.in);

        Task[] list = new Task[100];
        int listLength = 0;

        while (true) {
            System.out.print("User: ");
            String input = echo.nextLine().trim();

            if (input.equals("bye")) {
                printOutro();
                return;
            }

            if (input.equals("list")) {
                if (listLength == 0) {
                    System.out.println("Chara: Your list is empty, silly!");
                } else {
                    System.out.println("Chara: Here's your list! (What's it for anyway?)");
                    printList(list, listLength);
                }
                printLine(lineLen);
                continue;
            }

            if (handleMarkCommands(input, list, listLength)) {
                printLine(lineLen);
                continue;
            }

            Task added = createTaskFromInput(input);
            if (added == null) {
                added = new Task(input);
            }

            if (listLength < list.length) {
                list[listLength] = added;
                listLength += 1;
                System.out.println("Chara has added \"" + taskPreview(added) + "\" to your list.");
                System.out.println("Now you have " + listLength + " task(s) in the list =)");
            } else {
                System.out.println("Chara: Your list is full! (wow.)");
            }
            printLine(lineLen);
        }
    }
}