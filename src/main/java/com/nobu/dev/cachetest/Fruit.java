package com.nobu.dev.cachetest;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String origin;

    @Version
    private int version;

    private Fruit(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public Fruit() {

    }

    public static Fruit create(String name, String origin) {
        if(name == null || origin == null) {
            throw new IllegalArgumentException("Name and origin must not be null");
        }
        return new Fruit(name, origin);
    }

    public void changeOrigin(String newOrigin) {
        if(newOrigin == null) {
            throw new IllegalArgumentException("Origin must not be null");
        }
        this.origin = newOrigin;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }
}
