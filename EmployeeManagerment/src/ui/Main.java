package ui;

import controller.EmployeeManagermentController;
import utils.*;

public class Main {

    public static void main(String[] args) throws Exception {
        EmployeeManagermentController employeeManagermentController = new EmployeeManagermentController();
        int choice;
        while (true) {
            System.out.println("\nWELCOME TO EMPLOYEE MANAGEMENT");
            String menu = "1. Add employees \n"
                    + "2. Update employees\n"
                    + "3. Remove employees\n"
                    + "4. Search employees\n"
                    + "5. Sort employees by salary\n"
                    + "6. Exit";
            System.out.println(menu);
            System.out.println("(Please choose 1 to Add, 2 to Update, 3 to Remove, 4 to Search ,5 to Sort and 6 to exit the program).");
            choice = ValidationAndNormalizingTextUtils.getInt("Your choice: ", "Please input an integer number!", "Please input an integer number in range [1,5]", 1, 5);
            switch (choice) {
                case 1:
                    employeeManagermentController.addEmployee();
                    break;
                case 2:
                    employeeManagermentController.updateEmployee();
                    break;
                case 3:
                    break;
                case 4:
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
