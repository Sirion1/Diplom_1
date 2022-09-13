import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

        Database database = new Database();

        @Test
        public void availableBunsCheck() {
            List<Bun> actual = database.availableBuns();
           Assert.assertNotNull(actual);
        }

        @Test
        public void availableIngredientsCheck() {
            List<Ingredient> actual = database.availableIngredients();
            assertNotNull(actual);
        }
    }

