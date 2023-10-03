package edu.examples.java_classes.logic;



import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

	public void add(Note n) throws LogicException;

	public void update(Note n) throws LogicException;

	public void show() throws LogicException ;

	public void delete() throws LogicException;

	

}
