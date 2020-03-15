package org.example.sentencebreaker.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SentenceBreakerControllerTest {
    private String testSentence = "ilikesamsungmobile";
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetBrokenSentences() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sentenceBreaker/getBrokenSentences")
                .param("sentence", testSentence))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("data").exists())
                .andExpect(jsonPath("data").isArray());
    }
}