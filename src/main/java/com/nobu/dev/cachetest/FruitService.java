package com.nobu.dev.cachetest;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    public void addFruit(Fruit fruit) {
        fruitRepository.save(fruit);
    }

    @Transactional
    public void changeOrigin(Long id, String newOrigin) {
        Fruit fruit = fruitRepository.findById(id).orElseThrow();
        fruit.changeOrigin(newOrigin);
        fruitRepository.save(fruit);
    }


    public Fruit findById(Long id) {
        return fruitRepository.findById(id).get();
    }

    public void changeOriginDelay(Long id, String newOrigin) {
        Fruit fruit = fruitRepository.findById(id).orElseThrow();
        fruit.changeOrigin(newOrigin);
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fruitRepository.save(fruit);
    }
}
