public class Test {

    public static void main(String[] args) {
        exersize1();
        exersize2();
    }

    public static void exersize1() {
        final int size = 10000000;


        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }

        long b = System.currentTimeMillis();

        System.out.println(b - a);

    }

    public static void exersize2() {
        final int size = 10000000;
        final int half = size / 2;

        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        float[] arr2 = new float[half];
        System.arraycopy(arr, 0, arr2, 0, half);
        System.arraycopy(arr, 0, arr2, 0, half);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                        Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr2, 0, arr, 0, half);
        System.arraycopy(arr2, 0, arr, 0, half);

        long b = System.currentTimeMillis();

        System.out.println(b - a);

    }
}


