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
        displayCompletion();
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
    public Employee getEmployeeById(String id)throws IndexOutOfBoundsException{
        int index = indexOfEmployeeById(id);
        Employee employee = controllerList.get(index);
        return employee;
    }
    public Employee getEmployeeByName (String name)throws IndexOutOfBoundsException{
        int index = indexOfEmployeeByName(name);
        Employee employee= employee=controllerList.get(index);
        return employee;
    }
//    public int indexOfEmployee(Employee employee){
//        return controllerList.indexOf(employee);
//    }
    public int indexOfEmployeeById(String id){
        for (int i = 0; i < controllerList.size(); i++) {
            String elementID =controllerList.get(i).getId();
            if(elementID.equals(id)){
                return i;
            }
        }
        return -1;
    }
    public int indexOfEmployeeByName(String name){
        for (int i = 0; i < controllerList.size(); i++) {
            String elementName =controllerList.get(i).getName();
            if(elementName.equals(name)){
                return i;
            }
        }
        return -1;
    }
    public ArrayList<Employee> getEmployeeByAge(int from,int to) throws NullPointerException{
        ArrayList<Employee> tempList = null;
        for (Employee e:controllerList
             ) {
            if(e.getAge()>=from && e.getAge()<=to){
                tempList.add(e);
            }
        }
        return tempList;
    }
    public ArrayList<Employee> getEmployeeByAge(int age) throws NullPointerException{
        ArrayList<Employee> tempList = null;
        for (Employee e:controllerList
             ) {
            if((e.getAge())==age){
                tempList.add(e);
            }
        }
        return tempList;
    }

    public void removeEmployeeById(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập id của nhân viên bạn muốn xóa");
        String id = input.nextLine();
        int index = indexOfEmployeeById(id);
        if(index!=-1){
            Employee employee= controllerList.get(index);
            removeEmployee(employee);
            displayCompletion();
            return;
        }
        System.out.println("Id không tồn tại, xóa thất bại!");
    }
    public void removeEmployee(Employee employee){
        controllerList = IOtool.readFile();
        controllerList.remove(employee);
        IOtool.writeFile(controllerList);
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
        else{
            System.out.println("Id không tồn tại!");
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

    public void displayEmployeeByAge(){
        ArrayList<Employee> list = null;
        System.out.println("1. Tuổi chính xác");
        System.out.println("2. Độ tuổi từ a đến b");
        System.out.print("Bạn muốn tìm tuổi theo cách : ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.print("\nTuổi chính xác của nhân viên bạn muốn tìm: ");
                Scanner inputAge = new Scanner(System.in);
                int age = inputAge.nextInt();
                try{
                    list = getEmployeeByAge(age);
                }catch (NullPointerException e){
                    System.err.println("Không có nhân viên ở độ tuổi này!");
                    return;
                }
                displaySpecifiedList(list);
                break;
            case 2:
                System.out.print("\nĐộ tuổi từ: ");
                Scanner inputFrom = new Scanner(System.in);
                int from = inputFrom.nextInt();

                System.out.print("\nĐến: ");
                Scanner inputTo = new Scanner(System.in);
                int to = inputTo.nextInt();

                try{
                    list = getEmployeeByAge(from,to);
                }
                catch (NullPointerException e){
                    System.err.println("Không có nhân viên ở độ tuổi này!");
                }
                displaySpecifiedList(list);
                break;
            default:
                System.err.println("Nhập sai dữ liệu! Vui lòng kiểm tra lại!");
                displayEmployeeByAge();
        }
    }
    public void displayMenu(){
        System.out.println("Menu");
        System.out.println("1. Hiển thị tất cả nhân viên.");
        System.out.println("2. Thêm nhân viên mới.");
        System.out.println("3. Xóa nhân viên theo id.");
        System.out.println("4. Chỉnh sửa thông tin nhân viên theo id.");
        System.out.println("5. Hiển thị nhân viên có lương thấp hơn trung bình.");
        System.out.println("6. Hiển thị tổng số lương phải trả cho nhân viên parttime.");
        System.out.println("7. Tìm kiếm thông tin nhân viên");
        System.out.println("20. Thoát chương trình.\n");
        System.out.print("Lựa chọn của bạn: ");
    }
    public void displayCompletion(){
        System.out.println("Complete!");
    }
    public void displaySpecifiedList(ArrayList<Employee> list){
        for (Employee e: controllerList
             ) {
            System.out.println(e);
        }
    }
    public void displayAllList(){
        for (Employee e:controllerList
        ) {
            System.out.println(e);
        }
    }
    public void displaySpecifiedEmployee()
    {
        System.out.println("Bạn muốn tìm kiếm nhân viên theo đặc điểm nào?");
        System.out.println("1. Theo id.");
        System.out.println("2. Theo tên.");
        System.out.println("3. Theo độ tuổi.");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                displayEmployeeById();
                displayCompletion();
                break;
            case 2:
                displayEmployeeByName();
                displayCompletion();
                break;
            case 3:
                displayEmployeeByAge();
                displayCompletion();
                break;
            default:
                System.err.println("Nhập sai dữ liệu. Mời kiểm tra lại!");
                displaySpecifiedEmployee();
        }
    }
    public void displayEmployeeById(){
        Employee employee = null;
        System.out.print("Nhập ID của nhân viên bạn muốn tìm: ");
        Scanner inputID = new Scanner(System.in);
        String id = inputID.nextLine();
        try{
            employee = getEmployeeById(id);
        }
        catch (IndexOutOfBoundsException e){
            System.err.println("No employee with id: "+id);
            return;
        }
        System.out.println(employee);
    }
    public void displayEmployeeByName(){
        Employee employee = null;
        System.out.print("Nhập tên của nhân viên: ");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        try{
            employee = getEmployeeByName(name);
        }catch (IndexOutOfBoundsException e){
            System.err.println("No employee with name: "+name);
            return;
        }
        System.out.println(employee);
    }

    public void continueAction(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Something interrupted the thread!");
        }
        System.out.println("Nhập phím bất kì để quay lại menu");
        Scanner input = new Scanner(System.in);
        String i=input.nextLine();
    }
}
