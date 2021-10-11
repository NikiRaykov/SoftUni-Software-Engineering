package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> pets;
    private int capacity;

    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.pets.size()){
            this.pets.add(pet);
        }
    }

    public boolean remove(String name) {
        return pets.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet p: pets) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)){
               return p;
            }
        }
        return null;
    }

    public int getCount() {
        return this.pets.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder("The grooming salon has the following clients:");
        for (Pet pet : pets) {
            out.append(System.lineSeparator());
            out.append(pet.getName() + " " + pet.getOwner());
        }
        return out.toString();
    }
}
