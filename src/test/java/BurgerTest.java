import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();


    @Test
    public void setBunsTest () {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest () {
        burger.addIngredient(ingredient);
        Assert.assertNotNull(burger.ingredients);
    }

    @Test
    public void removeIngredientTest () {
        int expected = burger.ingredients.size();
        burger.addIngredient(ingredient);
        burger.removeIngredient(burger.ingredients.size()-1);
        Assert.assertEquals(expected, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest () {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Ап", 34);
        Ingredient newIngredient = new Ingredient(SAUCE, "Оп", 26);
        List<Ingredient> expected = List.of(newIngredient, ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0,1);
        List<Ingredient> actual = burger.ingredients;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest () {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(1f);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getPrice()).thenReturn(1f);
        float actual = burger.getPrice();
        float expected = 3f;
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Краторная булка");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("традиционный галактический");
        Mockito.when(bun.getPrice()).thenReturn(150F);
        Mockito.when(ingredient.getPrice()).thenReturn(150F);
        burger.getPrice();

        String expectedReceipt = "(==== Краторная булка ====)\r\n" +
                "= sauce традиционный галактический =\r\n" +
                "(==== Краторная булка ====)\r\n" +
                "\r\n" +
                "Price: 450,000000\r\n";

        String actualReceipt = burger.getReceipt();

        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

}
