package ru.job4j.tree;

import java.util.*;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> node = findBy(parent);
        if (node.isPresent()) {
            Optional<Node<E>> childNode = node.get().children.stream().filter(s->s.value.equals(child)).findFirst();
            if (!childNode.isPresent()) {
                node.get().children.add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
//вытаскиваю первый элемент проверяю на значение если оно нужное то выхожу из петли и вызвращаю элемент
//иначе беру дочерние элементы и вставляю их в текущую очередь т.е. как бы разворачиваю превращая дерево в список.
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                result = false;
                break;
            }
            for (Object child:el.children) {
                data.offer((Node<E>) child);
            }
        }
        return result;
    }

}
