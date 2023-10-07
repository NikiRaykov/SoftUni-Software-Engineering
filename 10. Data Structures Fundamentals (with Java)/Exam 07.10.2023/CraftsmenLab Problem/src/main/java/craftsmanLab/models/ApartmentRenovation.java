package craftsmanLab.models;

import java.time.LocalDate;

public class ApartmentRenovation {
    public String address;
    public double area;
    public double workHoursNeeded;
    public LocalDate deadline;
    private Craftsman assignedCraftsman;

    public ApartmentRenovation(String address, double area, double workHoursNeeded, LocalDate deadline) {
        this.address = address;
        this.area = area;
        this.workHoursNeeded = workHoursNeeded;
        this.deadline = deadline;
        this.assignedCraftsman = null;
    }

    @Override
    public String toString() {
        return "ApartmentRenovation{" +
                "address='" + address + '\'' +
                ", area=" + area +
                ", workHoursNeeded=" + workHoursNeeded +
                ", deadline=" + deadline +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getWorkHoursNeeded() {
        return workHoursNeeded;
    }

    public void setWorkHoursNeeded(double workHoursNeeded) {
        this.workHoursNeeded = workHoursNeeded;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Craftsman getAssignedCraftsman() {
        return assignedCraftsman;
    }

    public double getRenovationCost() {
        if (assignedCraftsman != null) {
            return workHoursNeeded * assignedCraftsman.getHourlyRate();
        }

        return 0.0;
    }



}
