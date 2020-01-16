package ru.job4j.group;

public class Holder {
    String key, value;

    Holder(String key, String value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {
        return "key=" + this.key + " val=" + this.value;
    }
}
