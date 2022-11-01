import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {

    //////////////////2//////////////////
    public static void main(String[] args) {

        Map<String, List<Integer>> book = new HashMap<String, List<Integer>>();

        List<Integer> mike = new ArrayList<>();
        mike.add(12313);
        mike.add(342342);

        List<Integer> bob = new ArrayList<>();
        bob.add(12313);


        List<Integer> karolina = new ArrayList<>();
        karolina.add(12313);


        book.put("Mike", mike);
        book.put("Bob", bob);
        book.put("Karolina", karolina);

        System.out.println(book.get("Mike"));
        System.out.println(book.get("Bob"));
        System.out.println(book.get("Karolina"));

    }
}