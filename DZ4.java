import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/*1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и 
FileReader
2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и 
вывести в консоль в формате "Иванов И.И. 32 М"
3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, 
возрас и пол в отдельных списках.
4.Отсортировать по возрасту используя дополнительный список индексов. */

public class DZ4 {
    public static void main(String[] args) {
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();
        // try {
        // FileWriter writer = new FileWriter("bd.sql");
        // writer.append("Иванов Иван Иванович 32 м");
        // writer.flush(); // очищает буфер вывода, записывая все его содержимое
        // writer.close();
        // } catch (Exception e) {
        // //System.out.println(ex.getMessage());
        // }
        String str = "";
        try (FileReader reader = new FileReader("bd.sql")) {
            while (reader.ready()) {
                str += (char) reader.read();
            }
        } catch (IOException e) {         
        }
        System.out.println(str);
        String[] string = str.split("\n");
        for (int i = 0; i < string.length; i++) {
            String[] tmp = string[i].split(" ");
            family.add(tmp[0]);
            name.add(tmp[1]);
            soname.add(tmp[2]);
            age.add(Integer.valueOf(tmp[3]));
            gender.add(tmp[4].equals( "ж" ) ? false : true);
            index.add(i);
            System.out.println(tmp[0]+ " " + tmp[1].charAt(0)+ "." + tmp[2].charAt(0)+"."
            +" "+ tmp[3]+" "+tmp[4]);
        }
        ArrayList<Integer> temp = new ArrayList<>(age);
        temp.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < temp.size(); i++) {
            int t = age.indexOf(temp.get(i));
            index.set(i, t);
        }
        for (int i = 0; i < index.size(); i++) {
            System.out.print(family.get(index.get(i)) + " ");
            System.out.print(name.get(index.get(i)) + " ");
            System.out.print(soname.get(index.get(i)) + " ");
            System.out.print(age.get(index.get(i)).toString());
            System.out.println(gender.get(index.get(i))? "м" : "ж");
        }
    }
}
