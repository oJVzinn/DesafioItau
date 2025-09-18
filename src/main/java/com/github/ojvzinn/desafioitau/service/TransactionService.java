package com.github.ojvzinn.desafioitau.service;

import com.github.ojvzinn.desafioitau.dto.TransactionDTO;
import com.github.ojvzinn.desafioitau.entity.TransactionEntity;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<TransactionEntity> transactions = new ArrayList<>();

    public JSONObject getTransactionsStatistics() {
        JSONObject response = new JSONObject();
        List<TransactionEntity> transactionFilter = transactions.stream()
                .filter(transactionEntity -> transactionEntity.getDate().isBefore(transactionEntity.getDate().plusSeconds(61)))
                .toList();

        long count = transactionFilter.size();
        float sum = count >= 1 ? (float) transactionFilter.stream().mapToDouble(TransactionEntity::getValue).sum() : 0;
        float avg = count >= 1 ? (sum / count) : 0;
        float min = (float) transactionFilter.stream().mapToDouble(TransactionEntity::getValue).min().orElse(0);
        float max = (float) transactionFilter.stream().mapToDouble(TransactionEntity::getValue).max().orElse(0);

        response.put("count", count);
        response.put("sum", sum);
        response.put("avg", avg);
        response.put("min", min);
        response.put("max", max);
        return response;
    }

    public void createTransaction(TransactionDTO transactionDTO) {
        transactions.add(new TransactionEntity(transactionDTO.getValue(), transactionDTO.getDate()));
    }

    public void deleteTransations() {
        transactions.clear();
    }

}
