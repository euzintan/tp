package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MODULES;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.ui.Ui;

/**
 * Lists all persons in the address book to the user.
 */
public class ListTutorialGroupCommand extends Command {

    public static final String COMMAND_WORD = "listTG";

    public static final String MESSAGE_SUCCESS = "Listed all Tutorial Groups";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(
            String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredTutorialGroupList().size()));
    }
}
