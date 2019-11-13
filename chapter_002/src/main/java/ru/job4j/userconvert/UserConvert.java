package ru.job4j.userconvert;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
    HashMap<Integer, User> result = new HashMap<>();
        ListIterator<User> iterator = list.listIterator();
        while (iterator.hasNext()) {
            User cur = iterator.next();
            result.put(cur.getId(), cur);
        }
        return result;
    }
}
