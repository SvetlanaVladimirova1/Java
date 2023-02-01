/*Разработать программу, имитирующую поведение коллекции 
HashSet. В программе содать метод add добавляющий элемент,
 и метод позволяющий выводить эллементы коллекции в консоль.
 Формат данных Integer. */
import java.util.HashMap;   
public class DZ6 {
    private static HashMap<Integer,Integer> hm  = new HashMap<>();
    public static void main(String[] args) {
        add(50);
        add(50);
        add(50);
        add(5);
        add(44);
        add(15);
        add(50);   
        System.out.println(getStr());   
    }
    private static String getStr() {
        return hm.keySet().toString();
    }
    private static void add(Integer num) {
        hm.put(num, num);
    }    
}
