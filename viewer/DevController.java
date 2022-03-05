import employee.Employee;

import java.util.ArrayList;

public class DevController {
    private static EmployeeManager controller = new EmployeeManager();
    private static ArrayList<Employee> list = IOManagerEmp.savedList;
    public static void main(String[] args) {
        Employee temp = list.get(4);
        controller.removeEmployee(temp);
        controller.displayAllList();
    }
}
