import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombineFunction {
    public static class Employee {
        private String name;
        private Integer age;
        private Float sal;
        private String jobTitle;

        public Employee(String name) {
            this.name = name;
        }

        public Employee(String name, Integer age, Float sal, String jobTitle) {
            this.name = name;
            this.age = age;
            this.sal = sal;
            this.jobTitle = jobTitle;
        }
    }


    public static void main(String[] args) {
        Employee[] empArr = {
                new Employee("admin",23,100000f,"SDE1"),
                new Employee("admin",23,750000f,"FSD"),
        };
        List<Employee> emp = new ArrayList<>(Arrays.asList(empArr));

        Float totalDev = emp
                .stream()
                .filter((employee) -> employee.jobTitle.equals("SDE1"))
                .map((employee) -> employee.sal)
                .reduce(0f,(acc,x) -> acc + x);

        Long sdeDevelopers = emp
                .stream()
                .filter((employee) -> employee.jobTitle.equals("SDE1"))
                .collect(Collectors.counting());

        Float avgSalary = totalDev / sdeDevelopers;
        System.out.println(avgSalary);
    }
}
