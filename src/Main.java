import java.util.*;

interface Ingredient {
    public String getName();
    public double getQuantity();
}
class SolidIngredient implements Ingredient {
    private String _name;
    private double _quantity;
    public SolidIngredient(String name, double quantity) {
        _name = name;
        _quantity = quantity;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class LiquidIngredient implements Ingredient {
    private String _name;
    private double _quantity;
    public LiquidIngredient(String name, double quantity) {
        _name = name;
        _quantity = quantity;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String name, String instructions, ArrayList<T> ingredients) {
        _name = name;
        _instructions = instructions;
        _ingredients = ingredients;
    }
    public void addIngredient(T item) {
        _ingredients.add(item);
    }
    public void print() {
        System.out.println(_ingredients);
    }
}
public class Main {
    public static void main(String[] args) {


    }
}