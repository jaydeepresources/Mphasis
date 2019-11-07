package com.crud;

import java.util.List;
import java.util.Scanner;

import dao.PostDAOImpl;

public class App {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		PostDAOImpl impl = new PostDAOImpl();
		
		int doChoice = 0;

		do {
			System.out.println("1.Insert\t2.Update\t3.Delete\t4.View");
			int choice = scan.nextInt();
			scan.nextLine();
			Post p = new Post();
			switch (choice) {
			case 1:
				System.out.println("Enter title and body");
				p = new Post(0, scan.nextLine(), scan.nextLine());
				Post res = impl.insert(p);
				System.out.println(res);
				break;

			case 2:
				System.out.println("Enter id, title and body");
				p = new Post();
				p.setId(scan.nextInt());
				scan.nextLine();
				p.setTitle(scan.nextLine());
				p.setBody(scan.nextLine());
				Post res1 = impl.update(p);
				System.out.println(res1);
				break;

			case 3:
				System.out.println("Enter id");
				p = new Post();
				p.setId(scan.nextInt());
				scan.nextLine();
				Status s = impl.delete(p);
				System.out.println(s);
				break;

			case 4:
				List<Post> list = impl.view();
				for (Post post : list) {
					System.out.println(post);
				}
				break;

			default:
				break;
			}

			System.out.println("1.Re Run\t\t2.Exit");
			doChoice = scan.nextInt();
			scan.nextLine();
		} while (doChoice == 1);

		System.out.println("********Good Bye For Now********");

	}

}
