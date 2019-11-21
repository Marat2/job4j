package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private double value;
    private String requisites;

    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
    @Override
    public boolean equals(Object o) {
        return this.requisites.equals(((Account) o).requisites);
    }
    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
    @Override
    public String toString() {
        return "Account{"
                +
                "requisites="
                + requisites
                +
                ", value='"
                + value
                + '\''
                +
                '}';
    }
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
