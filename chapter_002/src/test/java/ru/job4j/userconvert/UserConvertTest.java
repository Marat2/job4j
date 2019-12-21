package ru.job4j.userconvert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UserConvertTest {
    @Test
    public void userConvertTest() {
        List<User> user = List.of(new User(1, "Marat", "Tashkent"),new User(2, "Sergei",  "Kaliningrad"),new User(3, "Gurbanguli Berdi Muhamedov", "Ashhabad"));
        User one = new User(1, "Marat", "Tashkent");
        UserConvert map = new UserConvert();
        HashMap<Integer, User> userMap = map.process(user);
        assertThat(one.getName(), is(userMap.get(1).getName()));
    }
}
