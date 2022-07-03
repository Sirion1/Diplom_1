import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void bunGetNameTest () {
        String exptectedName = "Булочка";
        float expectedPrice = 12;
        Bun bun = new Bun(exptectedName,expectedPrice);
        String actualBunGetName = bun.getName();
        Assert.assertEquals(exptectedName, actualBunGetName);
    }


    @Test
    public void bunGetPriceTest () {
        float expectedPrice = 12;
        Bun bun = new Bun(null, expectedPrice);
        float actualBunGetPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualBunGetPrice, 0);
    }
}
