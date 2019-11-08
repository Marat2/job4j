package ru.job4j.sortuser;
import java.util.Objects;
public class User implements Comparable<User>{

    private String name;
    private int age;

    User(String name,int age) {
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }

    /*@Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age;
    }*/

    /*@Override
    public int hashCode() {
        return Objects.hash(age);
    }*/
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

}
