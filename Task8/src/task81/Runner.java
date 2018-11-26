package task81;

public class Runner {

    public void run(){
        /**
         * Creating thread with lambda-statement
         */
        new Thread( () -> {
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("BOMB");
        }).start();
    }
}
