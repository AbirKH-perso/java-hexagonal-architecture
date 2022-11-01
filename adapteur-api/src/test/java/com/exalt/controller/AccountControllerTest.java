package com.exalt.controller;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountDepositPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@ContextConfiguration(classes = {AccountController.class})
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    private AccountDepositPort accountDepositPort;

    @Test
    void depositeTest() throws Exception {
        Mockito.when(accountDepositPort.deposite(100L,1L)).thenReturn(new AccountDto());
        mockMvc.perform(post("/account/deposite").param("amount","100").param("accountNumber","1"))
                .andExpect(status().isOk());
    }
}