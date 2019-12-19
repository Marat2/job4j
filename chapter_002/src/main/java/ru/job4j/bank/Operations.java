package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        this.getAccounts(passport).add(account);
    }
    public void deleteAccountFromUser(String passport, Account account) {
        this.getAccounts(passport).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.getAccounts(passport);
    }
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account userAccount = getAccount(srcPassport, srcRequisite);
        if (userAccount != null) {
            if (userAccount.getValue() >= amount) {
                userAccount.setValue(userAccount.getValue() - amount);
                Account destAccount = getAccount(destPassport, dstRequisite);
                if (destAccount != null) {
                    destAccount.setValue(destAccount.getValue() + amount);
                    result = true;
                }
            }
        }
        return result;
    }
    private Account getAccount(String passport, String requisite) {
        List<Account> userAccounts = this.getUserAccounts(passport);
        Account userAccount = null;
        userAccount=userAccounts.stream().filter(e->requisite.equals(e.getRequisites())).findFirst().get();
        return userAccount;
    }
    public List<Account> getAccounts(String passport) {
        List<Account> accounts =this.accounts.entrySet().stream().filter(
                e->passport.equals(e.getKey().getPassport())
        ).map(Map.Entry::getValue).findFirst().get();
        return accounts;
    }
}
