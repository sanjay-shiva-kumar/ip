public class Task {
    protected String description;
    protected boolean isDone;
    protected String statusIcon;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        statusIcon = "[ ]";
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
        statusIcon = getStatusIcon();
    }

    public void markAsNotDone() {
        this.isDone = false;
        statusIcon = getStatusIcon();
    }

    public void printTask() {
        System.out.print(statusIcon + ' ' + description);
    }
    //...
}
