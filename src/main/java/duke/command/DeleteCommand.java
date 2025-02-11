package duke.command;

import duke.exception.DukeEmptyDescriptionException;
import duke.exception.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.DukeInvalidTaskException;
import duke.task.Task;

/**
 * Executes the commands to delete tasks from the list.
 *
 * @author Lim Ai Lin
 */
public class DeleteCommand extends Command {

    private final String[] STR;

    /**
     * Creates a new DeleteCommand object.
     *
     * @param str The array String containing the index of the task to be deleted from the list.
     */
    public DeleteCommand(String[] str) {
        this.STR = str;
    }

    /**
     * Executes the delete command the user inputs.
     *
     * @param tasks The task list in which the task is to be deleted.
     * @param ui The ui to deal with user interactions.
     * @param storage The storage to be updated with the newly deleted task.
     * @throws DukeException
     *          Thrown when the index is not given.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int index;
        try {
            index = Integer.parseInt(STR[1]) - 1;
        } catch (Exception e) {
            throw new DukeEmptyDescriptionException();
        }

        if (index > tasks.getTaskSize() || index < 0) {
            throw new DukeInvalidTaskException();
        }

        Task myTask = tasks.getTask(index);
        tasks.remove(index);
        storage.writeFile(tasks);
        return ui.remove(tasks, myTask);
    }
}
