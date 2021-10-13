package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()){
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(n -> n.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet: data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet result = null;
        for (Pet pet: data) {
            if (result == null || result.getAge() < pet.getAge()){
                result = pet;
            }
        }
        return result;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder("The clinic has the following patients:");
        for (Pet pet: data) {
            out.append(System.lineSeparator());
            out.append(pet.getName()).append(" ").append(pet.getOwner());
        }
        return out.toString().trim();
    }
}
