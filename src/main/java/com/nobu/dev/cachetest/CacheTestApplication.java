package com.nobu.dev.cachetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;

@SpringBootApplication
public class CacheTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheTestApplication.class, args);
    }

}
