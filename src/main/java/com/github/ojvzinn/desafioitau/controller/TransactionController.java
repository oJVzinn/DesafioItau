package com.github.ojvzinn.desafioitau.controller;

import com.github.ojvzinn.desafioitau.dto.TransactionDTO;
import com.github.ojvzinn.desafioitau.entity.TimerEntity;
import com.github.ojvzinn.desafioitau.service.LogService;
import com.github.ojvzinn.desafioitau.service.TransactionService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LogService logService;

    @GetMapping("/estatistica")
    public ResponseEntity<String> getStatistics() {
        TimerEntity timer = new TimerEntity(System.currentTimeMillis());
        logService.sendInputLog("/estatistica", "GET");
        JSONObject statistics = transactionService.getTransactionsStatistics();
        logService.sendOutputLog(timer, "/estatistica", HttpStatus.OK.value());
        return new ResponseEntity<>(statistics.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<String> deleteTransactions() {
        TimerEntity timer = new TimerEntity(System.currentTimeMillis());
        logService.sendInputLog("/transacao", "DELETE");
        transactionService.deleteTranslations();
        logService.sendOutputLog(timer, "/transacao", HttpStatus.OK.value());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/transacao")
    public ResponseEntity<String> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        TimerEntity timer = new TimerEntity(System.currentTimeMillis());
        logService.sendInputLog("/transacao", "POST");
        transactionService.createTransaction(transactionDTO);
        logService.sendOutputLog(timer, "/transacao", HttpStatus.CREATED.value());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthCheck() {
        TimerEntity timer = new TimerEntity(System.currentTimeMillis());
        logService.sendInputLog("/healthcheck", "GET");
        logService.sendOutputLog(timer, "/healthcheck", HttpStatus.OK.value());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
