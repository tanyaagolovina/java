package task82;

public class Runner {

    public static Integer value = 0;
    public static boolean flag = false;

    public void run(){
        /**
         * Creating new thread with lambda-statement,
         * where we define what the thread will do
         * Incrementing value by first thread, printing value by second thread.
         */
        new Thread( () -> {
            /**
             * Synchronized block by THIS to use construction wait-notify.
             *
             */
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    while(Runner.flag){
                        try{
                            wait();
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    Runner.value++;
                    flag = true;
                    notify();
                }
            }
        }).start();

        /**
         * Second synchronized block
         */

        new Thread( () -> {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    while (!Runner.flag) {
                        try{
                            wait();
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println(value);
                    flag = false;
                    notify();
                }
            }
        }).start();
    }
}
