import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings(ArrayList<String> data){
        this.data = data;
    }

    public void push(String item){
        this.data.add(item);
    }

    public String pop(){
        return this.data.get(data.size() - 1);
    }

    public String peek(){
        return this.data.get(data.size() - 1);
    }

    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
