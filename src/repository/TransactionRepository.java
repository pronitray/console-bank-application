package repository;

import domain.Transaction;

import java.util.*;

public class TransactionRepository {
    private final Map<String, List<Transaction>> txByAccount = new HashMap<>();

    public void add(Transaction transaction) {
        txByAccount.computeIfAbsent(transaction.getAccountNumber(), k -> new ArrayList<>()).add(transaction);
    }

    public List<Transaction> findByAccount(String accountNumber) {
        return new ArrayList<>(txByAccount.getOrDefault(accountNumber, Collections.emptyList()));
    }
}
