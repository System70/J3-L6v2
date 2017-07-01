import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test3db_MainClass {

    private static MainClass mc;

    @BeforeClass
    public static void init() {
        mc = new MainClass();
        MainClass.dbInit();
    }

    @Test
    public void test1_Add() {
        Assert.assertEquals(1, mc.dbAdd(MainClass.TEST_LASTNAME, 0));
    }

    @Test
    public void test2_Update() {
        Assert.assertEquals(1, mc.dbUpdate(MainClass.TEST_LASTNAME, MainClass.TEST_SCORE));
    }

    @Test
    public void test3_Delete() {
        Assert.assertEquals(1, mc.dbDelete(MainClass.TEST_LASTNAME));
    }

    @AfterClass
    public static void release() {
        MainClass.dbClose();
    }
}
