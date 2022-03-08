package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {

    private final ShampooRepository shampooRepository;
    private final IngredientService ingredientService;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public Runner(ShampooRepository shampooRepository, IngredientService ingredientService, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientService = ingredientService;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an exercise: ");
        int exercise = Integer.parseInt(scanner.nextLine());

        switch (exercise) {
            case 1:
                String sizeOfShampoo = scanner.nextLine();
                shampooRepository.findBySizeOrderByIdAsc(Size.valueOf(sizeOfShampoo))
                        .forEach(System.out::println);
                break;
            case 2:
                String size = scanner.nextLine();
                long labelId = scanner.nextLong();
                shampooRepository.findAllBySizeOrLabelIdOrderByPrice(Size.valueOf(size), labelId)
                        .forEach(System.out::println);
                break;
            case 3:
                BigDecimal price = scanner.nextBigDecimal();
                shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price)
                        .forEach(System.out::println);
                break;
            case 4:
                ingredientRepository.findByNameStartingWith("M")
                        .forEach(System.out::println);
                break;
            case 5:
                this.ingredientRepository
                        .findByNameInOrderByPriceAsc(List.of("Lavender", "Herbs", "Apple"))
                        .forEach(System.out::println);
                break;
            case 7:
                String first = scanner.nextLine();
                String second = scanner.nextLine();

                Set<String> names = Set.of(first, second);

                shampooRepository.findByIngredientsNames(names)
                        .forEach(s -> System.out.println(s.getBrand()));
                break;
        }

    }
}
