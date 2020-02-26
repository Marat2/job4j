package ru.job4j.store;

public class User extends Base {

    private String name;
    private int age;

    protected User(String id) {
        super(id);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User: " + this.name + "; " + "id - " + this.getId();
    }
}
