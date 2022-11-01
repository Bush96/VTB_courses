import java.util.*;
import java.util.stream.Collectors;

public class SomeWords {
    public static void main(String[] args) {

        //////////////////1//////////////////

        String[] arr = {"A","B","C","D","B","C","C"};

        Set<String> strSet = Arrays.stream(arr).collect(Collectors.toSet());
        System.out.println("Список уникальных слов, из которых состоит массив: " + strSet);


        Map<String, Integer> counter = new HashMap<>();
        for (String x : arr) {
            int newValue = counter.getOrDefault(x, 0) + 1;
            counter.put(x, newValue);
        }
        System.out.println("Сколько раз встречается каждое слово: " + counter);
    }


}
