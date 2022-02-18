package Employee;

public class PartTimeEmployee extends Employee{

    public static final int SALARYPERHOUR = 100000;

    public PartTimeEmployee() {
    }
    double workHour;

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", Email='" + Email + '\'' +
                ", workHour=" + workHour +
                '}';
    }

    public double getWorkHour() {
        return workHour;
    }

    public void setWorkHour(double workHour) {
        this.workHour = workHour;
    }

    public PartTimeEmployee(String id, String name, int age, String phone, String email, double workHour) {
        super(id, name, age, phone, email);
        this.workHour = workHour;
    }

    public PartTimeEmployee(double workHour) {
        this.workHour = workHour;
    }
    @Override
    public  double getSalary(){
        double result = workHour* SALARYPERHOUR;
        return result;
    }
}
