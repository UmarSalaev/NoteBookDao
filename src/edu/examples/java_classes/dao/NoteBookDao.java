package edu.examples.java_classes.dao;

import java.io.IOException;


import edu.examples.java_classes.entity.Note;

public interface NoteBookDao {

	void add(Note n) throws DaoException, IOException;

	void update(Note n) throws DaoException, IOException;

	void show() throws DaoException, IOException;;
	
	void delete() throws DaoException, IOException;


}
