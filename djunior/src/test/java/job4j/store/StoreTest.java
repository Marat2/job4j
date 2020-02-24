package job4j.store;

import job4j.iteratorOfiterator.Converter;
import job4j.simplearray.OutOfLimitException;
import job4j.simplearray.SimpleArray;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

public class StoreTest {
    private RoleStore<Role> role;
    private UserStore<User> user;
    @Before
    public void setUp() throws OutOfLimitException {
        SimpleArray<User> simpleUserArray = new SimpleArray<>(3);
        SimpleArray<Role> simpleRoleArray = new SimpleArray<>(3);
        role = new RoleStore<>(simpleRoleArray);
        user = new UserStore<>(simpleUserArray);
        User user1 = new User("234");
        User user2 = new User("2234");
        User user3 = new User("2334");
        Role role1 = new Role("2314");
        Role role2 = new Role("22314");
        Role role3 = new Role("23314");
        user.add(user1);
        user.add(user2);
        user.add(user3);
        role.add(role1);
        role.add(role2);
        role.add(role3);
    }
    @Test
    public void FiresTest() {
        System.out.println(user.findById("234"));
    }
}
