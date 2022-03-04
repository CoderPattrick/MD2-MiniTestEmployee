import Employee.Employee;

import java.io.*;
import java.util.ArrayList;

public class IOManagerEmp implements IOManager<Employee> {
    private static IOManagerEmp IOtool = new IOManagerEmp();
    public static ArrayList<Employee> savedList = IOtool.readFile();
    public ArrayList<Employee> getSavedList(){
        return savedList;
    }
    private static final String SAVE_PATH = "storage\\employeeList.datdz";
    public void writeFile(ArrayList<Employee> list){
        FileOutputStream output = null;
        ObjectOutputStream writer = null;
        try {
            output = new FileOutputStream(SAVE_PATH);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found! Created new folder to save!");
            writeFile(list);
            return;
        }
        try{
            writer = new ObjectOutputStream(output);
            writer.writeObject(list);
            writer.close();
        } catch (IOException e) {
            System.err.println("Something wrong! Cant write file!");
        }
    }
    public ArrayList<Employee> readFile(){
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(SAVE_PATH));
            ArrayList<Employee> list = (ArrayList<Employee>) reader.readObject();
            reader.close();
            return list;
        } catch (IOException e) {
            System.err.println("Something wrong, cant read file!");
        } catch (ClassNotFoundException e) {
            System.err.println("Something wrong, data of this file is invalid!");
        }
        return new ArrayList<>();
    }
}
