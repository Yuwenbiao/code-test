package org.example.sentencebreaker.service;

import java.util.List;
import java.util.Optional;

/**
 * sentence breaker
 *
 * @author yuwb@corp.21cn.com
 * @date 2020/3/15 21:22
 */
public interface SentenceBreakerService {
    /**
     * Break the sentence in the default dictionary
     *
     * @param sentence the sentence to be broke
     * @return the result of broken sentence
     */
    Optional<List<String>> breakSentence(String sentence);

    /**
     * Break the sentence in the customized dictionary
     *
     * @param sentence             sentence the sentence to be broke
     * @param customizedDictionary the customized dictionary
     * @return the result of broken sentence
     */
    Optional<List<String>> breakSentenceInCustomizedDictionary(String sentence, List<String> customizedDictionary);

    /**
     * Break the sentence in both dictionary
     *
     * @param sentence             sentence the sentence to be broke
     * @param customizedDictionary the customized dictionary
     * @return the result of broken sentence
     */
    Optional<List<String>> breakSentenceInBothDictionary(String sentence, List<String> customizedDictionary);
}
