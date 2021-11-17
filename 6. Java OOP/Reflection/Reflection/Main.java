import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        Reflection reflection = new Reflection();
        Class clazz = reflection.getClass();

        System.out.println(clazz);

        String typeName = clazz.getSuperclass().getTypeName();
        System.out.println("class " + typeName);

        Class<?>[] interfaces = clazz.getInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);

        Constructor<? extends Reflection> ctor = clazz.getConstructor();
        Reflection instance = ctor.newInstance();
        System.out.println(instance);
    }
}
