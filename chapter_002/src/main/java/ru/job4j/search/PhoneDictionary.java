package ru.job4j.search;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        Iterator<Person> itr = persons.iterator();
        while(itr.hasNext()){
            Person cur=itr.next();
            if (cur.getName().contains(key) || cur.getSurname().contains(key) || cur.getPhone().contains(key) || cur.getAddress().contains(key)) {
                result.add(cur);
            }
            //System.out.println(cur.name);
        }
        return result;
    }
}
