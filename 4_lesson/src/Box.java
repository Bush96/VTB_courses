import java.util.ArrayList;


public class Box<T extends Fruit> {
    private ArrayList<Fruit> T;

    public Box(ArrayList<Fruit> T) {
        this.T = T;
    }

    public float getWeight() {
        float sum = 0f;
        for (Fruit fruit : T) {
            sum = fruit.weight() + sum;
        }
        System.out.println("Общий вес фруктов в коробке: "+T.toString() + " " + sum);
        return sum;
    }

    public boolean compare(Box<T> another) {

        System.out.println("Результат сравнения: ");
        if (this.getWeight() == another.getWeight()) {
            System.out.println("Вес коробок равен");
        } else System.out.println("Вес коробок не равен");

        return true;
    }

    public void sprinkle(ArrayList<Fruit> another) {
        System.out.println("Пересыпаем содержимое: ");
           T.addAll(another);
           another.clear();

    }


}
