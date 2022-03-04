import Employee.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private static IOManager IOtool = new IOManagerEmp();
    private static ArrayList<Employee> controllerList = IOManagerEmp.savedList;
    public void addEmployee(){
        int choice;
        System.out.println("Nhân viên mới là kiểu 1 (Full-time) hay 2 (Part-time)? Nhập 1 hoặc 2:");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        while(choice!=1&&choice!=2){
            System.out.println("Dữ liệu nhập không hợp lệ! Mời nhập lại!");
            addEmployee();
            return;
        }
        Employee newEmployee= getEmployeeByInput(choice);
        controllerList.add(newEmployee);
        IOtool.writeFile(controllerList);
    }
    public Employee getEmployeeByInput(int choice){
        Employee newEmployee=null;
        System.out.println("id: ");
        Scanner inputID = new Scanner(System.in);
        String id = inputID.nextLine();
        System.out.println("name: ");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("age: ");
        Scanner inputAge = new Scanner(System.in);
        int age = inputAge.nextInt();
        System.out.println("phone: ");
        Scanner inputPhone = new Scanner(System.in);
        String phone = inputPhone.nextLine();
        System.out.println("email: ");
        Scanner inputMail = new Scanner(System.in);
        String mail = inputMail.nextLine();

        if(choice==1){
            System.out.println("bonus: ");
            Scanner inputBonus = new Scanner(System.in);
            double bonus = inputBonus.nextDouble();
            System.out.println("minus: ");
            Scanner inputMinus = new Scanner(System.in);
            double minus = inputMinus.nextDouble();
            System.out.println("base-salary: ");
            Scanner inputBase = new Scanner(System.in);
            double base = inputBase.nextDouble();
            newEmployee = new FullTimeEmployee(id,name,age,phone,mail,bonus,minus,base);
        }
        else {
            System.out.println("workHour: ");
            Scanner inputWorkHour = new Scanner(System.in);
            double workHour = inputWorkHour.nextDouble();
            newEmployee = new PartTimeEmployee(id,name,age,phone,mail,workHour);
        }
        return newEmployee;
    }
    public int indexOfEmployee(Employee employee){
        return controllerList.indexOf(employee);
    }
    public int indexOfEmployeeById(String id){
        for (int i = 0; i < controllerList.size(); i++) {
            String elementID =controllerList.get(i).getId();
            if(elementID.equals(id)){
                return i;
            }
        }
        return -1;
    }
    public void removeEmployeeById(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id của nhân viên bạn muốn xóa");
        String id = input.nextLine();
        int index = indexOfEmployeeById(id);
        if(index!=-1){
            Employee employee= controllerList.get(index);
            removeEmployee(employee);
            System.out.println("Xóa thành công!");
            return;
        }
        System.out.println("Id không tồn tại, xóa thất bại!");
    }
    public void setInfoById(){
        System.out.println("Nhập id của nhân viên bạn muốn sửa thông tin: ");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        int index = indexOfEmployeeById(id);
        if(index!=-1){
            controllerList = IOtool.readFile();
            Employee target = controllerList.get(index);
            if(target instanceof FullTimeEmployee){
                setInfoFullTimeEmp((FullTimeEmployee)target);
            }
            else {
                setInfoPartTimeEmp((PartTimeEmployee)target);
            }
            IOtool.writeFile(controllerList);
        }
        System.out.println("Id không tồn tại!");
    }
    public void setInfoFullTimeEmp(FullTimeEmployee employee){
        setCommonInfo(employee);

        System.out.println("bonus: ");
        Scanner inputBonus = new Scanner(System.in);
        double bonus = inputBonus.nextDouble();
        employee.setBonus(bonus);

        System.out.println("minus: ");
        Scanner inputMinus = new Scanner(System.in);
        double minus = inputMinus.nextDouble();
        employee.setMinus(minus);

        System.out.println("base-salary: ");
        Scanner inputBase = new Scanner(System.in);
        double base = inputBase.nextDouble();
        employee.setBaseSalary(base);

        displayCompletion();
    }
    public void setInfoPartTimeEmp(PartTimeEmployee employee){
        setCommonInfo(employee);
        System.out.println("workHour: ");
        Scanner inputWorkHour = new Scanner(System.in);
        double workHour = inputWorkHour.nextDouble();
        employee.setWorkHour(workHour);

        displayCompletion();
    }
    public void displayCompletion(){
        System.out.println("Complete!");
    }
    public void displayAllList(){
        for (Employee e:controllerList
             ) {
            System.out.println(e);
        }
    }
    public void setCommonInfo(Employee employee){

        System.out.println("id: ");
        Scanner inputID = new Scanner(System.in);
        String id = inputID.nextLine();
        employee.setId(id);

        System.out.println("name: ");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        employee.setName(name);

        System.out.println("age: ");
        Scanner inputAge = new Scanner(System.in);
        int age = inputAge.nextInt();
        employee.setAge(age);

        System.out.println("phone: ");
        Scanner inputPhone = new Scanner(System.in);
        String phone = inputPhone.nextLine();
        employee.setPhone(phone);

        System.out.println("email: ");
        Scanner inputMail = new Scanner(System.in);
        String mail = inputMail.nextLine();
        employee.setEmail(mail);
    }
    public void removeEmployee(Employee employee){
        controllerList = IOtool.readFile();
        controllerList.remove(employee);
        IOtool.writeFile(controllerList);
    }
    public double getAverageSalary(){
        int numbOfEmployee=controllerList.size();
        double averageSalary;
        double totalSalary=0;
        for (Employee e:controllerList
             ) {
            totalSalary += e.getSalary();
        }
        averageSalary=totalSalary/numbOfEmployee;
        return averageSalary;
    }
    public ArrayList<Employee> getEmployeeWithSalaryLowerThanAverage(){
        double averageSalary = getAverageSalary();
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee e:controllerList
             ) {
            double salary = e.getSalary();
            if(salary<averageSalary){
                list.add(e);
            }
        }
        return list;
    }
    public double getTotalSalaryOfPartTimeEmployee(){
        double result =0;
        for (Employee e: controllerList
             ) {
            if(!isFullTimeEmployee(e)){
                result+= e.getSalary();
            }
        }
        return result;
    }
    public boolean isFullTimeEmployee(Employee employee){
        if(employee instanceof FullTimeEmployee){
            return true;
        }
        return false;
    }
    public void displayMenu(){
        System.out.println("Menu");
        System.out.println("1. Hiển thị tất cả nhân viên.");
        System.out.println("2. Thêm nhân viên mới.");
        System.out.println("3. Xóa nhân viên theo id.");
        System.out.println("5. Chỉnh sửa thông tin nhân viên theo id.");
        System.out.println("6. Hiển thị nhân viên có lương thấp hơn trung bình.");
        System.out.println("7. Hiển thị tổng số lương phải trả cho nhân viên parttime.");
        System.out.println("8. Thoát chương trình.");
    }
    public void continueAction(){
        System.out.println("Nhập phím bất kì để quay lại menu");
        Scanner input = new Scanner(System.in);
        int i=input.nextInt();
    }
}
