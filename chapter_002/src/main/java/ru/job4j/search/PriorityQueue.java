package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        if (tasks.isEmpty() || tasks.peekLast().getPriority() <= task.getPriority()) {
            tasks.add(task);
        }
        else {
            ListIterator<Task> itr = tasks.listIterator(tasks.size());
            while (itr.hasPrevious()) {
                if (itr.previous().getPriority() >= task.getPriority()) {
                    tasks.add(itr.nextIndex(), task);
                }
                break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }

    public LinkedList<Task> getTasks() {
        return this.tasks;
    }
}
