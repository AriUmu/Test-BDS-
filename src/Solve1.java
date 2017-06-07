import java.util.HashSet;

/**
 * Created by arina on 07.06.17.
 */
public class Solve1 {
/*
Временная сложность N^2 + N - в худшем случае;
В лучшем случае N

Второй вариант - Solve2
 */

    public static void main(String[] args) {
        String line1 = "sis washed a windows";
        String line2 = "sister if looking for a cat";

        char arr1[] = new char[line1.length()];
        char arr2[] = new char[line2.length()];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = line1.charAt(i);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = line2.charAt(i);
        }

        HashSet<Character> hashSet = new HashSet();

        for (int i = 0; i <arr1.length ; i++) {

            for (int j = 0; j < arr2.length ; j++) {
                if(arr1[i] == (arr2[j]) && arr1[i] != -1){
                    hashSet.add(arr2[j]); //добавили символ
                }
            }for (int k = i+1; k < arr1.length ; k++) { //в первом массиве удаляем повторяющиеся элементы
                if(arr1[k] == arr1[i]){
                    arr1[k] = (char) -1;
                }
            }
        }

        System.out.println();
        hashSet.forEach(System.out::print);

    }

}
