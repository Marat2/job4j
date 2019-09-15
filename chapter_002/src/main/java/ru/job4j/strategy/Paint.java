package ru.job4j.strategy;

public class Paint {
    public void draw(Shape shape){
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Triangle tr = new Triangle();
        Paint p =new Paint();
        p.draw(tr);
    }
}
