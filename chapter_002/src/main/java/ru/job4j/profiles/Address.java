package ru.job4j.profiles;

public class Address {
    public Address(String city, String street, int home, int apartament) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartament;
    }
    private String city;
    private String street;

    private int home;

    private int apartment;
}
