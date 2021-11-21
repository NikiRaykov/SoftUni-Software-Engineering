import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxObj = ctor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commands = input.split("_");
            String methodName = commands[0];
            int num = Integer.parseInt(commands[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxObj, num);

            System.out.println(innerValue.get(blackBoxObj));

            input = scanner.nextLine();
        }
    }
}
