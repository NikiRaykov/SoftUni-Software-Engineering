public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        if (name.length() < 1){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;

    }

    private void setAge(int age) {
        if (age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay(){
        if (age < 6){
            return 2;
        }else if (age <= 12){
            return 1;
        }
        return 0.75;
    }

    public double productPerDay(){
        return this.calculateProductPerDay();
    }

    @Override
    public String toString(){
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name, this.age, this.productPerDay());
    }
}
