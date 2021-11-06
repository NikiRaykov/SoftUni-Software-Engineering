import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        this.urls.forEach(e -> output.append(e.matches("^[^0-9]+$") ? String.format("Browsing: %s!", e)
                : "Invalid URL!").append(System.lineSeparator()));
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        this.numbers.forEach(e -> output.append(e.matches("^[0-9]+$") ? String.format("Calling... %s", e)
                : "Invalid number!").append(System.lineSeparator()));
        return output.toString().trim();
    }
}
