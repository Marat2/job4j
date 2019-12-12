package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    List<Item> items = new ArrayList<>();
    private int position = 0;
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int x = 0; x < this.items.size(); x++) {
            if (this.items.get(x).getId().equals(id)) {
                item.setId(id);
                this.items.set(x, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int x = 0; x < this.items.size(); x++) {
            if (this.items.get(x).getId().equals(id)) {
                this.items.remove(x);
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        List<Item> temp = new ArrayList<>();
        Item[] result = new Item[this.items.size()];
        temp.addAll(this.items);
        result = temp.toArray(result);
        return result;
    }
    public Item[] findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (int x = 0; x < this.items.size(); x++) {
            if (this.items.get(x).getName().equals(key)) {
                temp.add(this.items.get(x));
            }
        }
        Item[] result = new Item[temp.size()];
        result = temp.toArray(result);
        return result;
    }

    public Item findById(String id) {
        for (int x = 0; x < this.items.size(); x++) {
            if (this.items.get(x).getId().equals(id)) {
                return this.items.get(x);
            }
        }
        return null;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}
