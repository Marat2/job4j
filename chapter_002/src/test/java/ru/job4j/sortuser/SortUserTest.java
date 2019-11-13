package ru.job4j.sortuser;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void testConvertMethod() {
        List<User> list = new ArrayList<>();
        User one = new User("Rajeev", 1010);
        User two = new User("Sachin", 1005);
        User three = new User("Chris", 1008);
        List<User> expected = new ArrayList<>();
        expected.add(two);
        expected.add(three);
        expected.add(one);
        list.add(one);
        list.add(two);
        list.add(three);
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(list);
        assertThat(result.toArray(), is(expected.toArray()));
    }

    @Test
    public void testSortByLengthMethod() {
        List<User> list = new ArrayList<>();
        User one = new User("Rajeev", 1010);
        User two = new User("Sachin1", 1005);
        User three = new User("Chris", 1008);
        List<User> expected = new ArrayList<>();
        expected.add(three);
        expected.add(one);
        expected.add(two);
        list.add(one);
        list.add(two);
        list.add(three);
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(list);
        assertThat(result.toArray(), is(expected.toArray()));
    }
    @Test
    public void testSortByAllFields() {
        List<User> list = new ArrayList<>();
        User one = new User("Сергей", 25);
        User two = new User("Иван", 30);
        User three = new User("Сергей", 20);
        User four = new User("Иван", 25);

        List<User> expected = new ArrayList<>();
        expected.add(four);
        expected.add(two);
        expected.add(three);
        expected.add(one);

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(list);
        assertThat(result.toArray(), is(expected.toArray()));
    }
}
