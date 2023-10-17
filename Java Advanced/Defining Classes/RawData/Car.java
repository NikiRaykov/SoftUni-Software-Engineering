package RawData;

public class Car {
    private String model;
    private int engine;
    private String cargoType;
    private double tire1;
    private double tire2;
    private double tire3;
    private double tire4;

    public Car(String model, int engine, String cargo, double tire1, double tire2, double tire3, double tire4){
        this.model = model;
        this.engine = engine;
        this.cargoType = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getTire1() {
        return tire1;
    }

    public double getTire2() {
        return tire2;
    }

    public double getTire3() {
        return tire3;
    }

    public double getTire4() {
        return tire4;
    }

    Boolean tirePressure(){
        return getTire1() < 1 || getTire2() < 1 || getTire3() < 1 || getTire4() < 1;
    }
    public int getEngine() {
        return engine;
    }

    @Override
    public String toString() {
       return String.format("%s", this.model);
    }
}
