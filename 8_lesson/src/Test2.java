
import java.util.Arrays;
import java.util.stream.Stream;

public class Test2 {

    public static void main(String[] args) {
        Person[] arg = {new Person("Bob", 22, 100),
                new Person("Ban", 25, 200),
                new Person("Larry", 32, 250),
                new Person("Artur", 44, 150)};

        System.out.println(Arrays.stream(arg).mapToDouble(Person::getSalary).average());

    }
}
