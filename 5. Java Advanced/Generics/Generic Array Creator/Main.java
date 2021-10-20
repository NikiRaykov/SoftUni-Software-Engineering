public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.
                <String>create(10, "none");


        Integer[] integers = ArrayCreator.
                <Integer>create(Integer.class, 10, 0);

        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }

        for (String string : strings) {
            System.out.print(string + " ");
        }
    }
}
