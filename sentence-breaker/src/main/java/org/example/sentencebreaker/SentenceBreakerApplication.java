package org.example.sentencebreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Sentence breaker application
 *
 * @author ywb
 * @date 2020/3/15 20:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentenceBreakerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentenceBreakerApplication.class, args);
    }
}
