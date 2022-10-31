public class Human implements Essece {
    private int maxRun;
    private int maxJump;

    public Human() {
        this.maxRun = 50;
        this.maxJump = 1;
    }

    public String toString(){
        return "Human";
    }

    @Override
    public boolean run(int length) {
        if (length < 0) {
            System.out.println(toString() + "-");
            return false;
        } else if (length >= maxRun) {
            System.out.println(toString() +"-");
            return false;
        } else {
            System.out.println(toString() +"+");
            return true;
        }
    }

    @Override
    public boolean jump(int heigth) {
        if (heigth < 0) {
            System.out.println(toString() + "-");
            return false;
        } else if (heigth >= maxRun) {
            System.out.println(toString() +"-");
            return false;
        } else {
            System.out.println(toString() +"+");
            return true;
        }
    }
}