import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

 Ingredient ingredient;

    @Before
    public void newOrderSetup() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соус соусович", 50);
    }

    @Test
    public void getPriceTest() {
        float expected = 50;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        String expected = "Соус соусович";
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }

}
