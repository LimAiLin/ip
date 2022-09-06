package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Deals with interactions with the user.
 *
 * @author Lim Ai Lin
 */
public class Ui {

    private static final String LINE = "Dino:\n";

    /**
     * Creates a new Ui object.
     */
    public Ui() {
        System.out.println("               __\n"
                + "              / _)\n"
                + "     _.----._/ /\n"
                + "    /         /\n"
                + " __/ (  | (  |\n"
                + "/__.-'|_|--|_|\n");

        System.out.println(LINE
                + "\tHello! I'm Dino\n"
                + "\tWhat can I do for you?\n");
    }

    /**
     * Prints a message when Duke faces a loading error.
     */
    public void showLoadingError() {
        System.out.println("RAWR! Error loading previous tasks.");
    }

    /**
     * Prints a message showing bot and user interaction.
     */
    public void showLine() {
        System.out.print(LINE);
    }

    /**
     * Prints a message when the user wishes to exit.
     */
    public void exit() {
        System.out.println("\tBye bye. Hope to see you again soon!");
    }

    /**
     * Throws an exception when the user does not enter a valid description.
     *
     * @throws DukeException
     *          Thrown when description is empty.
     */
    public void emptyDescription() throws DukeException {
        throw new DukeException("RAWR! Empty description.");
    }

    /**
     * Throws an exception when the user does not enter a valid task.
     *
     * @throws DukeException
     *          Thrown when task is invalid.
     */
    public static void invalidTask() throws DukeException {
        throw new DukeException("RAWR! Invalid task.");
    }

    /**
     * Throws an exception when the user does not enter a date when needed.
     *
     * @throws DukeException
     *          Thrown when there is a missing date.
     */
    public void missingDate() throws DukeException {
        throw new DukeException("RAWR! Missing date.");
    }

    /**
     * Prints a message when the user has marked a task.
     *
     * @param myTask The task that the user has marked.
     */
    public void complete(Task myTask) {
        System.out.println("\tHooray! You have completed this task:\n\t" + myTask);
    }

    /**
     * Prints a message when the user has unmarked a task.
     *
     * @param myTask The task that the user has unmarked.
     */
    public void incomplete(Task myTask) {
        System.out.println("\tOh no! You have more things to complete:\n\t" + myTask);
    }

    /**
     * Prints a new line.
     */
    public void newLine() {
        System.out.print("\n");
    }

    /**
     * Prints a message when the user has added a new task to the list.
     *
     * @param taskList The tasklist the user has added to.
     * @param task The task the user has added.
     */
    public void add(TaskList taskList, Task task) {
        System.out.println("\tadded: " + task);
        System.out.println("\tYou have " + taskList.size() + " task" + (taskList.size() > 1 ? "s!" : "!"));
    }

    public void match(ArrayList<Task> matching) {
        System.out.println("\tHere are the matching tasks Dino found:");
        for (int i = 0; i < matching.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + matching.get(i).toString());
        }
    }

    /**
     * Prints a message when the user has removed a new task from the list.
     *
     * @param taskList The tasklist the user has removed from.
     * @param task The task the user has removed.
     */
    public void remove(TaskList taskList, Task task) {
        System.out.println("\tRemoving " + task + "...");
        System.out.println("\tYou have " + taskList.size() + " task" + (taskList.size() > 1 ? "s!" : "!"));
    }
}
