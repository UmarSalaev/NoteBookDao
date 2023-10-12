package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {
	private static String path = ("C:\\Users\\umar228\\Desktop\\text.txt");
	private static FileWriter writer;

	@Override
	public void add(Note n) throws DaoException, IOException {

		try (BufferedReader input = new BufferedReader(new FileReader(path))) {
			String last = null, line;
			while (null != (line = input.readLine()))
				last = line;
			if (last == null) {
				writer = new FileWriter(path);

				writer.write("1" + "|Title= " + n.getTitle() + "|Content= " + n.getContent() + "\n");
				writer.close();
			} else {
				String[] params;
				params = last.split("|");

				int id = Integer.parseInt(params[0]);
				id++;
				params[0] = Integer.toString(id);

				writer = new FileWriter(path, true);

				writer.append(params[0] + "|Title= " + n.getTitle() + "|Content= " + n.getContent() + "\n");
			}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		}
		writer.close();

	}

	public void show() {

		try (FileInputStream fin = new FileInputStream(path)) {
			int i;
			while ((i = fin.read()) != -1) {

				System.out.print((char) i);
			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		System.out.println();

	}

	@Override
	public void update(Note n) throws IOException {
		int i = 0;
		String[] params = new String[3];
		String[] lines;
		try (Stream<String> str = Files.lines(Paths.get(path))) {
			lines = str.toArray(String[]::new);
		}
		for (String line : lines) {
			params = lines;
			params[i].split("|");
			if (i != n.getId()) {
				i++;

			}

		}
		String line1 = params[i].toString();
		lines = line1.split("|");
		lines[1] = n.getTitle();
		lines[2] = n.getContent();
		String lineeee = lines[0] + "|Title=" + lines[1] + "|Content=" + lines[2];
		params[i] = lineeee;
		writer = new FileWriter(path);
		writer.append("");
		for (int i1 = 0; i1 < params.length; i1++) {
			writer.append(params[i1] + "\n");
		}
		writer.close();

	}

	public void delete() throws DaoException, IOException {

		writer = new FileWriter(path);

		writer.close();

	}
}
