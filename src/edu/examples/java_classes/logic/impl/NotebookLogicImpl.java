package edu.examples.java_classes.logic.impl;

import java.io.IOException;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.DaoProvider;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.NotebookLogic;

public class NotebookLogicImpl implements NotebookLogic {
	private final DaoProvider provider = DaoProvider.getInstance();
	private final NoteBookDao dao = provider.getNoteBookDao();

	public void add(Note n) throws LogicException {

		try {
			try {
				dao.add(n);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	public void update(Note n) throws LogicException {

		try {
			dao.update(n);
		} catch (DaoException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void show() throws LogicException {
		try {
			dao.show();
		} catch (DaoException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void delete() throws LogicException {

		try {
			dao.delete();
		} catch (IOException | DaoException e) {

			e.printStackTrace();
		}

	}
}
