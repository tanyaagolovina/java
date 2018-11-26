package task84;

import java.util.concurrent.RecursiveTask;

public class SumOfNumbers {

    final static int NUM_OF_THREADS = 8;

    public static class RecSumOfNumb extends RecursiveTask<Long> {
        long from;
        long to;
        int[] array;

        public RecSumOfNumb(long from, long to, int[] array){
            this.from = from;
            this.to = to;
            this.array = array;
        }
        @Override
        protected Long compute() {
            if(to-from <= Runner.AMOUNT){
                long sum = 0;
                for (int number = (int)from; number < (int)to; number++) {
                    sum += array[number];
                }
                System.out.println("Sum from " + from + " to " + to + " = " + sum);
                return sum;
            } else {
                long middle = (from + to) / 2;
                System.out.println("Forking into 2 ranges: " + from +
                        " - " + middle + ", " + middle + " - " + to);
                RecSumOfNumb firstRecSumOfNumb = new RecSumOfNumb(from, middle, array);
                firstRecSumOfNumb.fork();
                RecSumOfNumb secondRecSumOfNumb = new RecSumOfNumb(middle+1, to, array);
                //secondRecSumOfNumb.fork();
                return firstRecSumOfNumb.join() + secondRecSumOfNumb.compute();
            }
        }
    }
}
