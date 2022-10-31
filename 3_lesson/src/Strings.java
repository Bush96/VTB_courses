public class Strings {


    static void go(String[][] matr) {
        int sum = 0;

        if (matr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++) {
                try {
                    sum += Integer.parseInt(matr[i][j]);
                } catch (Exception e){
                    throw new MyArrayDataException();
                }
            }

        System.out.println("Сумма чисел массива " + sum);
    }
}
