package seedu.address.logic.parser;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.LoginCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

/**
 * Parses user input.
 */
public class ProManageParser {
    /**
     * Used for initial separation of command word and args.
     */

    private CommandsParser commandsParser;
    public ProManageParser() {
        this.commandsParser = new DefaultParser();
    }

    /**
     * @param userInput
     * @return Command
     * @throws ParseException
     */

    public Command parseCommand(String userInput, Model model) throws CommandException, ParseException {
        Command command = commandsParser.parseCommand(userInput);
        if (command instanceof LoginCommand) {
            this.commandsParser = ((LoginCommand) command).getParser(model);
        }
        return command;
    }
}
