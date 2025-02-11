package duke.command;

import duke.exception.DukeEmptyDescriptionException;
import duke.exception.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.DukeInvalidTaskException;
import duke.task.Task;

/**
 * Executes the command to mark all tasks.
 *
 * @author Lim Ai Lin
 */
public class MarkCommand extends Command {
    private final String[] STR;
    private final boolean IS_MARK;

    /**
     * Creates a new MarkCommand object.
     *
     * @param str The array String of the index of the task to be marked or unmarked from the list.
     * @param mark The boolean specifying whether the task is to be marked or unmarked.
     */
    public MarkCommand(String[] str, boolean mark) {
        this.STR = str;
        this.IS_MARK = mark;
    }

    /**
     * Executes the mark command the user inputs.
     *
     * @param tasks The list containing the task to be marked or unmarked.
     * @param ui The ui to deal with user interactions.
     * @param storage The storage to be updated with the newly marked or unmarked object.
     * @throws DukeException
     *          Thrown when the index is not given.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        int index;
        Task myTask;

        try {
            index = Integer.parseInt(STR[1]) - 1;
        } catch (Exception e) {
            throw new DukeEmptyDescriptionException();
        }

        if (index > tasks.getTaskSize() || index < 0) {
            throw new DukeInvalidTaskException();
        }

        myTask = tasks.getTask(index);
        if (IS_MARK) {
            myTask.markAsDone();
            storage.writeFile(tasks);
            return ui.complete(myTask);
        } else {
            myTask.markAsUndone();
            storage.writeFile(tasks);
            return ui.incomplete(myTask);
        }
    }
}
