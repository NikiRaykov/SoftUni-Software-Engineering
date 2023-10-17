public class Scale<T extends Comparable<T>> {
    public final T left;
    public final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int result = left.compareTo(right);

        if (result < 0){
            return right;
        }else if (result > 0){
            return left;
        }

        return null;
    }
}
