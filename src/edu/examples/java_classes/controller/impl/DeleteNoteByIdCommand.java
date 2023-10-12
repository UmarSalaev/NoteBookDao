package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;

import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class DeleteNoteByIdCommand implements Command {
	private final LogicProvider logicProvider = LogicProvider.getInstance();
	private final NotebookLogic logic = logicProvider.getNotebookLogic();

	@Override
	public String execute(String request) {
		String response = null;

		try {
			logic.delete();

			response = "Все записи успешно удалены.";
		} catch (LogicException e) {
			response = "Что- то пошло не так. Попробуйте ещё раз";
		}
		return response;
	}
}
