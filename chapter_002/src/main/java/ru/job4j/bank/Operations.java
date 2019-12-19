package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {
    Set<User> accounts = new HashSet <User>();
    public Set<User> getAccounts() {  return this.accounts;   }

    public void addUser(User user) {
        this.accounts.add(user);
    }

    public void deleteUser(User user) {
        this.accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        getUserAccounts(passport).add(account);
    }
    public void deleteAccountFromUser(String passport, Account account) {
        getUserAccounts(passport).remove(account);
    }

    public List<Account> getUserAccounts(String passport) {
        return this.accounts.stream().filter(
                                                u->u.getPassport().equals(passport)
                                            ).collect(Collectors.toList()).get(0).getAccounts();
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
        return getUserAccounts(passport).stream().filter(
                a->a.getRequisites().equals(requisite)
        ).collect(Collectors.toList()).get(0);
    }
}
