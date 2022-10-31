public class Cat implements Essece {
    private int maxRun;
    private int maxJump;

    public Cat() {
        this.maxRun = 200;
        this.maxJump = 3;
    }

    public String toString(){
        return "Cat";
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


