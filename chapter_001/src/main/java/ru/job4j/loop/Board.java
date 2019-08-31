package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int x = 1;
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (x % 2 != 0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
                ++x;
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
