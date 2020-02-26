package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

abstract class AbstractStore<T extends Base> {

    protected SimpleArray<T> sa;
    protected int arrayIndex;

    public AbstractStore(SimpleArray<T> simplearray) {
        sa = simplearray;
    }

    protected boolean findElement(String id) {
        boolean result = false;
        for (int i = 0; i < sa.result.length; i++) {
            T role = (T) sa.result[i];
            if (role.getId().equals(id)) {
                this.arrayIndex = i;
                result = true;
            }
        }
        return result;
    }
}
