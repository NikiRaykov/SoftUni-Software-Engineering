import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    public static<T> T[] create(int length, T def) {
        Object[] arr = (T[])(Array.newInstance(def.getClass(), length));

        Arrays.fill(arr, def);

        return (T[])arr;
    }

    public static<T> T[] create(Class<T> clazz, int length, T def) {
        Object[] arr = (T[])(Array.newInstance(clazz, length));

        Arrays.fill(arr, def);

        return (T[])arr;
    }
}
