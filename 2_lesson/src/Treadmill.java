public class Treadmill implements Obstacle{
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean check(Essece essece) {
        if (essece.run(this.length)){
            System.out.println(essece.toString() + " пробежал");
            return true;
        }  else {
            System.out.println(essece.toString() + " не пробежал");
            return false;
        }

    }
}
