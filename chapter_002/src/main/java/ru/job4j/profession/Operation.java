package ru.job4j.profession;

public class Operation {

    private int chance;
    protected boolean result;

    public Operation(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    public boolean getresult() {
        this.result = false;
        if (this.chance > 50) {
            this.result = true;
        }
        return this.result;
    }
}
