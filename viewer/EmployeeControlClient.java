import Employee.Employee;

import java.util.ArrayList;

public class EmployeeControlClient {
    private static EmployeeManager controller = new EmployeeManager();
    private static IOManager IOtool = new IOManagerEmp();
//    private static ArrayList<Employee> clientList = IOManagerEmp.savedList;
//        System.out.println("Menu");
//        System.out.println("1. Hiển thị tất cả nhân viên.");
//        System.out.println("2. Thêm nhân viên mới.");
//        System.out.println("3. Xóa nhân viên theo id.");
//        System.out.println("5. Chỉnh sửa thông tin nhân viên theo id.");
//        System.out.println("6. Hiển thị nhân viên có lương thấp hơn trung bình.");
//        System.out.println("7. Hiển thị tổng số lương phải trả cho nhân viên parttime.");
//        System.out.println("8. Thoát chương trình.");
    public static void main(String[] args) {
        int choice=0;
        while (choice!=8){
            controller.displayMenu();
            switch (choice){
                case 1:
                    controller.displayAllList();
                    controller.continueAction();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                default:
                    System.err.println("Dữ liệu nhập sai, vui lòng nhập lại!");
            }
        }
    }
}
