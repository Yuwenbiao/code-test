package org.example.sentencebreaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.sentencebreaker.dto.BaseResponse;
import org.example.sentencebreaker.service.SentenceBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * sentence breaker controller
 *
 * @author ywb
 * @date 2020/3/15 20:54
 */
@RestController
@RequestMapping("sentenceBreaker")
@Slf4j
public class SentenceBreakerController {
    @Autowired
    private SentenceBreakerService sentenceBreakerService;

    @RequestMapping("getBrokenSentences")
    public BaseResponse<List<String>> getBrokenSentences(String sentence) {
        log.info("getBrokenSentences sentence = {}", sentence);
        Optional<List<String>> sentenceResult = sentenceBreakerService.breakSentence(sentence);
        return sentenceResult.map(BaseResponse::success).orElseGet(BaseResponse::error);
    }
}
