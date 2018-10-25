import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Parametrized run. Exist to test methods with different parameters(array with data 2:2).
 */
@RunWith(Parameterized.class)
public class TestTemperatureConverter {
    private static TemperatureConverter converter;
    @Parameterized.Parameter //with this annotation we can avoid using constructor, but fields should be public
    public double temperatureC;
    @Parameterized.Parameter(1)
    public double temperatureK;
    @Parameterized.Parameter(2)
    public double temperatureF;

   /* public TestTemperatureConverter(double temperatureC, double temperatureK, double temperatureF) {
        this.temperatureC = temperatureC;
        this.temperatureK = temperatureK;
        this.temperatureF = temperatureF;
    }*/

    /**
     * Getting parameters.
     * @return Collection of parameters. From array to list.
     */
    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {0.0, 273.2, 32.0},
                {-100.0, 173.2, -148.0},
                {-273.2, 0.0, -459.76},
                {273.2, 546.4, 523.76}
        });
    }

    /**
     * This method will be called before test methods once.
     */
    @BeforeClass
    public static void init(){
        converter = new TemperatureConverter();
    }

    @Test
    public void testConvertCtoK(){
        double result = converter.convertCtoK(temperatureC);
        /**
         * Method of diagnostic.
         */
        Assert.assertEquals(temperatureK, result, 0.01);
    }

    @Test
    public void testConvertKtoC(){
        double result = converter.convertKtoC(temperatureK);
        Assert.assertEquals(temperatureC, result, 0.01);
    }
}
