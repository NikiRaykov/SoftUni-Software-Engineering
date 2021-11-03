package animal;

public class Kitten extends Cat {

    final static String KITTEN_GENDER = "FEMALE";

    public Kitten(String name, int age) {
        super(name, age, KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
