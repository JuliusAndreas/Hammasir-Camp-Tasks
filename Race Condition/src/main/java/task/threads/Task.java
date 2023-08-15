package task.threads;

import task.threads.Main.Transaction;

import java.util.List;

public class Task implements Runnable {
    private final Integer totalThreads;
    private Integer taskId;
    private List<Transaction> transactions;
    private List<Account> accounts;
    private Integer eachThreadShare;

    public Task(Integer taskId, Integer totalThreads, List<Transaction> transactions, List<Account> accounts) {
        this.taskId = taskId;
        this.totalThreads = totalThreads;
        this.transactions = transactions;
        this.accounts = accounts;
        this.eachThreadShare = transactions.size() / this.totalThreads;
    }

    @Override
    public void run() {
        Integer startingPoint = this.taskId * this.eachThreadShare;
        Integer endingPoint =
                this.taskId == this.totalThreads - 1 ?
                        transactions.size() - 1 : startingPoint + (this.eachThreadShare - 1);
        for (int i = startingPoint; i < endingPoint; i++) {
            if (i < transactions.size()) {
                Integer fromAccountIndex = this.transactions.get(i).from() - 1;
                Integer toAccountIndex = this.transactions.get(i).to() - 1;
                Long transAmount = this.transactions.get(i).amount();
                this.accounts.get(fromAccountIndex).decreaseBalance(transAmount);
                this.accounts.get(toAccountIndex).increaseBalance(transAmount);
            } else break;
        }
    }
}
