package Articles2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfArticles = Integer.parseInt(scanner.nextLine());

        List<Article2> articleInformation = new ArrayList<>();

        for (int i = 0; i < numberOfArticles; i++) {
            String input = scanner.nextLine();
            String[] articleData = input.split(",\\s+");
            String title = articleData[0];
            String content = articleData[1];
            String author = articleData[2];

            Article2 article = new Article2(title, content, author);
            articleInformation.add(article);
            System.out.println();
        }

        String sortBy = scanner.nextLine();

        if (sortBy.equals("title")){
            articleInformation.stream().sorted(Comparator.comparing(Article2::getTitle)).forEach(data -> System.out.println(data.output()));
        }else if (sortBy.equals("content")){
            articleInformation.stream().sorted(Comparator.comparing(Article2::getContent)).forEach(data -> System.out.println(data.output()));
        }else if (sortBy.equals("author")){
            articleInformation.stream().sorted(Comparator.comparing(Article2::getAuthor)).forEach(data -> System.out.println(data.output()));
        }
    }
}
