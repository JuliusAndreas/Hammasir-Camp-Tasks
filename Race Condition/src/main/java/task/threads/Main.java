package task.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public record Transaction(Integer from, Integer to, Long amount){}
    public static final Integer maxThreads = 4;
    public static void main(String[] args) {
        List<Account> accounts = Reader.parseAccounts("/home/julius_andreas/CasualProjects/Hammasir-Camp-Tasks/Race Condition/src/main/java/task/threads/Race Conditions - Accounts.csv");
        List<Transaction> transactions = Reader.parseTransactions("/home/julius_andreas/CasualProjects/Hammasir-Camp-Tasks/Race Condition/src/main/java/task/threads/Race Conditions - Transaction.csv");
        ExecutorService exser = Executors.newFixedThreadPool(Main.maxThreads);
        for (int i = 0; i < Main.maxThreads; i++) {
            exser.submit(new Task(i, Main.maxThreads, transactions, accounts));
        }
        for (Account account:accounts) {
            System.out.println(account);
        }
    }
}

