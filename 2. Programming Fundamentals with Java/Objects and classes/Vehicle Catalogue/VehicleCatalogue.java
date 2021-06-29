package VehicleCatalogue;

import java.util.List;

public class VehicleCatalogue {
    private String type;
    private String model;
    private String color;
    private int horsepower;

    public VehicleCatalogue(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getHorsepower() {
        return horsepower;
    }

    static Double averageHorsepower(List<VehicleCatalogue> vehicles) {
        if (vehicles.size() == 0) {
            return 0.0;
        } else {
            return vehicles.stream().mapToDouble(VehicleCatalogue::getHorsepower).sum() / vehicles.size();
        }
    }


    public String output() {
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",
                getType().toUpperCase().charAt(0) + getType().substring(1), getModel(), getColor(), getHorsepower());
    }
}
