package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.List;

import static restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private List<HealthyFood> healthyFoods;
    private List<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        setNumber(number);
        setSize(size);
        setPricePerPerson(pricePerPerson);
        this.healthyFoods = new ArrayList<>();
        this.beverages = new ArrayList<>();
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setNumber(int number) {
        this.number = number;
    }

    private void setSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }

        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFoods.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double foodBill = this.healthyFoods.stream()
                .mapToDouble(HealthyFood::getPrice).sum();

        double beverageBill = this.beverages.stream()
                .mapToDouble(Beverages::getPrice).sum();

        return foodBill + beverageBill + (numberOfPeople * pricePerPerson);
    }

    @Override
    public void clear() {
        this.numberOfPeople = 0;
        this.isReservedTable = false;
        this.healthyFoods.clear();
        this.beverages.clear();
        this.pricePerPerson = 0;
    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d%n" +
                                     "Size - %d%n" +
                                     "Type - %s%n" +
                                "All price - %.2f",
                                number, size,
                getClass().getSimpleName(), pricePerPerson);
    }
}
