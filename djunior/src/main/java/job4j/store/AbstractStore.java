package job4j.store;

import job4j.simplearray.SimpleArray;

abstract class AbstractStore<T extends Base> {

    protected SimpleArray<T> sa;
    protected int ArrayIndex;

    public AbstractStore(SimpleArray<T> simplearray) {
        sa = simplearray;
    }

    protected boolean findElement(String id) {
        boolean result = false;
        for (int i = 0; i < sa.result.length; i++) {
            T role = (T) sa.result[i];
            if (role.getId().equals(id)) {
                this.ArrayIndex = i;
                result = true;
            }
        }
        return result;
    }
}
