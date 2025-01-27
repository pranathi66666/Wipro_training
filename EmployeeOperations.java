import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    double salary;
    String department;

    Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
}

public class EmployeeOperations {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 6000, "HR"),
            new Employee("Bob", 4000, "Engineering"),
            new Employee("Charlie", 7000, "HR"),
            new Employee("David", 8000, "Engineering"),
            new Employee("Eve", 9000, "Finance"),
            new Employee("Frank", 2000, "Finance")
        );

        findEmployeeWithHighestSalary(employees);
        filterEmployeesWithSalaryGreaterThan5000(employees);
        getEmployeeNamesAndSalaries(employees);
        countEmployees(employees);
        groupEmployeesByDepartment(employees);
        calculateAverageSalary(employees);
        sortEmployeesBySalary(employees);
        findEmployeeWithSecondHighestSalary(employees);
        partitionEmployeesBySalaryThreshold(employees, 5000);
        findEmployeeWithLongestName(employees);
        groupEmployeesByDepartmentAndCalculateAverageSalary(employees);
        findTop3HighestPaidEmployees(employees);
        calculateTotalSalaryUsingReduce(employees);
    }

    public static void findEmployeeWithHighestSalary(List<Employee> employees) {
        employees.stream()
                 .max(Comparator.comparingDouble(emp -> emp.salary))
                 .ifPresent(emp -> System.out.println(emp));
    }

    public static void filterEmployeesWithSalaryGreaterThan5000(List<Employee> employees) {
        employees.stream()
                 .filter(emp -> emp.salary > 5000)
                 .forEach(System.out::println);
    }

    public static void getEmployeeNamesAndSalaries(List<Employee> employees) {
        employees.stream()
                 .map(emp -> emp.name + " - " + emp.salary)
                 .forEach(System.out::println);
    }

    public static void countEmployees(List<Employee> employees) {
        System.out.println("Total Employees: " + employees.size());
    }

    public static void groupEmployeesByDepartment(List<Employee> employees) {
        employees.stream()
                 .collect(Collectors.groupingBy(emp -> emp.department))
                 .forEach((department, empList) -> System.out.println(department + ": " + empList));
    }

    public static void calculateAverageSalary(List<Employee> employees) {
        double avgSalary = employees.stream()
                                    .mapToDouble(emp -> emp.salary)
                                    .average()
                                    .orElse(0);
        System.out.println("Average Salary: " + avgSalary);
    }

    public static void sortEmployeesBySalary(List<Employee> employees) {
        employees.stream()
                 .sorted(Comparator.comparingDouble(emp -> emp.salary))
                 .forEach(System.out::println);
    }

    public static void findEmployeeWithSecondHighestSalary(List<Employee> employees) {
        employees.stream()
                 .sorted(Comparator.comparingDouble(emp -> emp.salary).reversed())
                 .skip(1)
                 .findFirst()
                 .ifPresent(System.out::println);
    }

    public static void partitionEmployeesBySalaryThreshold(List<Employee> employees, double threshold) {
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                                                            .collect(Collectors.partitioningBy(emp -> emp.salary > threshold));
        System.out.println("Above Threshold: " + partitioned.get(true));
        System.out.println("Below Threshold: " + partitioned.get(false));
    }

    public static void findEmployeeWithLongestName(List<Employee> employees) {
        employees.stream()
                 .max(Comparator.comparingInt(emp -> emp.name.length()))
                 .ifPresent(System.out::println);
    }

    public static void groupEmployeesByDepartmentAndCalculateAverageSalary(List<Employee> employees) {
        employees.stream()
                 .collect(Collectors.groupingBy(emp -> emp.department, 
                          Collectors.averagingDouble(emp -> emp.salary)))
                 .forEach((department, avgSalary) -> System.out.println(department + ": " + avgSalary));
    }

    public static void findTop3HighestPaidEmployees(List<Employee> employees) {
        employees.stream()
                 .sorted(Comparator.comparingDouble(emp -> emp.salary).reversed())
                 .limit(3)
                 .forEach(System.out::println);
    }

    public static void calculateTotalSalaryUsingReduce(List<Employee> employees) {
        double totalSalary = employees.stream()
                                      .map(emp -> emp.salary)
                                      .reduce(0.0, Double::sum);
        System.out.println("Total Salary: " + totalSalary);
    }
}
