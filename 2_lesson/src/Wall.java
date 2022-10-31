public class Wall implements Obstacle{
    private int heigth;

    public Wall(int heigth) {
        this.heigth = heigth;
    }

    @Override
    public boolean check(Essece essece) {
        if (essece.run(this.heigth)){
            System.out.println(essece.toString() + "прошел");
            return true;
        }  else {
            System.out.println(essece.toString() + "не прошел");
            return false;
        }

    }
}

