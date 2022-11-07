import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    //    Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
//встречающееся;
    public static void main(String[] args) {
        String[] arr = {"God", "Dog", "Boy", "Toy", "Boy"};
        List<String> list = Arrays.asList(arr);

        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));

        System.out.println(map);


    }
}