package ru.job4j.array;
import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayResultTest {
    @Test
    public void test() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        int[] first = {1, 3};
        int[] second = {2, 4};
        int[] expect = {1, 2, 3, 4};
        ArrayResult array = new ArrayResult();
        int[] result = array.create(first, second);
        assertThat(result, is(expect));
    }
}
