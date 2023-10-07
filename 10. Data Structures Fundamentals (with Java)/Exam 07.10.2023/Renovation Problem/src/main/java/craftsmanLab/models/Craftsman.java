package craftsmanLab.models;


import java.util.ArrayList;
import java.util.List;

public class Craftsman {
    public String name;
    public double hourlyRate;
    public double totalEarnings;


    public Craftsman(String name, double hourlyRate, double totalEarnings) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.totalEarnings = totalEarnings;
    }

    @Override
    public String toString() {
        return "Craftsman{" +
                "name='" + name + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", totalEarnings=" + totalEarnings +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

}
