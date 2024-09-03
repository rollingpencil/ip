package tohru.command;

import tohru.exception.TohruException;
import tohru.storage.FileStore;
import tohru.task.TodoList;
import tohru.ui.Ui;

/**
 * Represents the command to mark a task as complete in the to-do list.
 */
public class MarkCommand extends Command {

    /** Prefix used to invoke the mark command */
    public static final String COMMAND_PREFIX = "mark";

    /**
     * Initialises the command object.
     *
     * @param arguments Arguments passed to the command.
     */
    public MarkCommand(String arguments) {
        super(arguments);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(TodoList list, Ui ui, FileStore store) throws TohruException {
        // Check if no arguments are provided
        if (super.arguments == null) {
            throw new TohruException("Missing argument: Specify index to mark");
        }

        int itemIndex = -1;

        // Check for valid index
        try {
            itemIndex = Integer.parseInt(arguments) - 1;
        } catch (NumberFormatException e) {
            throw new TohruException(String.format("%s is not valid index", arguments));
        }

        list.markComplete(itemIndex);

        ui.showText("Alright! I have set this task as done:",
                list.getItemStatus(itemIndex));

        store.saveTodoList(list.getTodoList());

    }
}
