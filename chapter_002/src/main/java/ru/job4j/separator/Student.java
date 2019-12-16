package ru.job4j.separator;

public class Student {
    public int score;
    private String name;
    public Student(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{"
                +
                "score="
                + score
                +
                ", name='"
                + name
                + '\''
                +
                '}';
    }
}
