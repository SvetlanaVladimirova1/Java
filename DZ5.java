/*Создать словарь HashMap. Обобщение <Integer, String>.
Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключь, если не было!)
Изменить значения сделав пол большой буквой.
Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
*Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
public class DZ5 {
    public static void main(String[] args) {
        HashMap <Integer, String> hm = new HashMap<>();
        hm.putIfAbsent(1, "Иванов Иван Иванович 32 м");
        hm.put(2, "Петров Максим Сидорович 38 м" );
        hm.put(3, "Сидоров Петр Петрович 23 м");
        hm.put(4, "Максимова Ольга Васильевна 44 ж");
        hm.put(5, "Дмитриева Мария Михайловна 10 ж");
        hm.forEach((k, v) -> System.out.println(k+" "+v));
        System.out.println();
        Collection<String> sValues = hm.values();
        Set<Integer> keySet = hm.keySet();
        for (int i = 0; i < keySet.size(); i++) {
            String[] tmp = ((String) sValues .toArray()[i]).split(" ");
            System.out.println(tmp[0]+ " " + tmp[1].charAt(0)+ "." + tmp[2].charAt(0));
            hm.compute((Integer)keySet.toArray()[i], (k, v) -> v = v.replace(" м"," М"));
            hm.compute((Integer)keySet.toArray()[i], (k, v) -> v = v.replace(" ж"," Ж"));
        }   
        System.out.println();
         hm.forEach((k, v) -> System.out.println(k+". "+v));
    }
}
