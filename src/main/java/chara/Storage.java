package chara;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


import chara.task.Deadline;
import chara.task.Event;
import chara.task.Task;
import chara.task.Todo;


/**
 * Simple persistence layer for tasks.
 * File format (UTF-8, '|' separated):
 *   T | 0 |read book
 *   D | 1 | return book (by: June 6th)
 *   E | 0 | project meeting (from: Aug 6th 2pm to: 4pm)
 */
public final class Storage {
    private Storage() {}

    /**
     * Loads tasks from the specified file into a list.
     * Each line of the file is parsed back into the corresponding Task subclass
     * (Todo, Deadline, or Event). If the file does not exist, an empty list is
     * returned. Malformed or corrupted lines are skipped to ensure the program
     * can still start up cleanly.
     *
     * @param path the file path to read tasks from (e.g., data/chara.txt)
     * @return a list of tasks reconstructed from the file, or an empty list if the file does not exist
     * @throws IOException if an I/O error occurs during reading
     */
    public static List<Task> load(Path path) throws IOException {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(path)) {
            // First run: make sure parent directory exists; return empty list.
            if (path.getParent() != null) Files.createDirectories(path.getParent());
            return tasks;
        }

        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line : lines) {
            if (line.isBlank()) continue;
            String[] t = line.split("\\|", -1);
            try {
                switch (t[0]) {
                case "T": {
                    boolean done = "1".equals(t[1]);
                    String desc = t[2];
                    Task td = new Todo(desc);
                    if (done) td.markAsDone(); else td.markAsNotDone();
                    tasks.add(td);
                    break;
                }
                case "D": {
                    boolean done = "1".equals(t[1]);
                    String desc = t[2];
                    String by   = t[3];
                    Task dl = new Deadline(desc, by);
                    if (done) dl.markAsDone(); else dl.markAsNotDone();
                    tasks.add(dl);
                    break;
                }
                case "E": {
                    boolean done = "1".equals(t[1]);
                    String desc  = t[2];
                    String from  = t[3];
                    String to    = t[4];
                    Task ev = new Event(desc, from, to);
                    if (done) ev.markAsDone(); else ev.markAsNotDone();
                    tasks.add(ev);
                    break;
                }
                default:
                    // Unknown line type: skip it (stretch: log a warning)
                }
            } catch (Exception ignoreMalformedLine) {
                // Corrupted/short line: skip but continue loading others
            }
        }
        return tasks;
    }

    /**
     * Saves the current list of tasks to the specified file in a human-readable format.
     * Each task is serialized according to its type (Todo, Deadline, Event) with
     * additional information included for deadlines ("by:") and events ("from:" / "to:").
     * Automatically creates the parent directory and file if they do not exist.
     *
     * @param tasks the list of tasks to be saved
     * @param path  the file path where the task data will be written (e.g., data/chara.txt)
     * @throws IOException if an I/O error occurs during writing
     */
    public static void save(List<Task> tasks, Path path) throws IOException {
        if (path.getParent() != null) Files.createDirectories(path.getParent());

        List<String> out = new ArrayList<>(tasks.size());
        for (Task t : tasks) {
            if (t instanceof Todo) {
                out.add(String.format("T | %d | %s",
                        t.isDone() ? 1 : 0,
                        t.getDescription()));
            } else if (t instanceof Deadline) {
                Deadline d = (Deadline) t;
                out.add(String.format("D | %d | %s (by: %s)",
                        t.isDone() ? 1 : 0,
                        d.getDescription(),
                        d.getBy()));
            } else if (t instanceof Event) {
                Event e = (Event) t;
                out.add(String.format("E | %d | %s (from: %s to: %s)",
                        t.isDone() ? 1 : 0,
                        e.getDescription(),
                        e.getFrom(),
                        e.getTo()));
            }
        }

        Files.write(path, out, StandardCharsets.UTF_8);
    }
}