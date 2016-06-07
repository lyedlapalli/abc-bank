package com.abc;

import java.util.Date;

public class Transaction {
    public final double amount;
    public final String type;
    public Date transactionDate;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
        this.transactionDate = DateProvider.getInstance().now();
    }

}
