package ru.job4j.separator;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> collectStudents = students.stream().filter(predict).collect(Collectors.toList());
        return collectStudents;
    }
    Map<String, Student> studentlist(List<Student> students) {
        Map<String, Student> stlist = students.stream().collect(Collectors.toMap(Student::getName, e->e));
        return stlist;
    }
}
