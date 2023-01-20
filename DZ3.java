/*1 Объявить два списка список ArrayList, в каждый добавить по 20 случайных чисел. 
Удалить из первого списка элементы отсутствующие во втором списке. Отсортировать первый список 
методом sort класса Collections.
2 * Отсортировать второй список методом sort списка и компаратором по уменьшению.
3 **Отсортировать первый список пузырьковой сортировкой самостоятельно, без использования доп методов и 
классов. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class DZ3 {

    public static void main(String[] args) {
    ArrayList<Integer> l1 = new ArrayList<>();
    ArrayList<Integer> l2 = new ArrayList<>();
    Random rnd = new Random();
    for (int index = 0; index < 20; index++) {
        l1.add(rnd.nextInt(100)); 
    }
    for (int index = 0; index < 20; index++) {
        l2.add(rnd.nextInt(100));
    }
    System.out.println(l1);
    System.out.println();
    System.out.println(l2);
    System.out.println();

    l1.retainAll(l2);
    System.out.println(l1);
    System.out.println();
    Collections.sort(l1);
    System.out.println(l1);
    System.out.println();

    l2.sort(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            
            return o2-o1;
        } 
    });
    System.out.println(l2);
    
    }       
}
