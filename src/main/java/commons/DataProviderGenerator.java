package commons;

import java.util.Arrays;
import java.util.List;

public class DataProviderGenerator {

    private static Object[][] objectifiedData;

    public static Object[][] generateVariants(List<?>... lists) {

        int[] size = new int[lists.length];
        int counter = 0;

        for (List lst : lists) {
            size[counter] = lst.size();
            counter++;

        }
        int arraylength = 1;
        for (int i = 0; i < size.length; i++) {
            arraylength = arraylength * size[i];
        }

        int[] resetthreshhold = new int[lists.length];
        int newarrlength = 1;

        int temp = 1;
        for (int i = 0; i < lists.length; i++) {
            newarrlength = newarrlength * size[i];
            resetthreshhold[i] = arraylength / newarrlength;
        }


        Object[][] returnval = new Object[arraylength][lists.length];
        int column = 0, row = 0, itr = 0, itemindex = 0, counter1 = 0, index = 0;
        Object value = "";
        int totallists = lists.length;
        System.out.println("totallists = " + totallists);
        for (List lst : lists) {
            counter1 = 0;
            index = 0;
            itr = resetthreshhold[itemindex];
            for (int i = 0; i < arraylength; i++) {
                if (counter1 == itr) {
                    counter1 = 0;
                    index++;

                }
                if (index >= lst.size()) {
                    index = 0;
                }
                value = lst.get(index);
                returnval[i][column] = value;
                counter1++;
            }
            column++;
            itemindex++;
        }
        objectifiedData = returnval;
        printArray(objectifiedData);
        return returnval;
    }

    private static void printArray(Object[][] objectarray) {
        for (Object[] arr : objectarray) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
