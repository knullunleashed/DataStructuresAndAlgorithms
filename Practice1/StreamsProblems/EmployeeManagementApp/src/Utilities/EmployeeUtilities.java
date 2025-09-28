package Utilities;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
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

    /*
     * 
     * Get total salary spent on all
     * the employees
     */

    public static double getTotalSalarySpentOnEmployees(List<Employee> employees){
        return employees.stream()
                    .map(Employee::salary)
                    .reduce(0.0, Double::sum);
    }

    /*
     * Highest paid employee per
     * department
     * 
     */

     public static Map<String,Employee> getHighestPaidEmployeePerDepartment(List<Employee> employees){
        return employees.stream()
                        .collect(Collectors
                            .groupingBy(Employee::department, Collectors
                                .collectingAndThen(Collectors
                                    .maxBy(Comparator
                                        .comparingDouble(Employee::salary)), Optional::get)));
     }

    /*
     * 
     * Average Salary of Employees Under 30
     * 
     */

     public static double getAverageSalaryOfEmployeesUnder30(List<Employee> employees){
        return employees.stream()
                .filter(e -> e.age() < 30)
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0.0);
     }

    /*
     * 
     * Rank departments based on total salary expense
     * , highest first.
     * 
     */

    public static Map<String, Double> getDepartmentBasedOnTotalSalaryExpense(List<Employee> employees){
        return employees.stream()
                .collect(Collectors
                .groupingBy(Employee::department, Collectors.summingDouble(Employee::salary)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    /*
     * Get name length of each employee 
     * and sort them based on their length
     * in a map
     * 
     */

     public static Map<String, Long> getCharacterLengthOfEachEmployeeNameAndSortThemInAscendingOrder(List<Employee>employees) {
        return employees.stream()
            .collect(Collectors.toMap(Employee::name, e ->(long) e.name().length()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
     }

}
