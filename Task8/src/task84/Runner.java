package task84;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Runner {

    final static long COUNT = 1_000_000L;
    final static int AMOUNT = 20;
    public void run(){

        int [] arrayInt = createArray(COUNT);

        new Thread( () -> {
            for (int number: arrayInt ) {
                System.out.println(number);
            }
            ForkJoinPool pool = new ForkJoinPool(SumOfNumbers.NUM_OF_THREADS);
            long result = pool.invoke(new SumOfNumbers.RecSumOfNumb(0, COUNT, arrayInt));
            System.out.println("Result = " + result);
        }).start();
    }

    private int[] createArray(long size){

        int[] tempArr = new int[(int)size];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = new Random(i).nextInt(100);
        }
        return tempArr;
    }
}
