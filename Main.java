import java.util.ArrayList;

abstract class Employee {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name= " + name + ", id= " + id + ", salary= " + calculateSalary() + " ]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getID() == id) {
                employeeToRemove = employee;
                employeeList.remove(employeeToRemove);
                break;
            }
        }
    }

    public void displayEmployee() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String args[]) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Viraj", 1, 70000.0);
        FullTimeEmployee emp2 = new FullTimeEmployee("Sayali", 2, 92000.0);
        FullTimeEmployee emp3 = new FullTimeEmployee("Rohit", 3, 47000.0);
        FullTimeEmployee emp4 = new FullTimeEmployee("Shrushti", 4, 35000.0);
        FullTimeEmployee emp5 = new FullTimeEmployee("Janki", 5, 40000.0);

        PartTimeEmployee emp6 = new PartTimeEmployee("Shushant", 11, 45, 400);
        PartTimeEmployee emp7 = new PartTimeEmployee("Swara", 12, 67, 492);
        PartTimeEmployee emp8 = new PartTimeEmployee("Vaidehi", 13, 95, 567);
        PartTimeEmployee emp9 = new PartTimeEmployee("Vallabh", 14, 145, 360);
        PartTimeEmployee emp10 = new PartTimeEmployee("Vyom", 15, 436, 700);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);
        payrollSystem.addEmployee(emp5);
        payrollSystem.addEmployee(emp6);
        payrollSystem.addEmployee(emp7);
        payrollSystem.addEmployee(emp8);
        payrollSystem.addEmployee(emp9);
        payrollSystem.addEmployee(emp10);

        System.out.println("Initial Details of Empployees ");
        payrollSystem.displayEmployee();

        payrollSystem.removeEmployee(11);
        payrollSystem.removeEmployee(4);
        System.out.println("Final Details of Empployees ");
        payrollSystem.displayEmployee();

    }
}