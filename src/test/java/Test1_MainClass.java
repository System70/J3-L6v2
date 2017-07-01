import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

// 1. Create a set of tests for method MainClass.getNumsAfter4() using some test data

@RunWith(Parameterized.class)
public class Test1_MainClass {

    @Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                { new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[] { 1, 7 } },
                { new int[] { 4, 1, 2, 3 }, new int[] { 1, 2, 3 } },
                { new int[] { 4, 1, 2, 3, 4 }, new int[] {} },
                { new int[] { 1, 2, 3, 4, 5 }, new int[] { 5 } }
        });
    }

    protected int[] srcArray;
    protected int[] dstArray;
    protected MainClass mc;

    public Test1_MainClass(int[] srcArray, int[] dstArray) {
        this.srcArray = srcArray;
        this.dstArray = dstArray;
    }

    @Before
    public void init() {
        this.mc = new MainClass();
    }

    @Test
    public void MassTest_getNumsAfter4() {
        Assert.assertArrayEquals(dstArray, mc.getNumsAfter4(srcArray));
    }
}
