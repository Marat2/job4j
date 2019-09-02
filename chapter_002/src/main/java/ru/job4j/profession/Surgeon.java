package ru.job4j.profession;

public class Surgeon extends Doctor  {

    protected int Experience;

    public Operation treatment(Pacient pacient) {
        int chance=this.Experience*pacient.Status;
        Operation treatment=new Operation(chance);
        return null;
    }
}
