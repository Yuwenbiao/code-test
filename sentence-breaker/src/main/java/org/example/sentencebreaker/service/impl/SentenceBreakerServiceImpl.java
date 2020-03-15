package org.example.sentencebreaker.service.impl;

import org.example.sentencebreaker.service.SentenceBreakerService;
import org.example.sentencebreaker.util.SentenceBreakerUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * sentence breaker
 *
 * @author ywb
 * @date 2020/3/15 21:30
 */
@Service
public class SentenceBreakerServiceImpl implements SentenceBreakerService {
    /**
     * Break the sentence in the default dictionary
     *
     * @param sentence the sentence to be broke
     * @return the result of broken sentence
     */
    @Override
    public Optional<List<String>> breakSentence(String sentence) {
        List<String> sentenceList = SentenceBreakerUtil.breakSentence(sentence);
        return sentenceList.isEmpty() ? Optional.empty() : Optional.of(sentenceList);
    }

    /**
     * Break the sentence in the customized dictionary
     *
     * @param sentence             sentence the sentence to be broke
     * @param customizedDictionary the customized dictionary
     * @return the result of broken sentence
     */
    @Override
    public Optional<List<String>> breakSentenceInCustomizedDictionary(String sentence, List<String> customizedDictionary) {
        List<String> sentenceList = SentenceBreakerUtil.breakSentence(sentence, customizedDictionary);
        return sentenceList.isEmpty() ? Optional.empty() : Optional.of(sentenceList);
    }

    /**
     * Break the sentence in both dictionary
     *
     * @param sentence             sentence the sentence to be broke
     * @param customizedDictionary the customized dictionary
     * @return the result of broken sentence
     */
    @Override
    public Optional<List<String>> breakSentenceInBothDictionary(String sentence, List<String> customizedDictionary) {
        List<String> sentenceList = SentenceBreakerUtil.breakSentenceInBothDictionary(sentence, customizedDictionary);
        return sentenceList.isEmpty() ? Optional.empty() : Optional.of(sentenceList);
    }
}
