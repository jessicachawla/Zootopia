package org.example.classes;

public class Reptile extends Animal {

    public Reptile(String name, String noise) {
        super(name, noise);
    }

    @Override
    public String toString(){
        return "Animal "+ getName() + " is of type REPTILE. It makes the noise " + getNoise();
    }


}
