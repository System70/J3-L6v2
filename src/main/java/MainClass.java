import java.sql.*;

public class MainClass {

    private static Connection connection;
    private static Statement statement;

    private static PreparedStatement psAdd;
    private static PreparedStatement psUpdate;
    private static PreparedStatement psDelete;

    public static String TEST_LASTNAME = "test_last_name";
    public static int TEST_SCORE = 999;


    public static void main(String[] args) {

        /*
        dbInit();
        MainClass mc = new MainClass();
        System.out.println(mc.dbAdd(TEST_LASTNAME, 0));
        System.out.println(mc.dbUpdate(TEST_LASTNAME, TEST_SCORE));
        System.out.println(mc.dbDelete(TEST_LASTNAME));
        dbClose();
        */

    }

    // 1. Create method returning subarray copied from source array starting with next element
    // after last '4'. If there are no 4s in sorce Array method must throw runtime exception
    public int[] getNumsAfter4(int[] srcArray) {
        int i = -1, j;
        for (j = srcArray.length - 1; j >= 0; j--)
            if (srcArray[j] == 4) {
                i = j + 1;
                break;
            }
        if (j < 0)
            throw new RuntimeException("No 4s in srcArray");
        int[] dstArray = new int[srcArray.length - i];
        System.arraycopy(srcArray, i, dstArray, 0, srcArray.length - i);
        return dstArray;
    }

    // 2. Create method checking given array contains only 1s & 4s
    public boolean isArrayContains1or4(int[] srcArray) {
        if (srcArray.length == 0)
            return false;
        for (int i = 0; i < srcArray.length; i++)
            if (srcArray[i] !=1 && srcArray[i] != 4)
                return false;
        return true;
    }

    // 3. Methods to perform database tasks
    public static void dbInit() {
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

    public static void dbClose() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int dbAdd(String lastName, int score) {
        int affectedRows = 0;
        try {
            psAdd.setString(1, lastName);
            psAdd.setInt(2, score);
            affectedRows = psAdd.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int dbUpdate(String lastName, int score) {
        int affectedRows = 0;
        try {
            psUpdate.setInt(1, score);
            psUpdate.setString(2, lastName);
            affectedRows = psUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public int dbDelete(String lastName) {
        int affectedRows = 0;
        try {
            psDelete.setString(1, lastName);
            affectedRows = psDelete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }
}
