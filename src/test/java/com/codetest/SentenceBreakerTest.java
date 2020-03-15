package com.codetest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class SentenceBreakerTest {
    private static List<String> dictionary = Arrays.asList("i", "like", "sam", "sung", "mobile", "icecream", "man", "go", "mango");

    static Stream<Arguments> sentenceAndDictionaryProvider() {
        return Stream.of(
                Arguments.of("ilikesamsungmobile", dictionary),
                Arguments.of("ilikeicecreamandmango", dictionary)
        );
    }

    @ParameterizedTest
    @MethodSource("sentenceAndDictionaryProvider")
    void testBreakSentence(String testSentence) {
        SentenceBreaker.breakSentence(testSentence);
    }

    @ParameterizedTest
    @MethodSource("sentenceAndDictionaryProvider")
    void testBreakSentence(String testSentence, List<String> customizedDictionary) {
        SentenceBreaker.breakSentence(testSentence, customizedDictionary);
    }

    @ParameterizedTest
    @MethodSource("sentenceAndDictionaryProvider")
    void testBreakSentenceInBothDictionary(String testSentence, List<String> customizedDictionary) {
        SentenceBreaker.breakSentenceInBothDictionary(testSentence, customizedDictionary);
    }
}