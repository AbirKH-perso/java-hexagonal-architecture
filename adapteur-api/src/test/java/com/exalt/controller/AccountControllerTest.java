package com.exalt.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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

    @Test
    void depositeTest() throws Exception {
        mockMvc.perform(post("/account/deposite").param("amount","100").param("accountNumber","1"))
                .andExpect(status().isOk());
    }
}