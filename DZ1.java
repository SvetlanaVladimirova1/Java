/**
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */
import java.util.Arrays;
import java.util.Random;
public class DZ1 {
    public static void main(String[] args) {
        
        Random rnd = new Random();
        int i = rnd.nextInt(2001);
        System.out.println(i);
        int m = Integer.highestOneBit(i);
        System.out.println(m);
        
        int index = 1, num = 1;
        while (num != m) {
             num *= 2;
             index++; 
        }      
        System.out.println(index);
        int s=0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
                if (j  % index == 0) { 
                    s+=1;
           }    
        }
        int[] m1 = new int [s]; 
        s=0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j  % index == 0) { 
                        m1[s] = j;
                        s+=1;
                    }                
        }
        System.out.println(Arrays.toString(m1));
        
        int s1=0;
        for (int k = Short.MIN_VALUE; k < i; k++) {
                if (k  % index != 0) { 
                    s1+=1;
           }    
        }
        int[] m2 = new int [s1]; 
        s1=0;
        for (int k = Short.MIN_VALUE; k < i; k++) {
                    if (k  % index != 0) { 
                        m2[s1] = k;
                        s1+=1;
                    }                
        }
        System.out.println(Arrays.toString(m2));
    }
}