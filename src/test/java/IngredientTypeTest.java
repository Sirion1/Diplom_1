import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

        public String type;
        public boolean expectedResult;

        public IngredientTypeTest(String type, boolean expected) {
            this.type = type;
            this.expectedResult = expected;
        }

        @Parameterized.Parameters
        public static Object[][] hasIngredientType() {
            return new Object[][]{
                    {"FILLING", true},
                    {"SAUCE", true},
                    {"Томатный сок", false},
                    {" ", false},
                    {"", false},
                    {null, false}
            };
        }

        @Test
        public void testIngredientType() {
            boolean actualResult = true;
            try {
                String expected = type;
                String actual = IngredientType.valueOf(type).toString();
                Assert.assertEquals(expected, actual);
            } catch (IllegalArgumentException | NullPointerException exception) {
                actualResult = false;
            }
            Assert.assertEquals(expectedResult, actualResult);
        }
    }

