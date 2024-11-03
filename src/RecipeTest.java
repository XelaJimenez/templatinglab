import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void addIngredient() {
        Recipe<Ingredient> recipe = new Recipe<>("Cake", "mix well");
        Ingredient ingredient = new SolidIngredient("Sugar", 10);
        recipe.addIngredient(new SolidIngredient("sugar", 10));
        assertEquals("Sugar", ingredient.getName(), "The first ingredient should be Sugar.");
    }

    @Test
    void print() {

    }
}