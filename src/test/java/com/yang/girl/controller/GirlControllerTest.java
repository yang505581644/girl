package com.yang.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

   @Autowired
   private MockMvc mvc;

    @Test
    public void girlList() {
        try {
            mvc.perform(MockMvcRequestBuilders.get("/girls"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
                    //.andExpect(MockMvcResultMatchers.content().string("abc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}