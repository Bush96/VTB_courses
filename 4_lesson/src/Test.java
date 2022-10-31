import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Test {
    public static void main(String[] args) {
//        String[] forChange = {"1", "2", "3"};
//        transformation(forChange);
//        System.out.println();
//        substitution(forChange);

        addOrange();
        addApple();

        Box<Fruit> fruitOrange = new Box<>(addOrange());
        Box<Fruit> fruitApple = new Box<>(addApple());
//
        fruitOrange.getWeight();
        fruitApple.getWeight();

        fruitOrange.compare(fruitApple);

        fruitOrange.sprinkle(addApple());

        fruitOrange.getWeight();
        fruitApple.getWeight();


    }

    public static ArrayList<Fruit> addOrange() {
        ArrayList<Fruit> orangeBox = new ArrayList<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        return orangeBox;
    }

    public static ArrayList<Fruit> addApple() {
        ArrayList<Fruit> appleBox = new ArrayList<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        return appleBox;
    }

    public static void substitution(String[] arr) {                  //замена местами элементов массива
        Collections.swap(Arrays.asList(arr), 1, 2);
        System.out.println("Замена местами элементов массива: " + Arrays.toString(arr));
    }

    public static void transformation(String[] arr) {
        List<String> transformationList = new ArrayList();
        Collections.addAll(transformationList, arr);
        System.out.print("Преобразование массива в Лист: ");
        for (String str : transformationList)
            System.out.print(" " + str);

    }


}