package animal;

public class Tomcat extends Cat {

    final static String TOMCAT_GENDER = "MALE";

    public Tomcat(String name, int age) {
        super(name, age, TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW!";
    }
}
