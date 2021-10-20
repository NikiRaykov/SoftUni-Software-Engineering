public class Box<T> {
    public final T value;

    public Box(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", this.value.getClass().getName(), value);
    }
}


