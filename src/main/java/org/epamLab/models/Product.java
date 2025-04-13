package org.epamLab.models;

public class Product {

    private final String name;
    private final String price;
    private final String description;
    private final String recipe;

    public Product(String name, String price, String description, String recipe) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", recipe='" + recipe + '\'' +
                '}';
    }
}
