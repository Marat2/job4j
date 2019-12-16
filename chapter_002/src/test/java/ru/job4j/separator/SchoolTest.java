package ru.job4j.separator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void getA() {
        Predicate<Student> classA = (i) -> i.score > 70 && i.score <= 100;
        List<Student> students = this.setStudents();
        School school = new School();
        List<Student> expected = students.stream().filter(student->student.score > 70 && student.score <= 100).collect(Collectors.toList());
        assertThat(expected, is(school.collect(students, classA)));
    }
    @Test
    public void getB() {
        Predicate<Student> classB = (i) -> i.score > 50 && i.score <= 70;
        List<Student> students = this.setStudents();
        School school = new School();
        List<Student> expected = students.stream().filter(student->student.score > 50 && student.score <= 70).collect(Collectors.toList());
        assertThat(expected, is(school.collect(students, classB)));
    }
    @Test
    public void getC() {
        Predicate<Student> classC = (i) -> i.score >= 0 && i.score <= 50;
        List<Student> students = this.setStudents();
        School school = new School();
        List<Student> expected = students.stream().filter(student->student.score >= 0 && student.score <= 50).collect(Collectors.toList());
        assertThat(expected, is(school.collect(students, classC)));
    }
    @Test
    public void stMap() {
        List<Student> students = this.setStudents();
        School school = new School();
        assertTrue("{A=Student{score=75, name='A'}, B=Student{score=85, name='B'}, C=Student{score=51, name='C'}, D=Student{score=25, name='D'}, E=Student{score=35, name='E'}}".equals(school.studentlist(students).toString()));
    }
    private List<Student> setStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(75, "A"));
        students.add(new Student(85, "B"));
        students.add(new Student(51, "C"));
        students.add(new Student(25, "D"));
        students.add(new Student(35, "E"));
        return students;
    }
}
