package ru.job4j.loop;

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int x=1;
        for ( int i=1; i<=height;i++) {
            for (int j=1;j<=width;j++ ) {
                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность, когда нужно проставлять X
                if (x%2!=0) {
                    screen.append("x");
                } else {
                    screen.append(" ");
                }
                ++x;
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}
