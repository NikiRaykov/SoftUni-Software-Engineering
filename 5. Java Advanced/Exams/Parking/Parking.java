package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity){
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getManufacturer().equals(manufacturer)
                && data.get(i).getModel().equals(model)){
                index = i;
            }
        }
        if (index != -1){
            data.remove(index);
            return true;
        }

        return false;
    }

    public Car getLatestCar() {
        Car result = null;
        for (Car car: data) {
            if (result== null || result.getYear() < car.getYear()){
                result = car;
            }
        }

        return result;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car: data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder("The cars are parked in " + this.type + ":");
        for (Car car: data) {
            out.append(System.lineSeparator());
            out.append(car);
        }
        return out.toString().trim();
    }
}
