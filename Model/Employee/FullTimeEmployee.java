package Employee;

public class FullTimeEmployee extends Employee{
    double bonus;
    double minus;
    double baseSalary;

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", Email='" + Email + '\'' +
                ", bonus=" + bonus +
                ", minus=" + minus +
                ", baseSalary=" + baseSalary +
                '}';
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getMinus() {
        return minus;
    }

    public void setMinus(double minus) {
        this.minus = minus;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public FullTimeEmployee(String id, String name, int age, String phone, String email, double bonus, double minus, double baseSalary) {
        super(id, name, age, phone, email);
        this.bonus = bonus;
        this.minus = minus;
        this.baseSalary = baseSalary;
    }

    public FullTimeEmployee(double bonus, double minus, double baseSalary) {
        this.bonus = bonus;
        this.minus = minus;
        this.baseSalary = baseSalary;
    }

    public FullTimeEmployee() {
    }
    @Override
    public  double getSalary(){
        double result = baseSalary+bonus-minus;
        return result;
    }
}
