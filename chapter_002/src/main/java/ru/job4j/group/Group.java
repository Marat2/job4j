package ru.job4j.group;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
       return students.stream().flatMap(e -> {
                  return  e.getUnits().stream().map(
                            m -> new Holder(e.getName(), m)
                    );
                }
        ).collect(Collectors.groupingBy(t -> t.value,
               Collector.of(
               HashSet::new,
               (set, el) -> set.add(el.key),
               (left, right) -> {
                    left.addAll(right);
                    return left;
                }
               )));
    }
}
