package entities;

public class Address {
    private String street_name;
    private int house_number;

    public Address(String street_name, int house_number) {
        this.street_name = street_name;
        this.house_number = house_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }
}
