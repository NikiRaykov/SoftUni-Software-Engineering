public class Main {
    public static void main(String[] args) {

        Scale scaleForStrings = new Scale("A", "A");
        System.out.println(scaleForStrings.getHeavier());

        Scale scaleForInts = new Scale(13, 13);
        System.out.println(scaleForInts.getHeavier());


    }
}
