import java.util.*;

class Employee {
    String id, name, department;
    double basicSalary;

    public Employee(String id, String name, String department, double basicSalary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }
}

class PermanentEmployee extends Employee {
    double bonus;

    public PermanentEmployee(String id, String name, String department, double basicSalary, double bonus) {
        super(id, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }
}

class ContractualEmployee extends Employee {
    public ContractualEmployee(String id, String name, String department, double basicSalary) {
        super(id, name, department, basicSalary);
    }
}

class PayrollSystem {
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void generatePayroll() {
        for (Employee employee : employees) {
            System.out.println("Employee ID: " + employee.id + ", Salary: " + employee.calculateSalary());
        }
    }
}
