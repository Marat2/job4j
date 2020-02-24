package job4j.store;

import job4j.simplearray.OutOfLimitException;
import job4j.simplearray.SimpleArray;

public class RoleStore<T extends Role> extends AbstractStore implements Store<Role> {

    public RoleStore(SimpleArray<Role> simplearray) {
        super(simplearray);
    }

    @Override
    public void add(Role model) throws OutOfLimitException {
        sa.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean result = false;
        if (findElement(id)) {
            sa.result[ArrayIndex] = model;
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        if (findElement(id)) {
            sa.remove(ArrayIndex);
            result = true;
        }
        return result;
    }

    @Override
    public Role findById(String id) {
        Role result = new Role("0");
        if (findElement(id)) {
            result = (Role) sa.result[ArrayIndex];
        }
        return result;
    }
}