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
        // Add fruit to database
        fruitRepository.save(fruit);
    }


    public Fruit findById(Long id) {
        return fruitRepository.findById(id).get();
    }
}
