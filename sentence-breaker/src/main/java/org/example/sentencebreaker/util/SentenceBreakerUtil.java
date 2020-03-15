package org.example.sentencebreaker.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides some methods to break the sentence in individual dictionary words
 *
 * @author ywb
 * @date 2020/3/14 22:51
 */
public class SentenceBreakerUtil {
    /**
     * default dictionary
     */
    private final static List<String> DICTIONARY = Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go");

    /**
     * Break the sentence in the default dictionary
     *
     * @param sentence the sentence to be broke
     * @return the result of broken sentence
     */
    public static List<String> breakSentence(String sentence) {
        List<String> sentenceList = new ArrayList<>();
        breakSentence(sentence, DICTIONARY, "", sentenceList);
        return sentenceList;
    }

    /**
     * Break the sentence in the customized dictionary
     *
     * @param sentence             the sentence to be broke
     * @param customizedDictionary the customized dictionary
     * @return the result of broken sentence
     */
    public static List<String> breakSentence(String sentence, List<String> customizedDictionary) {
        List<String> sentenceList = new ArrayList<>();
        breakSentence(sentence, customizedDictionary, "", sentenceList);
        return sentenceList;
    }

    /**
     * Break the sentence in both dictionary
     *
     * @param sentence             the sentence to be broke
     * @param customizedDictionary the customized dictionary
     * @return the result of broken sentence
     */
    public static List<String> breakSentenceInBothDictionary(String sentence, List<String> customizedDictionary) {
        List<String> sentenceList = new ArrayList<>();
        List<String> bothDictionary = new ArrayList<>();
        bothDictionary.addAll(DICTIONARY);
        bothDictionary.addAll(customizedDictionary);

        breakSentence(sentence, bothDictionary, "", sentenceList);
        return sentenceList;
    }

    /**
     * Break the sentence in the default dictionary
     *
     * @param sentence   the sentence to be broke
     * @param result     the result of break sentence
     * @param dictionary the dictionary to breaker sentence
     * @param resultList the result list of broken sentence
     */
    private static void breakSentence(String sentence, List<String> dictionary, String result, List<String> resultList) {
        int sentenceLength = sentence.length();

        for (int i = 1; i <= sentenceLength; i++) {
            String prefixWord = sentence.substring(0, i);
            if (dictionary.contains(prefixWord)) {
                if (i == sentenceLength) {
                    result += prefixWord;
                    resultList.add(result);
                }

                breakSentence(sentence.substring(i, sentenceLength), dictionary, result + prefixWord + " ", resultList);
            }
        }
    }
}
