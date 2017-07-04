
public class MainClass {

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
        boolean b1 = false, b4 = false;
        for (int i = 0; i < srcArray.length; i++) {
            if (srcArray[i] == 1) b1 = true;
            if (srcArray[i] == 4) b4 = true;
            if (srcArray[i] != 1 && srcArray[i] != 4)
                return false;
        }
        return b1 & b4;
    }
}
