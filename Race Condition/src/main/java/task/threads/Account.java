package task.threads;

public class Account {
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
}
