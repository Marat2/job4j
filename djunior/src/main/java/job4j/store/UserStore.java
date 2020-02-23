package job4j.store;

import job4j.simplearray.OutOfLimitException;
import job4j.simplearray.SimpleArray;

public class UserStore<T extends User> implements Store<User> {

    SimpleArray<User> sa = new SimpleArray<>(3);

    @Override
    public void add(User model) throws OutOfLimitException {
        sa.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result = false;
        for (int i = 0; i < sa.result.length; i++) {
            User role = (User) sa.result[i];
            if (role.getId().equals(id)) {
                sa.result[i] = model;
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < sa.result.length; i++) {
            User role = (User) sa.result[i];
            if (role.getId().equals(id)) {
                sa.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public User findById(String id) {
        User result = new User("0");
        for (int i = 0; i < sa.result.length; i++) {
            User role = (User) sa.result[i];
            if (role.getId().equals(id)) {
                sa.remove(i);
                result = role;
            }
        }
        return result;
    }
}
