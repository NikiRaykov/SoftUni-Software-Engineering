package Car;

public class Car {
   private String brand;
   private String model;
   private int horsePower;


    public String getBrand() {
        return this.brand;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    void getInfo(){
        System.out.printf("The car is: %s %s - %d HP.%n",getBrand(),
                getModel(), getHorsePower());
    }
}
