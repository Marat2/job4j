package ru.job4j.strategy;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
public class PaintTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+     +")
                                .append("+     +")
                                .append("++++")
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawtriangle() {
        Triangle tr = new Triangle();
        assertThat(
                tr.draw(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" + + ")
                                .append("+   +")
                                .append("+++++++")
                                .toString()
                )
        );
    }
    @Test
    public void whenDrawSquarFromPaint() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+  +")
                                .append("+  +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }
    @Test
    public void whenDrawTriangleFromPaint() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" + + ")
                                .append("+   +")
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
        System.setOut(stdout);
    }
}
