package com.github.ojvzinn.desafioitau.controller;

import com.github.ojvzinn.desafioitau.dto.TransactionDTO;
import com.github.ojvzinn.desafioitau.service.TransactionService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/estatistica")
    public ResponseEntity<String> getStatistics() {
        JSONObject statistics = transactionService.getTransactionsStatistics();
        return new ResponseEntity<>(statistics.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<String> deleteTransactions() {
        transactionService.deleteTransations();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/transacao")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionDTO transactionDTO) {

    }
}
