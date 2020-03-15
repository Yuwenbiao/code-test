package org.example.feignconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * hello
 *
 * @author yuwb@corp.21cn.com
 * @date 2019/12/30 22:11
 */
@FeignClient("sentence-breaker")
public interface SentenceBreakerService {
    @RequestMapping("/sentenceBreaker/getBrokenSentences")
    String getBrokenSentences(@RequestParam("sentence") String sentence);
}
