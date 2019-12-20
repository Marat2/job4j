package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OperationsTest {

    @Test
    public void addUserTest() {
        User testUser = new User("22788339", "Ivan");
        User testUser1 = new User("3345674", "Petr");
        Operations testAction = new Operations();
        testAction.addUser(testUser);
        testAction.addUser(testUser1);
        assertThat(testAction.getAccounts().size(), is(2));
    }
    @Test
    public void deleteUser() {
        User testUser = new User("22788339", "Ivan");
        User testUser1 = new User("3345674", "Petr");
        Operations testAction = new Operations();
        testAction.addUser(testUser);
        testAction.addUser(testUser1);
        testAction.deleteUser(testUser1);
        assertThat(testAction.getAccounts().size(), is(1));
    }
    @Test
    public void addAccountToUser() {
        User testUser = new User("22788339", "Ivan");
        Account firstUserAccount = new Account("mh88945", 0);
        Account secondUserAccount = new Account("mh788945", 0);
        Operations testAction = new Operations();
        testAction.addUser(testUser);
        testAction.addAccountToUser(testUser.getPassport(), firstUserAccount);
        testAction.addAccountToUser(testUser.getPassport(), secondUserAccount);
        testAction.getUserAccounts(testUser.getPassport()).size();
        assertThat(testAction.getUserAccounts(testUser.getPassport()).size(), is(2));
    }
    @Test
    public void deleteUserAccount() {
        User testUser = new User("22788339", "Ivan");
        Account firstUserAccount = new Account("mh88945", 0);
        Account secondUserAccount = new Account("mh788945", 0);
        Operations testAction = new Operations();
        testAction.addUser(testUser);
        testAction.addAccountToUser(testUser.getPassport(), firstUserAccount);
        testAction.addAccountToUser(testUser.getPassport(), secondUserAccount);
        testAction.deleteAccountFromUser(testUser.getPassport(), secondUserAccount);
        testAction.getUserAccounts(testUser.getPassport()).size();
        assertThat(testAction.getUserAccounts(testUser.getPassport()).size(), is(1));
    }
    @Test
    public void addMoneyToUserAccount() {
        User testUser = new User("22788339", "Ivan");
        Account firstUserAccount = new Account("mh88945", 10.0);
        Account secondUserAccount = new Account("mh788945", 0);
        Account asUserAccount = new Account("mh7883945", 0);
        Operations testAction = new Operations();
        testAction.addUser(testUser);
        testAction.addAccountToUser(testUser.getPassport(), firstUserAccount);
        testAction.addAccountToUser(testUser.getPassport(), secondUserAccount);
        testAction.transferMoney(testUser.getPassport(), firstUserAccount.getRequisites(), testUser.getPassport(), asUserAccount.getRequisites(), 6.0);
        List<Account> accounts = testAction.getUserAccounts(testUser.getPassport());
        assertThat(accounts.get(accounts.indexOf(firstUserAccount)).getValue(), is(4.0));
    }
    @Test
    public void transferMOneyFromOneUserToAnother() {
        User testUser = new User("22788339", "Ivan");
        User testUser1 = new User("22228339", "Sergei");
        Account firstUserAccount = new Account("mh88945", 10.0);
        Account secondUserAccount = new Account("mh788945", 0);
        Operations testAction = new Operations();
        testAction.addUser(testUser);
        testAction.addUser(testUser1);
        testAction.addAccountToUser(testUser.getPassport(), firstUserAccount);
        testAction.addAccountToUser(testUser1.getPassport(), secondUserAccount);
        testAction.transferMoney(testUser.getPassport(), firstUserAccount.getRequisites(), testUser1.getPassport(), secondUserAccount.getRequisites(), 6.0);
        List<Account> accounts = testAction.getUserAccounts(testUser.getPassport());
        assertThat(accounts.get(accounts.indexOf(firstUserAccount)).getValue(), is(4.0));
    }
}
