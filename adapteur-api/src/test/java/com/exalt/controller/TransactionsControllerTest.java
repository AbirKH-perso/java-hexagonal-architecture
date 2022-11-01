package com.exalt.controller;

import com.exalt.ports.api.TransactionServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TransactionsController.class)
@ContextConfiguration(classes = {TransactionsController.class})
class TransactionsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransactionServicePort transactionServicePort;

    @Test
    void getAlltransactionsTest() throws Exception {
        Mockito.when(transactionServicePort.getAllTransactions(123)).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/transactions/123"))
                .andExpect(status().isOk());
    }
}