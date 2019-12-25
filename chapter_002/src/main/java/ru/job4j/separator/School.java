package ru.job4j.separator;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> collectStudents = students.stream().filter(predict).collect(Collectors.toList());
        return collectStudents;
    }
    Map<String, Student> studentlist(List<Student> students) {
        Map<String, Student> stlist = students.stream().collect(Collectors.toMap(Student::getName, e->e));
        return stlist;
    }
    List<Student> levelOf(List<Student> students, int bound) {
        List<Student> s = students.stream().flatMap(Stream::ofNullable).collect(Collectors.toList());
        Collections.sort(s);
        List<Student> result = s.stream().takeWhile(v->v.score > bound).collect(Collectors.toList());
        return result;
    }
}
