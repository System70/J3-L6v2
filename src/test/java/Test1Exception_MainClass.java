import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

// 1. Create the set of tests to check throwing exceptions by method MainClass.getNumsAfter4()
// using some test data

@RunWith(Parameterized.class)
public class Test1Exception_MainClass extends Test1_MainClass {

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                { new int[] { 1, 2, 2, 3, 1, 7} },
                { new int[] { 1, 2, 3 } },
                { new int[] { 1, 2, 3, 5 } }
        });
    }

    public Test1Exception_MainClass(int[] srcArray) {
        super(srcArray, null);
    }

    @Test(expected = RuntimeException.class)
    public void MassTestException_getNumsAfter4() {
        Assert.assertArrayEquals(null, mc.getNumsAfter4(srcArray));
    }

    @Test
    @Ignore
    public void MassTest_getNumsAfter4() {
        //
    }

}
