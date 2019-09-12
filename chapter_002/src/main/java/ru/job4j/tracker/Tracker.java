package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    Item[] items = new Item[100];

    private int position = 0;
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int x = 0; x < this.position; x++) {
            if (items[x] != null && items[x].getId().equals(id)) {
                items[x] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int x = 0; x < items.length; x++) {
            if (items[x] != null && items[x].getId().equals(id)) {
               System.arraycopy(items, x + 1, items, x, this.position);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        for (int x = 0; x < items.length; x++) {
            if (items[x] == null) {
                items = Arrays.copyOf(items,  this.position);
            }
        }
        return items;
    }
    public Item[] findByName(String key) {
        for (int x = 0; x < items.length; x++) {
            if (items[x] == null || !items[x].getName().equals(key)) {
                items = Arrays.copyOf(items, this.position - 1);
                --this.position;
            }
        }
        return items;
    }

    public Item findById(String id) {
        for (int x = 0; x < items.length; x++) {
            if (items[x] != null && items[x].getId().equals(id)) {
                return items[x];
            }
        }
        return null;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
