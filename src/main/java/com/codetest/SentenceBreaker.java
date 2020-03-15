package com.codetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides some methods to break the sentence in individual dictionary words
 *
 * @author ywb
 * @date 2020/3/14 22:51
 */
public class SentenceBreaker {
    /**
     * default dictionary
     */
    private final static List<String> DICTIONARY = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go");

    /**
     * Break the sentence in the default dictionary
     *
     * @param sentence the sentence to be broke
     */
    public static void breakSentence(String sentence) {
        breakSentence(sentence, DICTIONARY, "");
    }

    /**
     * Break the sentence in the customized dictionary
     *
     * @param sentence             the sentence to be broke
     * @param customizedDictionary the customized dictionary
     */
    public static void breakSentence(String sentence, List<String> customizedDictionary) {
        breakSentence(sentence, customizedDictionary, "");
    }

    /**
     * Break the sentence in both dictionary
     *
     * @param sentence             the sentence to be broke
     * @param customizedDictionary the customized dictionary
     */
    public static void breakSentenceInBothDictionary(String sentence, List<String> customizedDictionary) {
        List<String> bothDictionary = new ArrayList<>();
        bothDictionary.addAll(DICTIONARY);
        bothDictionary.addAll(customizedDictionary);
        breakSentence(sentence, bothDictionary, "");
    }

    /**
     * Break the sentence in the default dictionary
     *
     * @param sentence the sentence to be broke
     * @param result   the result of break sentence
     */
    private static void breakSentence(String sentence, List<String> dictionary, String result) {
        int sentenceLength = sentence.length();

        for (int i = 1; i <= sentenceLength; i++) {
            String prefixWord = sentence.substring(0, i);
            if (dictionary.contains(prefixWord)) {
                if (i == sentenceLength) {
                    result += prefixWord;
                    System.out.println(result);
                }

                breakSentence(sentence.substring(i, sentenceLength), dictionary, result + prefixWord + " ");
            }
        }
    }
}
