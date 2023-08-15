package task.threads;

import task.threads.Main.Transaction;

import java.util.List;

public class Task implements Runnable{
    private Integer taskId;
    private final Integer totalThreads;
    private List<Transaction> transactions;
    private List<Account> accounts;
    public Task(Integer taskId, Integer totalThreads, List<Transaction> transactions, List<Account> accounts) {
        this.taskId = taskId;
        this.totalThreads = totalThreads;
        this.transactions = transactions;
        this.accounts = accounts;
    }
    @Override
    public void run() {

    }
}
