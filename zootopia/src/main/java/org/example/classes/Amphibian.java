package org.example.classes;

public class Amphibian extends Animal {
    public Amphibian(String name, String noise) {
        super(name, noise);
    }

    @Override
    public String toString(){
        return "Animal "+ getName() + " is of type AMPHIBIAN. It makes the noise " + getNoise();
    }

}
