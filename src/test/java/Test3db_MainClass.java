import org.junit.*;
import org.junit.runners.MethodSorters;
import java.sql.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test3db_MainClass {

    private static MainClass mc;

    private static Connection connection;
    private static Statement statement;

    private static PreparedStatement psAdd;
    private static PreparedStatement psUpdate;
    private static PreparedStatement psDelete;

    public static String TEST_LASTNAME = "test_last_name";
    public static int TEST_SCORE = 999;

    @BeforeClass
    public static void init() {
        mc = new MainClass();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:students.sqlite");
            connection.setAutoCommit(false);
            psAdd = connection.prepareStatement("INSERT INTO students (lastname, score) VALUES (?, ?)");
            psUpdate = connection.prepareStatement("UPDATE students SET score = ? WHERE lastname = ?");
            psDelete = connection.prepareStatement("DELETE from students WHERE lastname = ?");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1_Add() {
        try {
            psAdd.setString(1, TEST_LASTNAME);
            psAdd.setInt(2, 0);
            Assert.assertEquals(1, psAdd.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2_Update() {
        try {
            psUpdate.setInt(1, TEST_SCORE);
            psUpdate.setString(2, TEST_LASTNAME);
            Assert.assertEquals(1, psUpdate.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3_Delete() {
        try {
            psDelete.setString(1, TEST_LASTNAME);
            Assert.assertEquals(1, psDelete.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void release() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
