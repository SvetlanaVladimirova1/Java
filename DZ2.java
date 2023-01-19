/* Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
*Напишите программу, чтобы перевернуть строку с помощью рекурсии.
Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
**Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
*/
public class DZ2 {
    
    public static void main(String[] args) {

       String s1 = "Hello";
       String s2 = "olleH";
       System.out.println(s1.contains(s2));
       System.out.println(s1.contains(new StringBuilder(s2).reverse().toString()));

       int num1 = 3;
       int num2 = 56;
       int num3 = num1 + num2;
       int num4 = num1 - num2;
       int num5 = num1 * num2;
       
       String s3 = String.valueOf(num1) + "+" + String.valueOf(num2) + "=" + String.valueOf(num3);
       System.out.println(s3);
       String s4 = String.valueOf(num1) + "-" + String.valueOf(num2) + "=" + String.valueOf(num4);
       System.out.println(s4);
       String s5 = String.valueOf(num1) + "*" + String.valueOf(num2) + "=" + String.valueOf(num5);
       System.out.println(s5);

       
       StringBuilder sb1 = new StringBuilder(s3).deleteCharAt(4).insert(4, "равно");
       StringBuilder sb2 = new StringBuilder(s4).deleteCharAt(4).insert(4, "равно");
       StringBuilder sb3 = new StringBuilder(s5).deleteCharAt(4).insert(4, "равно");

       System.out.println(s3.replace("=", "равно"));
       System.out.println(s4.replace("=", "равно"));
       System.out.println(s5.replace("=", "равно"));

       StringBuilder sb4 = new StringBuilder(s3).replace(4, 5, "равно");
       StringBuilder sb5 = new StringBuilder(s4).replace(4, 5, "равно");
       StringBuilder sb6 = new StringBuilder(s5).replace(4, 5, "равно");

       System.out.println(sb1);
       System.out.println(sb2);
       System.out.println(sb3);
       System.out.println(sb4);
       System.out.println(sb5);
       System.out.println(sb6);

       double b = System.currentTimeMillis();
       String str = "=";
       str.replace("=", "равно");
       for (int index = 0; index < 10000; index++) {
            str += str(index);
       }
       //System.out.println(str);
       System.out.println(System.currentTimeMillis()-b);

        b = System.currentTimeMillis();
        StringBuilder a = new StringBuilder("=").replace(0, 1, "равно");
        for (int index = 0; index < 10000; index++) {
             a.append(str(index));
        }
        //System.out.println(a);
        System.out.println(System.currentTimeMillis()-b);
    }

    private static Object str(int index) {
        return "равно";
    }
}
