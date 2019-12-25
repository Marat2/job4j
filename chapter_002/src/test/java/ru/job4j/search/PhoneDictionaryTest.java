package ru.job4j.search;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
    @Test
    public void findSet() {
        PhoneDictionary phones = new PhoneDictionary();
        Person one = new Person("Petr", "Arsentev", "534872", "Bryansk");
        Person two = new Person("Anatoliy", "Petrov", "322432", "Tashkent");
        phones.add(one);
        phones.add(two);
        phones.add(new Person("Vasya", "Dmitriev", "23222", "Хабаровск"));
        List<Person> expected = List.of(one, two);
        List<Person> actual = phones.find("Petr");
        assertThat(expected, is(actual));
    }
}
