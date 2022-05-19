package melo.guilherme.userapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("it")

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/inserir.sql")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldFindUsers() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.get("/users"))
             .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldFindUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

}