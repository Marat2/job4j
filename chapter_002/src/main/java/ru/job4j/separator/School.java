package ru.job4j.separator;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict){
        //Predicate<Integer> isPositive = x -> x > 0;
        //System.out.println(isPositive.test(5)); // true
        List<Student> collectStudents = students.stream().filter(predict).collect(Collectors.toList());
        return collectStudents;
    }
}
