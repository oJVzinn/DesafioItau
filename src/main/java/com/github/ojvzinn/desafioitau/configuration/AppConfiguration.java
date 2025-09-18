package com.github.ojvzinn.desafioitau.configuration;

import com.github.ojvzinn.desafioitau.service.LogService;
import com.github.ojvzinn.desafioitau.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public TransactionService transactionService() {
        return new TransactionService();
    }

    @Bean
    public LogService logService() {
        return new LogService();
    }
}
