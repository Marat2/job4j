package ru.job4j.map;


import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Calendar;
public class UserTest {
    Map<User,Object> usermap;

    @Before
    public void setUp() {
        usermap = new HashMap();
        Calendar calendar = new GregorianCalendar(2017, 1 , 25);
        User user1 = new User("M", 26,calendar);
        User user2 = new User("M", 26,calendar);
        usermap.put(user1,"user1");//key value
        
        usermap.put(user2,"user2");

    }

    @Test
    public void testMap(){
        System.out.println(usermap);
    }
}
