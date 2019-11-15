package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Operations {
    private Map<User, List<Account>> accounts = new  HashMap <User, List<Account>>();

    public void addUser(User user) {}

    public void deleteUser(User user) {}

    public void addAccountToUser(String passport, Account account) {}

    public void deleteAccountFromUser(String passport, Account account) {}

    public List<Account> getUserAccounts (String passport) {
        List<Account> accounts = new ArrayList<Account>();
        return accounts;
    }
}
