package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(){
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Company:").append("\n");
        if (company != null){
            stringBuilder.append(company.toString()).append("\n");
        }

        stringBuilder.append("Car:").append("\n");
        if (car != null){
            stringBuilder.append(car.toString()).append("\n");
        }

            stringBuilder.append("Pokemon:").append("\n");
            for (Pokemon pokemon: pokemons) {
                stringBuilder.append(pokemon.toString());
        }

            stringBuilder.append("Parents:").append("\n");
            for (Parent parent: parents) {
                stringBuilder.append(parent.toString());
        }


            stringBuilder.append("Children:").append("\n");
            for (Child child: children) {
                stringBuilder.append(child.toString());
        }

        return stringBuilder.toString();
    }
}
