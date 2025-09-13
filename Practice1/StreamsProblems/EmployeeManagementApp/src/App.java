import java.util.Arrays;
import java.util.List;
import Models.Employee;
import Utilities.EmployeeUtilities;

public class App {
    public static void main(String[] args) {
        
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 75000, "IT", 28, Arrays.asList("Java", "Spring")),
            new Employee(2, "Bob", 50000, "HR", 35, Arrays.asList("Communication", "Recruiting")),
            new Employee(3, "Charlie", 120000, "Finance", 40, Arrays.asList("Excel", "Accounting", "Analysis")),
            new Employee(4, "Diana", 95000, "IT", 30, Arrays.asList("Java", "React")),
            new Employee(5, "Ethan", 45000, "Sales", 25, Arrays.asList("Negotiation", "CRM")),
            new Employee(6, "Fiona", 80000, "Finance", 38, Arrays.asList("Analysis", "Reporting"))
        );

        /*
         * Sort employees by salary and age
         * 
         */

        EmployeeUtilities.SortEmployeesByAgeAndSalary(employees).forEach((employee) -> {
            System.out.println(employee.id()+" "+employee.name()+" "+employee.salary()
            +" "+employee.department()+" "+employee.age()+" "+employee.skills());
        });

        /*
         * Get distinct departments
         * 
         */

         System.out.println("\n");
         EmployeeUtilities.getDistinctDepartments(employees).forEach((e) -> {
            System.out.println(e);
         });
    }
}
