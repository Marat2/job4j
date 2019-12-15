package ru.job4j.profiles;

import java.util.Objects;

public class Address  implements Comparable<Address>{

    private String city;
    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartament) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartament;
    }

    @Override
    public int compareTo(Address o) {
        int result = this.city.compareTo(o.city);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return this.city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.city);
    }

    @Override
    public String toString() {
        return "Address{"
                +
                "city="
                + city
                +
                ", street='"
                + street
                + '\''
                +
                '}';
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return this.city;
    }
}
