package ru.job4j.review;


public class Account {

    double values; //желательно указывать модификатор доступа.
    String reqs;

    public Account(double values, String requisites) { //названия лучше бы соответствовали полям класса
        this.values = values;
        this.reqs = requisites;
    }
    //на мой взгляд стоит сделать сеты для полей и объявить их закрытыми.
    public double getValues() {
        return this.values;
    }


    public String getReqs() {
        return this.reqs;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() { // на мой взгляд лучше сделать Тип название = значение (можно конечно сразу ретурнить строку с подстановкой но помоему это не очень).
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

    public boolean equals(Object o) { //несколько раз возвращается return - хорошо бы сделать один
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return this.reqs.equals(account.reqs);
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}