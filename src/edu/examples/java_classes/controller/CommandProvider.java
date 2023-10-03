package edu.examples.java_classes.controller;

import java.util.HashMap;
import java.util.Map;
import edu.examples.java_classes.controller.impl.ShowAllNotesCommand;
import edu.examples.java_classes.controller.impl.AddNoteCommand;
import edu.examples.java_classes.controller.impl.DeleteNoteByIdCommand;
import edu.examples.java_classes.controller.impl.NoSuchCommand;
import edu.examples.java_classes.controller.impl.UpdateNoteCommand;

public class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.ADD, new AddNoteCommand());
		repository.put(CommandName.UPDATE, new UpdateNoteCommand());
		repository.put(CommandName.SHOW, new ShowAllNotesCommand());
        repository.put(CommandName.DELETE, new DeleteNoteByIdCommand());
		repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			// write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}

}
