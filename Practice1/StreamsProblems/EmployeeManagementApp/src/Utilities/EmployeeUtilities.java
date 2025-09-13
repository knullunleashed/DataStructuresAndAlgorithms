package Utilities;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import Models.Employee;

public class EmployeeUtilities {
    
    /*
    * Sort employees by salary and age
    * 
    */

    public static List<Employee> SortEmployeesByAgeAndSalary(List<Employee>employees) {
        return employees.stream()
            .sorted(Comparator.comparing(Employee::salary).thenComparing(Employee::age))
            .collect(Collectors.toList());
    } 

    /*
    * Get distinct departments
    * 
    */
    
    public static Set<String> getDistinctDepartments(List<Employee>employees) {
        /*
         * Either this or we can also use distinct()
         * after map
         * 
         * employees.stream()
         *  .map(Employee::department)
         *  .distinct()
         *  .collect(Collectors.toList());
         * 
         */
        return employees.stream()
            .map(Employee::department)
            .collect(Collectors.toSet());
    }
}
