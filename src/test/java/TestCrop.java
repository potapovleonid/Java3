import home.des.example.lesson5.ArrayCrop;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCrop {

    private final int CROP_ELEMENT = 4;

    @Parameterized.Parameters
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {new int[] {1,7}, new int[] {1, 2, 4, 4, 2, 3, 4, 1, 7}},
                {new int[] {2, 3, 5, 1, 7}, new int[] {1, 2, 4, 4, 2, 3, 5, 1, 7}},
                {new int[] {7, 2, 7}, new int[] {1, 2, 4, 4, 2, 4, 7, 2, 7}},
                {new int[] {2, 7, 1, 2, 3, 5, 1, 7}, new int[] {4, 2, 7, 1, 2, 3, 5, 1, 7}}
        });
    }

    private int[] result;
    private int[] array;

    public TestCrop(int[] result, int[] array) {
        this.result = result;
        this.array = array;
    }

    private ArrayCrop arrayCrop;

    @Before
    public void init(){
        arrayCrop = new ArrayCrop();
    }

    @Test
    public void massTest(){
        Assert.assertArrayEquals(result, arrayCrop.crop(CROP_ELEMENT, array));
    }

    @Test(expected = RuntimeException.class)
    public void testEmptyList(){
        Assert.assertEquals(new int[] {}, arrayCrop.crop(CROP_ELEMENT, new int[] {1, 2, 0, 2, 2, 3, 5, 1, 7}));
    }

}
