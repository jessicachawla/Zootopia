package org.example.classes;

public class Mammal extends Animal {

    public Mammal(String name, String noise) {
        super(name, noise);
    }

    @Override
    public String toString(){
        return "Animal "+ getName() + " is of type MAMMAL. It makes the noise " + getNoise();
    }


}
