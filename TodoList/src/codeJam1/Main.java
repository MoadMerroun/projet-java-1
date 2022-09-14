package codeJam1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("*************** Menu **********");
			System.out.println("********** add task : 0 **********");
			System.out.println("********** delete task : 1 **********");
			System.out.println("********** update task : 2 **********");
			System.out.println("********** add category : 3 **********");
			System.out.println("********** delete category : 4 **********");
			System.out.println("********** update category : 5 **********");
			System.out.println("********** display to-do list : 6 **********");
			int choice = s.nextInt();
			s.nextLine();
			Task task = new Task();
			Category category = new Category();
			switch (choice) {
			case 0:
				System.out.println("Enter the task");
				String taskName = s.nextLine();
				System.out.println("Enter the category name");
				String categoryNom = s.nextLine();
				task.addTask(categoryNom, taskName);
				break;
			case 1:
				System.out.println("Enter the task id");
				int taskID = s.nextInt();
				task.deleteTask(taskID);
				break;
			case 2:
				System.out.println("Enter the task id");
				int taskId = s.nextInt();
				s.nextLine();
				System.out.println("Enter the new task name");
				String taskNewName = s.nextLine();
				System.out.println("Enter its new category id");
				int newcategoryID = s.nextInt();
				task.updateTask(taskId, taskNewName, newcategoryID);
				break;
			case 3:
				System.out.println("Enter the category");
				String categoryName = s.nextLine();
				category.addCategory(categoryName);
				break;
			case 4:
				System.out.println("Enter the category id");
				int categoryID = s.nextInt();
				category.deleteCategory(categoryID);
				break;
			case 5:
				System.out.println("Enter the category id");
				int categoryId = s.nextInt();
				s.nextLine();
				System.out.println("Enter the new category name");
				String newCategoryName = s.nextLine();
				category.updateCategory(categoryId, newCategoryName);
				break;
			case 6:
				TodoFunctions fcts = new TodoFunctions();
				fcts.Affichage();
				break;
			default:
				System.out.println("Enter valid number");
			}
		}
	}
}