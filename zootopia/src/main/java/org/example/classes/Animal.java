package org.example.classes;

public abstract class Animal {

    private final String name;
    private String noise;

    public Animal(String name, String noise) {
        this.name = name;
        this.noise = noise;

    }

    public String getName() {
        return name;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getNoise() {
        return noise;
    }

    @Override
    public abstract String toString();

}
