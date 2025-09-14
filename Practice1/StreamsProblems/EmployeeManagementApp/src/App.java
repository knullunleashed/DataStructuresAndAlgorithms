import java.util.Arrays;
import java.util.List;
import Models.Employee;
import Utilities.EmployeeUtilities;

public class App {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee(1, "Amit Sharma", 75000, "Engineering", 26, List.of("Java", "SQL", "Spring")),
            new Employee(2, "Neha Verma", 50000, "Engineering", 32, List.of("Java", "Python", "AWS")),
            new Employee(3, "Rohan Gupta", 120000, "Engineering", 24, List.of("SQL", "Java", "Docker")),
            new Employee(4,"Sara Khan", 95000, "HR",29, List.of("Communication", "Recruitment", "SQL")),
            new Employee(5, "Ishaan Mehta", 45000, "HR", 35, List.of("SQL", "Java", "Excel")),
            new Employee(6, "Priya Desai", 80000, "HR", 23, List.of("Java ", " SQL")),
            new Employee(7, "Rahul Nair", 25000, "Finance", 27, List.of("Excel", "SQL", "Java")),
            new Employee(8, "Sneha Iyer",60000 , "Finance", 30, List.of("SQL", "Power BI")),
            new Employee(9, "Dev Patel", 85000,"Finance",28, List.of("Java", "SQL", "Python")),
            new Employee(10, "Aarav Joshi", 10000,"Engineering",22, List.of("java", "sql"))
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

         /*
          * 
          * find the youngest employee in each department 
          * whose skills include both "Java" and "SQL"
          * 
          */

        System.out.println("\n");

        EmployeeUtilities.getYoungestEmployeeInEachDepartmentWithJavaAndSqlSkills(employees).forEach((dept, empOpt) -> {
            System.out.println(dept + " -> " + empOpt.map(Employee::name).orElse(null));
        });

        /*
         * 
         * Get length of all employees name
         */
        System.out.println("\n");
         EmployeeUtilities.getLengthOfEmployeeNames(employees).forEach((name, length) -> {
            System.out.println("Employee name: "+name+" character length of their name is: "+length);
         });

         /*
        * 
        * get employees by department
        * or group employees based on department
        */

        System.out.println("\n");
        EmployeeUtilities.getEmployeesByDepartment(employees).forEach((department, names) -> {
            System.out.println(department+" --> "+names);
        });

    }
}
