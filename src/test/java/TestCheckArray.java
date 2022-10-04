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
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {1, 1, 1, false},
                {4, 4, 4, false},
                {1, 4, 1, true}
        });
    }

    private int a;
    private int b;
    private int c;
    private boolean result;

    public TestCheckArray(int a, int b, int c, boolean result) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.result = result;
    }

    private CheckArray checkArray;

    @Before
    public void init(){
        checkArray = new CheckArray();
    }

    @Test
    public void massTestCheck(){
        Assert.assertEquals(result, checkArray.check(new int[] {a, b, c}));
    }
}
