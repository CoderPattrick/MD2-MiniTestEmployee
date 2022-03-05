package employee;

public class PartTimeEmployee extends Employee{

    public static final int SALARY_PER_HOUR = 100;

    public PartTimeEmployee() {
    }
    double workHour;

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", phone='" + getPhone() + '\'' +
                ", Email='" + getEmail() + '\'' +
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
        double result = workHour* SALARY_PER_HOUR;
        return result;
    }
}
