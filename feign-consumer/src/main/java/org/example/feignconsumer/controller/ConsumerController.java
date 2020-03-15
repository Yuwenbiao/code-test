package org.example.feignconsumer.controller;

import org.example.feignconsumer.service.SentenceBreakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    SentenceBreakerService sentenceBreakerService;

    @RequestMapping(value = "/breakSentence", method = RequestMethod.GET)
    public String breakSentence(String sentence) {
        return sentenceBreakerService.getBrokenSentences(sentence);
    }
}
