package com.data.algo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String name;
    int salary;
    String dept;

    Employee(String name, int salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}

public class StreamExamples {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> even = numbers.stream().filter( s -> s % 2 == 0).toList();
        System.out.println(even);

        List<Integer> mapEx = numbers.stream().map( n -> n * n).toList();
        System.out.println(mapEx);

        List<Integer> sor = numbers.stream().sorted().toList();
        System.out.println(sor);

        List<Integer> dis = numbers.stream().distinct().toList();

        List<Integer> limit = numbers.stream().limit(5).toList();
        System.out.println(limit);

        List<Integer> skip = numbers.stream().skip(3).toList();
        System.out.println(skip);

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<List<String>> nested = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        List<String> flat = nested.stream().flatMap(List::stream).toList();
        System.out.println(flat);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "IT"),
                new Employee("Bob", 60000, "Finance"),
                new Employee("Charlie", 70000, "IT"),
                new Employee("David", 40000, "HR")
        );


        // Filter IT employees with salary > 55000
        List<Employee> sc = employees.stream().filter(e -> (e.salary > 50000) && (e.dept.equals("IT"))).toList();
        System.out.println(sc);

        // Collect employees by department into a map
        Map<String , List<Employee>> empMap = employees.stream().collect(Collectors.groupingBy(e -> e.dept));
        System.out.println(empMap);


    }
}
