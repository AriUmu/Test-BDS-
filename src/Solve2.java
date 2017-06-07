import java.util.ArrayList;

/**
 * Created by arina on 07.06.17.
 */
public class Solve2 {

    public static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }

    public static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int middle = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < middle)
                i++;
            while (arr[j] > middle)
                j--;

            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }

        return i;
    }

    public static boolean resurch(int num, int[] arr, int left, int right) { //поиск бинарный
        if (left > right) return false;

        int middle = left + (right - left) / 2;

        if (num < arr[middle]) {    //в левой части
            return resurch(num, arr, left, middle - 1);
        } else if (num > arr[middle]) {    //в правой части
            return resurch(num, arr, middle + 1, right);
        } else {
            return true;
        }
    }

    /*
    Временная сложность N^2 + logN + N- в худшем случае;
    В лучшем случае (N + 1 )logN + N

     */

    public static void main(String[] args) {

        String line1 = "sis washed a windows";
        String line2 = "sister is looking for a cat";

        int arr1[] = new int[line1.length()];
        int arr2[] = new int[line2.length()];
        ArrayList<Integer> arrayList = new ArrayList();


        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = line1.charAt(i);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = line2.charAt(i);
        }

        quickSort(arr1, 0, arr1.length - 1); //отсортированный 1й массив

        for (int i = 0; i < arr2.length; i++) { //поиск чисел из 2го массива в первом
            if (resurch(arr2[i], arr1, 0, arr1.length-1)) {
                arrayList.add(arr2[i]);
            }
            for (int k = i + 1; k < arr2.length; k++) { //в первом массиве удаляем повторяющиеся элементы
                if (arr2[k] == arr2[i]) {
                    arr2[k] = -1;
                }
            }
        }

        arrayList.forEach((Integer k) -> System.out.print((char)k.intValue()));
    }
}
