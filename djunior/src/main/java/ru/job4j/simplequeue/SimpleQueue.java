package ru.job4j.simplequeue;
import ru.job4j.list.single.IncorrectAction;
import ru.job4j.stack.SimpleStack;

public class SimpleQueue<T> {

    private SimpleStack<T> stack1 = new SimpleStack<T>();
    private SimpleStack<T> stack2 = new SimpleStack<T>();

    public T poll() throws IncorrectAction {
        if (stack2.getSize() == 0) {
            while (stack1.getSize() > 0) {
                stack2.push(stack1.poll());
            }
        }
        return stack2.poll();
    }

    public void push(T value) {
        stack1.push(value);
    }
}
