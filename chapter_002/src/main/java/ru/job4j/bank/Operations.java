package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Operations {
    private Map<User, List<Account>> accounts = new  HashMap<User, List<Account>>();

    public Map<User, List<Account>> getAccounts() {
        return this.accounts;
    }

    public void addUser(User user) {
        this.accounts.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        this.accounts.get(new User(passport)).add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.accounts.get(new User(passport)).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.accounts.get(new User(passport));
    }
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        List<Account> userAccounts = this.accounts.get(new User(srcPassport));
        Account userAccount = userAccounts.get(userAccounts.indexOf(new Account(srcRequisite)));
        if (userAccount.getValue() >= amount) {
            userAccount.setValue(userAccount.getValue() - amount);
            List<Account> descAccounts = this.accounts.get(new User(destPassport));
            Account destAccount = descAccounts.get(descAccounts.indexOf(new Account(dstRequisite)));
            destAccount.setValue(destAccount.getValue() + amount);
            result = true;
        }
        return result;
    }
}
