package com.testiniumBank.accountTransactions;


public class AccountTransactions {
    public static float putMoney(float balance, float transactionCost) {
        balance += transactionCost;
        return balance;
    }

    public static float deleteMoney(float balance, float transactionCost) {
        balance -= transactionCost;
        return balance;
    }
}
