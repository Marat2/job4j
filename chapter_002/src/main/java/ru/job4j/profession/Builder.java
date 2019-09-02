package ru.job4j.profession;

public class Builder extends Engineer {

    protected String Injuries[];

    public String[] getInjuries() {
        return Injuries;
    }

    public void setInjuries(String[] injuries) {
        Injuries = injuries;
    }

}
