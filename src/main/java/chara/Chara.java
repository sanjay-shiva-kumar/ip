package chara;

import java.nio.file.Path;
import java.nio.file.Paths;

import chara.exception.CharaException;
import chara.task.Task;


public class Chara {
    private Ui ui;
    private static final Path SAVE_PATH = Paths.get("data", "chara.txt");

    /**
     * Runs the main loop of the chatbot.
     * Continuously reads user input, processes commands, and manages the task list.
     * All invalid commands are handled by throwing and catching chara.exception.CharaException.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.printIntro();

        TaskList tasks = new TaskList();
        try {
            tasks = Storage.load(SAVE_PATH);
        } catch (Exception e) {
            tasks = new TaskList();
            ui.printLoadingError();
        }

        while (true) {
            String input = ui.readCommand();

            if (input.equals("bye")) {
                ui.printOutro();
                return;
            }

            if (input.equals("list")) {
                ui.printList(tasks);
                ui.printLine();
                continue;
            }

            try {
                if (input.startsWith("mark") || input.startsWith("unmark")) {
                    Parser.handleMarkCommands(input, tasks, ui);
                    Storage.saveQuietly(tasks, SAVE_PATH);
                    ui.printLine();
                    continue;
                }

                if (input.startsWith("delete")) {
                    Parser.handleDeleteCommand(input, tasks, ui);
                    Storage.saveQuietly(tasks, SAVE_PATH);
                    ui.printLine();
                    continue;
                }

                Task added = Parser.createTaskFromInput(input);
                tasks.add(added);
                ui.printAdded(added, tasks.size());
                Storage.saveQuietly(tasks, SAVE_PATH);

            } catch (CharaException e) {
                ui.printError(e.getMessage());
            }
            ui.printLine();
        }
    }
}
