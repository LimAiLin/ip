public class Task {
    private final String description;
    private boolean isDone;
    private static int num = 0;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        num++;
    }

    private String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsUndone() {
        this.isDone = false;
    }

    public String getStatus() { return (isDone ? "1" : "0"); }

    public String getDescription() { return description; }

    public static int lsSize() { return num; }

    public void remove() {
        System.out.println("\tRemoving " + this + "...");
        num--;
        System.out.println("\tYou have " + num + " task" + (num > 1 ? "s!" : "!"));
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + description;
    }
}
