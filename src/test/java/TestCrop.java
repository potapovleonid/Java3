import home.des.example.lesson5.ArrayCrop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCrop {

    private ArrayCrop arrayCrop;

    @Before
    public void init(){
        arrayCrop = new ArrayCrop();
    }

    @Test
    public void testTask1(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assert.assertArrayEquals(new int[] {1,7}, arrayCrop.crop(4, arr));
    }

    @Test
    public void testTask2(){
        int[] arr = {1, 2, 4, 4, 2, 3, 5, 1, 7};
        Assert.assertArrayEquals(new int[] {2, 3, 5, 1, 7}, arrayCrop.crop(4, arr));
    }

    @Test(expected = RuntimeException.class)
    public void testTask3(){
        int[] arr = {1, 2, 0, 2, 2, 3, 5, 1, 7};
        arrayCrop.crop(4, arr);
    }

}
