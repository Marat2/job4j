package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect= {"Привет", "Мир", "Супер"};
        ArrayDuplicate array= new ArrayDuplicate();
        String[] result=array.remove(input);
        assertThat(result,arrayContainingInAnyOrder(expect));
    }
}
