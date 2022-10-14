package ui;

import controller.StudentManagermentController;
import utils.*;

public class Main {

    public static void main(String[] args) {
        StudentManagermentController studentManagermentController = new StudentManagermentController();
        int choice;
        while (true) {
            System.out.println("\nWELCOME TO STUDENT MANAGEMENT");
            String menu = "1. Create\n"
                    + "2. Find and Sort\n"
                    + "3. Update/Delete\n"
                    + "4. Report\n"
                    + "5. Exit";
            System.out.println(menu);
            System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
            choice = ValidationAndNormalizingTextUtils.getInt("Your choice: ", "Please input an integer number!", "Please input an integer number in range [1,5]", 1, 5);
            switch (choice) {
                case 1:
                    studentManagermentController.addStudent();
                    break;
                case 2:
                    studentManagermentController.findAndSortStudent();
                    break;
                case 3:
                    studentManagermentController.updateOrDeleteStudent();
                    break;
                case 4:
                    studentManagermentController.report();
                    break;
                case 5:
                    System.out.println("Bye Bye!");
                    System.exit(0);
                case 0:
                    return;
                default:
                    throw new AssertionError();
            }
        }

    }

}
