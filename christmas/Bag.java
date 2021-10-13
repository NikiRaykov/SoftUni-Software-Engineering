package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;
    private String name;

    public Bag(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getColor() {
        return color;
    }

    public void add(Present present) {
        if (this.capacity > this.data.size()){
            this.data.add(present);
        }
    }

    public void remove(String name) {
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)){
                index = i;
            }
            if (index != - 1){
                this.data.remove(index);
                System.out.println("true");
                return;
            }

            System.out.println("false");
        }
    }

    public int count() {
        return this.data.size();
    }


    public Present heaviestPresent() {
        Present result = null;
        for (Present present: data) {
            if (result == null || result.getWeight() < present.getWeight()){
                result = present;
            }
        }
        return result;
    }

    public Present getPresent(String name) {
        return this.data.stream().filter(element->element.getName().equals(name)).findFirst().orElse(null);
    }


    public String report() {
        StringBuilder out = new StringBuilder(this.color + " bag contains:");
        for (Present present: data) {
            out.append(System.lineSeparator());
            out.append(present);
        }
        return out.toString().trim();
    }


}
