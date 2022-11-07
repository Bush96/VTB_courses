import java.util.Arrays;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        int N =2;
        Person[] arg = {new Person("Bob", 22, 100),
                new Person("Ban", 25, 200),
                new Person("Larry", 32, 250),
                new Person("Artur", 44, 150)};


        Arrays.stream(arg).sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(N).map(Person::getAge)
                .collect(Collectors.joining(" ,",N+""," !!"))                //???????
    }
}
