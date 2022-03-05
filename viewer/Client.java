import employee.Employee;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static EmployeeManager controller = new EmployeeManager();
    private static IOManager IOtool = new IOManagerEmp();
    private static ArrayList<Employee> clientList = IOManagerEmp.savedList;

    public static void main(String[] args) {
        int choice=0;
        while (choice!=20){
            controller.displayMenu();
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice){
                case 1:
                    controller.displayAllList();
                    controller.continueAction();
                    break;
                case 2:
                    controller.addEmployee();
                    controller.continueAction();
                    break;
                case 3:
                    controller.removeEmployeeById();
                    controller.continueAction();
                    break;
                case 4:
                    controller.setInfoById();
                    controller.continueAction();
                    break;
                case 5:
                    ArrayList<Employee> tempList = controller.getEmployeeWithSalaryLowerThanAverage();
                    if(clientList.size()<2){
                        System.err.println("Cant do this action due to lack of employee!");
                    }
                    else {
                        System.out.println("Employee with salary lower than average: ");

                        for (Employee e : tempList
                        ) {
                            System.out.println(e);
                        }
                    }
                    controller.continueAction();
                    break;
                case 6:
                    double totalPartTimeSalary = controller.getTotalSalaryOfPartTimeEmployee();
                    System.out.println("Total salary of Part-Time Employees: "+totalPartTimeSalary);
                    controller.continueAction();
                    break;
                case 7:
                    controller.displaySpecifiedEmployee();
                    controller.continueAction();
                    break;
                case 20:
                    break;
                default:
                    System.err.println("Dữ liệu nhập sai, vui lòng nhập lại!");
            }
        }
    }
}
