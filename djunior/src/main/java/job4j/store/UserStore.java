package job4j.store;

public class UserStore<T extends User> implements Store {
    @Override
    public void add(Base model) {

    }

    @Override
    public boolean replace(String id, Base model) {//по стринговому id находит объект и заменяет его
        return false;
    }

    @Override
    public boolean delete(String id) {//по стринговому id находит объект и удаляет его
        return false;
    }

    @Override
    public Base findById(String id) {
        return null;
    }
}
