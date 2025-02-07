package com.nobu.dev.cachetest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("fruit")
public class FruitController {
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    public String addFruit(String name, String origin) {
        fruitService.addFruit(Fruit.create(name, origin));
        return "Fruit added";
    }

    @GetMapping("{id}")
    public Fruit findFruit(@PathVariable Long id) {
        return fruitService.findById(id);
    }

    @PutMapping("{id}")
    public String changeOrigin(@PathVariable Long id, String newOrigin) {
        fruitService.changeOrigin(id, newOrigin);
        return "Fruit changed";
    }

    @PutMapping("/delay/{id}")
    public String changeOriginDelay(@PathVariable Long id, String newOrigin) {
        fruitService.changeOriginDelay(id, newOrigin);
        System.out.println(Fruit.class);
        return "Fruit changed";
    }
}
