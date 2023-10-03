package edu.examples.java_classes.main;

import java.io.IOException;

import java.util.Scanner;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.entity.Note;

public class Main {
	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		Note n = new Note();
		
		String request;
		String response;
		
		String add = "ADD";
		String update = "UPDATE";
		String delete = "DELETE";
		String show = "SHOW";

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		while (true) {
			System.out.println("Введите комманду[ADD,UPDATE,SHOW,DELETE]");

			request = sc.nextLine();
			if (request.toUpperCase().equals(add)) {

				System.out.println("Введите Title");
				n.setTitle(sc.nextLine());

				System.out.println("Введите Content");
				n.setContent(sc.nextLine());

				request = "ADD" + "\nId=" + n.getId() + "\nTitle=" + n.getTitle() + "\nсоntent=" + n.getContent()
						+ "\n";
				response = controller.doAction(request);
				System.out.println(response + "\n-------------------------------------------------");

			} else {

				if (request.toUpperCase().equals(show)) {

					request = "SHOW\n\n\n";
					response = controller.doAction(request);
					System.out.println(response + "\n-------------------------------------------------");
				}
			}
			if (request.toUpperCase().equals(update)) {

				System.out.println("Введите Id записи для дальнейшего изменения");
				int abc = sc1.nextInt();
				abc--;
				n.setId(abc);

				System.out.println("Введите Title");
				n.setTitle(sc.nextLine());

				System.out.println("Введите Content");
				n.setContent(sc.nextLine());

				request = "UPDATE" + "\nId=" + n.getId() + "\nTitle=" + n.getTitle() + "\nсоntent=" + n.getContent()
						+ "\n";
				response = controller.doAction(request);
				System.out.println(response + "\n-------------------------------------------------");

			} else {
				if (request.toUpperCase().equals(delete)) {

					request = "DELETE\n\n\n";
					response = controller.doAction(request);
					System.out.println(response + "\n-------------------------------------------------");
				}else {
					
				}
			}

		}

	}
}
