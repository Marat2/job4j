package ru.job4j.firstfinal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {
    Analize analize = new Analize();
    List<Analize.User> userlist = new ArrayList<>();
    List<Analize.User> changeduserlist = new ArrayList<>();
    @Before
    public void setUp() {
        Analize.User user1 = new Analize.User(1, "Bill");
        Analize.User user2 = new Analize.User(2, "Duff");
        Analize.User user3 = new Analize.User(3, "Jack");
        Analize.User user4 = new Analize.User(4, "Jax");
        Analize.User user5 = new Analize.User(5, "Fill");
        Analize.User user6 = new Analize.User(6, "Mike");

        Analize.User user7 = new Analize.User(1, "Bill Simon");
        Analize.User user8 = new Analize.User(2, "Duff Kook");
        Analize.User user9 = new Analize.User(3, "Jack Black");
        Analize.User user10 = new Analize.User(4, "Jax H");
        Analize.User user11 = new Analize.User(5, "Fill T");
        Analize.User user12 = new Analize.User(6, "Killer Mike");
        Analize.User user13 = new Analize.User(7, "New added element");
        userlist.add(user1);
        userlist.add(user2);
        userlist.add(user3);
        userlist.add(user4);
        userlist.add(user5);
        userlist.add(user6);

        changeduserlist.add(user7);
        changeduserlist.add(user8);
        changeduserlist.add(user9);
        changeduserlist.add(user10);
        changeduserlist.add(user11);
        changeduserlist.add(user12);
        changeduserlist.add(user13);
    }
    @Test
    public void testAnalize() {
        changeduserlist.remove(2);
        Analize.Info tmpInfo = new Analize.Info(1, 5, 1);
        Assert.assertEquals(tmpInfo, analize.diff(userlist, changeduserlist));
    }
}
