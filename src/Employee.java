import java.util.Objects;

public class Employee {
    private static int idCounter = 1;

    private final int id;
    private final String fullName;
    private String companyDepartment;
    private int salary;

    public Employee(String fullName, String companyDepartment, int salary) {
        id = idCounter++;
        this.fullName = fullName;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public int getSalary() {
        return salary;
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id= " + this.id +
                ", Полное имя= " + this.fullName +
                ", Отдел= " + this.companyDepartment +
                ", Зарплата= " + this.salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) return false;
        Employee employee = (Employee) other;
        return /*this.id == employee.id &&*/ this.fullName.equals(employee.fullName) &&
                this.companyDepartment.equals(employee.companyDepartment) && this.salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(/*this.id, */this.fullName, this.companyDepartment, this.salary);
    }
}