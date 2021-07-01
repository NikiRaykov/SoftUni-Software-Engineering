package OrderByAge;

public class Order {
    String name;
    String id;
    int age;

    public Order(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String output(){
        return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
    }
}


