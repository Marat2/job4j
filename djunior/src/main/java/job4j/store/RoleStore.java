package job4j.store;

import job4j.simplearray.OutOfLimitException;
import job4j.simplearray.SimpleArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class RoleStore<T extends Role> implements Store<Role> {

    SimpleArray<Role> sa = new SimpleArray<Role>(3);

    @Override
    public void add(Role model) throws OutOfLimitException {
        sa.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean result = false;
        for (int i = 0; i < sa.result.length; i++) {
             Role role = (Role) sa.result[i];
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
            Role role = (Role) sa.result[i];
            if (role.getId().equals(id)) {
                sa.remove(i);
                result = true;
            }
        }
        return result;
    }

    @Override
    public Role findById(String id) {
        Role result = new Role("0");
        for (int i = 0; i < sa.result.length; i++) {
            Role role = (Role) sa.result[i];
            if (role.getId().equals(id)) {
                result = role;
            }
        }
        return result;
    }
}
