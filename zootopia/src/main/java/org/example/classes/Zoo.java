package org.example.classes;

//import org.example.animal;
//import org.example.attraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Zoo {

    public static Double revenue;

    private static List<Attraction> _attractions = null;

    private final List<Animal> _animals;

    private final List<String> _feedback;

    Animal elephant = new Mammal("Elephant", "growl");
    Animal monkey = new Mammal("Monkey", "growl");
    Animal frog = new Amphibian("Frog", "ribbit");
    Animal toad= new Amphibian("Toad", "ribbit");

    Animal snake = new Reptile("Snake","hiss");
    Animal lizard = new Reptile("Lizard", "hiss");
    public Zoo() {
         revenue = 0.0;
        _attractions = new ArrayList<>(Arrays.asList(new Attraction("Jungle safari", "Visit the jungle", 100))){};
        _animals = new ArrayList<>(Arrays.asList(elephant,monkey,frog,toad,snake,lizard));
        _feedback = new ArrayList<>();
    }

    public List<Animal> get_animals() {
        return _animals;
    }

    public static List<Attraction> get_attractions() {
        return _attractions;
    }

    public void addAttraction(Attraction attraction) {
        if(_attractions.contains(attraction)){
            System.out.println("Attraction already in zoo");
        }else{
            _attractions.add(attraction);
            System.out.println("Attraction added successfully");
        }
    }

    public Attraction findAttraction(String name){
        for(Attraction att: _attractions){
            if(Objects.equals(att.getName(), name)){
                System.out.println("Attraction found");
                return att;
            }
        }

        return null;
    }

    public void removeAttraction(String name){
        for (Attraction att : _attractions){
            if (Objects.equals(att.getName(),name)){
                _attractions.remove(att);
                System.out.println("Attraction removed successfully");
                return;
            }
        }System.out.println("Attraction not found");
    }



    public void viewattractions(){
        int i =0;
        for(Attraction att: _attractions){
            i++;
            System.out.println(i+ ". "+ att.getName());
        }
    }
    public void modifyAttraction(String name, String des){
        for(Attraction att: _attractions){
            if(Objects.equals(att.getName(), name)){
                att.setDescription(des);
                System.out.println("Attraction modified successfully");
                return;
            }
        }
        System.out.println("Attraction not found");
    }


    public void addAnimal(Animal animal) {
        for (Animal ani: _animals){
            if(ani.getName().equalsIgnoreCase(animal.getName())){
                System.out.println("Animal already in zoo");
                return;
            }
        }
        _animals.add(animal);
        System.out.println("Animal added successfully");
    }
    public void removeAnimal(String name){
        for (Animal ani : _animals){
            if (Objects.equals(ani.getName(),name)){
                _animals.remove(ani);
                System.out.println("Animal removed sucessfully");
                return;
            }
        }
        System.out.println("Animal not found");
    }
    public void updateAnimal(String name, String noise){
        for (Animal ani : _animals){
            if (Objects.equals(ani.getName(),name)){
                ani.setNoise(noise);
                System.out.println("Animal details modified successfully");
                return;
            }
        }
        System.out.println("Animal not found");
    }

    public void viewanimal(){
        int i =0;
        for(Animal ani: _animals){
            i++;
            System.out.println(i+ ". "+ ani.getName());
        }
    }

    public void leaveFeedback(String string){

        if (string.length()<=200){
            _feedback.add(string);
            System.out.println("Thank you for your feedback.");
        }else System.out.println("Feedback can be of max 200 characters");

    }
    public void viewFeedback(){
        int i = 0;
        for(String feedback: _feedback){
            i++;
            System.out.println(i + ". "+ feedback);
        }
    }

}
