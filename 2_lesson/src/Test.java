
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Treadmill(100));
        obstacles.add(new Wall(4));

        List<Essece> esseces = new ArrayList<>();
        esseces.add(new Human());
        esseces.add(new Cat());

        for (Essece e:esseces){
           for( Obstacle o:obstacles){
               if (!o.check(e)) break;
           }
        }
    }}
