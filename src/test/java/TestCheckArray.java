import home.des.example.lesson5.ArrayCrop;
import home.des.example.lesson5.CheckArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCheckArray {

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1}, false},
                {new int[]{4, 4, 4}, false},
                {new int[]{1, 4, 1}, true}
        });
    }

    private int[] array;
    private boolean result;

    public TestCheckArray(int[] array, boolean result) {
        this.array = array;
        this.result = result;
    }

    private CheckArray checkArray;

    @Before
    public void init() {
        checkArray = new CheckArray();
    }

    @Test
    public void massTestCheck() {
        Assert.assertEquals(result, checkArray.check(array));
    }
}
