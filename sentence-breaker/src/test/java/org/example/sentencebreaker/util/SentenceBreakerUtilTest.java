package org.example.sentencebreaker.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SentenceBreakerUtilTest {
    private List<String> dictionary = Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man", "go", "mango");
    private String testSentence = "ilikesamsungmobile";

    @Test
    void testBreakSentence() {
        List<String> sentenceResult = SentenceBreakerUtil.breakSentence(testSentence);
        assertEquals("[i like sam sung mobile, i like samsung mobile]", sentenceResult.toString());
    }

    @Test
    void testBreakSentenceInCustomizedDictionary() {
        List<String> sentenceResult = SentenceBreakerUtil.breakSentence(testSentence, dictionary);
        assertEquals("[i like sam sung mobile]", sentenceResult.toString());
    }

    @Test
    void testBreakSentenceInBothDictionary() {
        List<String> sentenceResult = SentenceBreakerUtil.breakSentenceInBothDictionary(testSentence, dictionary);
        assertEquals("[i like sam sung mobile, i like samsung mobile]", sentenceResult.toString());
    }
}