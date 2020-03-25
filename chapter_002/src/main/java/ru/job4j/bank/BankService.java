package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (!list.contains(account)) {
            list.add(account);
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        Set<User> keys = users.keySet();
        for (User user : keys) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            System.out.println("Passport not found");
            System.exit(1);
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account acc : list) {
            if (acc.getRequisite().equals(requisite)) {
                account = acc;
                break;
            }
        }

        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String lastPassport, String lastRequisite, double amount) {
        boolean rsl = false;
        Account account1 = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(lastPassport, lastRequisite);
        if (account1.getBalance() >= amount) {
            account1.setBalance(account1.getBalance() - amount);
            account2.setBalance(account2.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, 140));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
        BankService b = new BankService();
        b.addAccount("12", new Account("1", 100));
        b.transferMoney("12", "1", "13", "2", 10.0);
    }
}
