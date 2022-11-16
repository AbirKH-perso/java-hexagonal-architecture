package com.exalt.controller;

import com.exalt.data.AccountDto;
import com.exalt.ports.api.AccountServicePort;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
@ContextConfiguration(classes = {AccountController.class})
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AccountServicePort accountServicePort;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void depositTest() throws Exception {
        Mockito.when(accountServicePort.deposit(100L,1L)).thenReturn(new AccountDto());
        mockMvc.perform(post("/account/deposit").param("amount","100").param("accountNumber","1"))
                .andExpect(status().isOk());
    }

    @Test
    void createAccount() throws Exception {
        AccountDto accountDto = new AccountDto(1,5,0.0,"courant");
        Mockito.when(accountServicePort.createAccount(any(AccountDto.class))).thenReturn(accountDto);
        mockMvc.perform(post("/account").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountDto)))
                .andExpect(status().isOk());
    }

    @Test
    void withdrawalTest() throws Exception {
        Mockito.when(accountServicePort.withdrawal(100L,1L)).thenReturn(new AccountDto());
        mockMvc.perform(post("/account/withdrawal").param("amount","100").param("accountNumber","1"))
                .andExpect(status().isOk());
    }
}