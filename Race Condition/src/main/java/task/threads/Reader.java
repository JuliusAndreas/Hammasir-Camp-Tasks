package task.threads;

import task.threads.Main.Transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static List<Account> parseAccounts(String path){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter("\n|,");   //sets the delimiter pattern
        boolean firstRowFlag = true;
        List<Account> accounts = new ArrayList<>();
        while (sc.hasNext())  //returns a boolean value
        {
            //Skipping the first line
            if (firstRowFlag) {
                sc.next();
                sc.next();
                sc.next();
                firstRowFlag = false;
                continue;
            }
            Integer id = Integer.valueOf(sc.next());
            String name = sc.next();
            Long balance = Long.valueOf(sc.next());
            accounts.add(new Account(id, name, balance));
        }
        sc.close();  //closes the scanner
        return accounts;
    }

    public static List<Transaction> parseTransactions(String path){
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter(",|\n");   //sets the delimiter pattern
        boolean firstRowFlag = true;
        List<Transaction> transactions = new ArrayList<>();
        while (sc.hasNext())  //returns a boolean value
        {
            //Skipping the first line
            if (firstRowFlag) {
                sc.next();
                sc.next();
                sc.next();
                firstRowFlag = false;
                continue;
            }
            Integer from = Integer.valueOf(sc.next());
            Integer to = Integer.valueOf(sc.next());
            String part1 = sc.next();
            String part2 = sc.next();
            String resString = part1.concat(part2);
            resString = resString.replaceAll("\\D","");
            Long amount = Long.valueOf(resString);

            transactions.add(new Transaction(from, to, amount));
        }
        sc.close();  //closes the scanner
        return transactions;
    }
}
