package Utilities;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
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
    
    public static Set<String> getDistinctDepartments(List<Employee>employees) {
        return employees.stream()
            .map(Employee::department)
            .collect(Collectors.toSet());
    }

    /*
    * 
    * find the youngest employee in each department 
    * whose skills include both "Java" and "SQL"
    * 
    */

    public static boolean hasJavaAndSqlSkills(List<String>skills){
        Set<String>normalisedSkills =  skills.stream()
            .map(s -> s.trim().toLowerCase())
            .collect(Collectors.toSet());
        return normalisedSkills.contains("java") && normalisedSkills.contains("sql");
    }

    public static Map<String,Optional<Employee>>  getYoungestEmployeeInEachDepartmentWithJavaAndSqlSkills(List<Employee>employees){
        return employees.stream()
            .filter(e -> hasJavaAndSqlSkills(e.skills()))
            .collect(Collectors.groupingBy(Employee::department, Collectors.minBy(Comparator.comparingInt(Employee::age))));
    }

    /*
    * 
    * Get length of all employees name
    */

    public static Map<String, Integer> getLengthOfEmployeeNames(List<Employee> employees){
        return employees.stream()
            .map(Employee::name)
            .collect(Collectors.toMap(Function.identity(), String::length));
    }

    /*
     * 
     * get employees by department
     * or group employees based on department
     */

    public static Map<String, List<String>> getEmployeesByDepartment(List<Employee>employees){
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())));
    }

    /*
     * Group Employees
     * By age
     */
    public static Map<Integer, List<String>> groupEmployeesByAge(List<Employee> employees){
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::age, Collectors.mapping(Employee::name, Collectors.toList())));
    }

}
