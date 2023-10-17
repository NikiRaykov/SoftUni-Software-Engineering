import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        Collections.addAll(integerList, 13, 72, 49, 88);

        Integer max = ListUtils.getMax(integerList);
        Integer min = ListUtils.getMin(integerList);

        System.out.println(max);
        System.out.println(min);

        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, "A", "BB");
        String minString = ListUtils.getMin(stringList);
        System.out.println(minString);
    }
}