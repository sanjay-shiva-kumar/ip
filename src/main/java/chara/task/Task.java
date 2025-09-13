package chara.task;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String taskTypeIcon;
    protected String statusIcon;

    /**
     * Constructs a chara.task.Task with the given description, initially not done.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.statusIcon = getStatusIcon();
        this.taskTypeIcon = getTaskTypeIcon();
    }

    public String getTaskTypeIcon() {
        return "   ";
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]");
    }

    public void markAsDone() {
        this.isDone = true;
        this.statusIcon = getStatusIcon();
    }

    public void markAsNotDone() {
        this.isDone = false;
        this.statusIcon = getStatusIcon();
    }

    public void printTask() {
        System.out.print(taskTypeIcon + statusIcon + ' ' + description);
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }
}
