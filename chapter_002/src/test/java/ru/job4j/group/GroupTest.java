package ru.job4j.group;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class GroupTest {
    @Test
    public void testGroup() {
        List<Student> students = List.of(new Student("A", Set.of("first", "second", "third")),
                                         new Student("B", Set.of("third")),
                                         new Student("C", Set.of("first", "third")),
                                         new Student("D", Set.of("second", "third")),
                                         new Student("E", Set.of("third")),
                                         new Student("F", Set.of("first", "second")),
                                         new Student("G", Set.of("first")),
                                         new Student("H", Set.of("second")));
        Group list = new Group();
        Map<String, Set<String>> result = list.sections(students);
        assertEquals(result.toString(), "{third=[A, B, C, D, E], first=[A, C, F, G], second=[A, D, F, H]}");
    }
}
