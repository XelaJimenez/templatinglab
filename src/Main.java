
import java.util.*;

interface Ingredient {
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient {
    private String _name;
    private double _quantityGram; //unique name needed
    public SolidIngredient(String name, double quantity) {
        _name = name;
        _quantityGram = quantity;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantityGram;
    }
}
class LiquidIngredient implements Ingredient {
    private String _name;
    private double _quantityInMl; // different name from previous class needed
    public LiquidIngredient(String name, double quantity) {
        _name = name;
        _quantityInMl = quantity;
    }
    public String getName() {
        return _name;
    }
    public double getQuantity() {
        return _quantityInMl;
    }
}
// class recipe is not implementing  the interface; rather, constraint on the type var
class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    // dont pass in arraylist bc we want the class to own it
    public Recipe(String name, String instructions) {
        _name = name;
        _instructions = instructions;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T item) {
        _ingredients.add(item);
    }
    public void print() {
        System.out.println("Name: " + _name);
        System.out.println("Instructions: " +_instructions);
        System.out.println("Ingredients: ");
        for (T t : _ingredients) {
            System.out.println("Name: " + t.getName() + " Quantity: " + t.getQuantity());
        }
    }
}
public class Main {
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner scan) {
        System.out.println("Is the ingredient solid (s) or liquid (l): ");
        char type = scan.nextLine().charAt(0);
        System.out.println("Enter the ingredient name: ");
        String name = scan.nextLine();
        System.out.println("Enter quantity: ");
        double quantity = Double.parseDouble(scan.nextLine());
        Ingredient ingredient;
        if (type == 's') {
            ingredient = new SolidIngredient(name, quantity);
        }
        else {
            ingredient = new LiquidIngredient(name, quantity);
        }
        recipe.addIngredient(ingredient);
    }
    public static int Menu(Scanner scan) {
        System.out.println("Recipe Menu");
        System.out.println("Add ingredient (Enter 1)");
        System.out.println("List all ingredients (Enter 2)");
        System.out.println("Exit (Enter 3)");
        System.out.print("Enter Choice Here: ");
        int choice = 3;
        String userInput = scan.nextLine();
        try {
            choice = Integer.parseInt(userInput);
        } catch(Exception e) {
            System.exit(-1);
        }
        return choice;
    }
    public static void main(String[] args) {
        ArrayList<Ingredient> stuff = new ArrayList<>();
        Recipe<Ingredient> recipe;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an ingredient name: ");
        String name = scan.nextLine();
        System.out.println("Enter instructions: ");
        String instructions = scan.nextLine();
        recipe = new Recipe<Ingredient>(name, instructions);

        int userInput = Menu(scan);
        while(userInput != 3) {
            switch (userInput) {
                case 1 -> addIngredient(recipe, scan);
                case 2 -> recipe.print();
                default -> System.out.println("Invalid Option Entered - Try again");
            }
            userInput = Menu(scan);
        }
        scan.close();
    }
}