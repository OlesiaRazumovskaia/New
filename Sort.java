package ShoppingList;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static String[] sortArray(String[] unsortedArray, int arrayLength) {
        String[] sortedArray = new String[arrayLength];
        System.arraycopy(unsortedArray, 0, sortedArray, 0, arrayLength);

        Arrays.sort(sortedArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        });

        return sortedArray;
    }
}
