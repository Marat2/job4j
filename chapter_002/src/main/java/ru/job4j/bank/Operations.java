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
        for (Map.Entry<User, List<Account>> acc:this.accounts.entrySet()) {
            if (acc.getKey().getPassport().equals(passport)) {
                acc.getValue().add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> acc:this.accounts.entrySet()) {
            if (acc.getKey().getPassport().equals(passport)) {
                acc.getValue().remove(account);
                break;
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> accounts = null;
        for (Map.Entry<User, List<Account>> acc:this.accounts.entrySet()) {
            if (acc.getKey().getPassport().equals(passport)) {
                accounts = acc.getValue();
                break;
            }
        }
        return accounts;
    }
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account userAccount = getAccount(srcPassport, srcRequisite);
            if (userAccount.getValue() >= amount) {
                userAccount.setValue(userAccount.getValue() - amount);
                Account destAccount = getAccount(destPassport, dstRequisite);
                destAccount.setValue(destAccount.getValue() + amount);
                result = true;
            }
        return result;
    }
    private Account getAccount(String passport, String requisite) {
        List<Account> userAccounts = this.getUserAccounts(passport);
        Account userAccount = null;
        for (Account account:userAccounts) {
            if (account.getRequisites().equals(requisite)) {
                userAccount = account;
                break;
            }
        }
        return userAccount;
    }
}
