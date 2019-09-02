package ru.job4j.profession;

public class Surgeon extends Doctor  {

    protected int experience;

    public Operation treatment(Pacient pacient) {
        int chance = this.experience * pacient.status;
        Operation treatment = new Operation(chance);
        return null;
    }
}
