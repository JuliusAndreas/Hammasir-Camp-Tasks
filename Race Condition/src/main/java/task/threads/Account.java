package task.threads;

public class Account {
    final private Integer lock = Integer.valueOf(1);
    private Integer id;
    private String accountName;
    private Long balance;

    public Account(Integer id, String accountName, Long balance) {
        this.id = id;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public Long getBalance() {
        return balance;
    }

    public void increaseBalance(Long balance) {
        synchronized (this.balance) {
            this.balance += balance;
        }
    }

    public void decreaseBalance(Long balance) {
        synchronized (this.balance) {
            this.balance -= balance;
        }
    }

    public String toString() {
        return "[" + this.id + "," + this.accountName + "," + this.balance + "]";
    }
}
