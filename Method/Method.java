import Employee.*;
import java.util.Arrays;
public class Method {
    public static Employee employeeList[];
    public static Employee[] addEmployee(Employee[] employeeList, Employee newEmployee){
        int oldListLength= employeeList.length;
        Employee[] newEmployeeList = new Employee[oldListLength+1];
        for (int i = 0; i < oldListLength; i++) {
            newEmployeeList[i]=employeeList[i];
        }
        newEmployeeList[oldListLength]=newEmployee;
        return newEmployeeList;
    }
    public static double getAverageSalary(){
        int numbOfEmployee=0;
        double averageSalary=0;
        double totalSalary=0;
        for (int i = 0; i < employeeList.length; i++) {
            numbOfEmployee++;
            totalSalary+=employeeList[i].getSalary();
        }
        averageSalary=totalSalary/numbOfEmployee;
        return averageSalary;
    }
    public static void showEmployeeWithSalaryLowerThanAverage(){
        double averageSalary = getAverageSalary();
        Employee[] tempList = new Employee[0];
        for (int i = 0; i < employeeList.length; i++) {
            double salary = employeeList[i].getSalary();
            if(salary<averageSalary){
                tempList=addEmployee(tempList,employeeList[i]);
            }
        }
        for (Employee e:tempList
             ) {
            System.out.println(e);
        }
    }
    public static double getTotalSalaryOfPartTimeEmployee(){
        double result =0;
        for (Employee e:employeeList
             ) {
            if(!isFullTimeEmployee(e)){
                result+= e.getSalary();
            }
        }
        return result;
    }
    public static boolean isFullTimeEmployee(Employee employee){
        if(employee instanceof FullTimeEmployee){
            return true;
        }
        return false;
    }
}
