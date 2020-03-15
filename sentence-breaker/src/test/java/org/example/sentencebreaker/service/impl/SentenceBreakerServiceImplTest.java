package org.example.sentencebreaker.service.impl;

import org.example.sentencebreaker.service.SentenceBreakerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SentenceBreakerServiceImplTest {
    private List<String> dictionary = Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man", "go", "mango");
    private String testSentence = "ilikesamsungmobile";

    @Autowired
    SentenceBreakerService sentenceBreakerService;

    @Test
    void testBreakSentence() {
        Optional<List<String>> sentenceList = sentenceBreakerService.breakSentence(testSentence);
        assertEquals("[i like sam sung mobile, i like samsung mobile]", sentenceList.get().toString());
    }

    @Test
    void testBreakSentenceWithoutResult() {
        Optional<List<String>> sentenceList = sentenceBreakerService.breakSentence("Ilikehuaweimobile");
        assertFalse(sentenceList.isPresent());
    }

    @Test
    void testBreakSentenceInCustomizedDictionary() {
        Optional<List<String>> sentenceList = sentenceBreakerService.breakSentenceInCustomizedDictionary(testSentence, dictionary);
        assertEquals("[i like sam sung mobile]", sentenceList.get().toString());
    }

    @Test
    void testBreakSentenceInBothDictionary() {
        Optional<List<String>> sentenceList = sentenceBreakerService.breakSentenceInBothDictionary(testSentence, dictionary);
        assertEquals("[i like sam sung mobile, i like samsung mobile]", sentenceList.get().toString());
    }
}