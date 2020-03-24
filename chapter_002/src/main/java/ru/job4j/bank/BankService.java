package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
//        if (!users.containsKey(user.getPassport())) {
//            users.put(user, new ArrayList<>());
//        }
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
        Set keys = users.keySet();
        for (Object obj : keys) {
            User user = (User) obj;
            if ((user.getPassport() == passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        for (Account acc : list) {
            if (acc.getRequisite() == requisite) {
                account = acc;
                break;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String lastPassport, String lastRequisite, double amount) {
        boolean bol = false;
        boolean rsl = false;
        User user = findByPassport(srcPassport);
        List<Account> list = users.get(user);
        outerloop:
        for (Account acc : list) {
            if (acc.getRequisite() == srcRequisite) {
                if (acc.getBalance() >= amount) {
                    User user2 = findByPassport(lastPassport);
                    List<Account> list2 = users.get(user2);
                    for (Account acc2 : list2) {
                        if (acc2.getRequisite() == lastRequisite) {
                            rsl = true;
                            acc.setBalance(acc.getBalance() - amount);
                            acc2.setBalance(acc2.getBalance() + amount);
                            break outerloop;
                        }
                    }
                }
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
