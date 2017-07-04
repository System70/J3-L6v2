import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

// 2. Create a set of tests for method MainClass.isArrayContains1or4 using some test data

@RunWith(Parameterized.class)
public class Test2_MainClass extends Test1_MainClass {

    @Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                { false, new int[] { 1, 2, 4, 4, 2, 3, 4, 1, 7} },
                { true, new int[] { 4, 1, 1, 4 } },
                { false, new int[] { 0, 9, 2, 3, 4 } },
                { true, new int[] { 1, 1, 4, 4, 1 } },
                { false, new int[] { 1, 1, 1, 1 } },
                { false, new int[] { 4, 4, 4 } },
                { false, new int[] { } }
        });
    }

    private boolean expectedResult;

    public Test2_MainClass(boolean expectedResult, int[] srcArray) {
        super(srcArray, null);
        this.expectedResult = expectedResult;
    }

    @Test
    public void MassTest_isArrayContains1or4() {
        if (expectedResult)
            Assert.assertTrue(mc.isArrayContains1or4(srcArray));
        else
            Assert.assertFalse(mc.isArrayContains1or4(srcArray));
    }

    @Test
    @Ignore
    public void MassTest_getNumsAfter4() {
        //
    }
}
