package task83;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {

    Map<Integer, Integer> map;
    final int COUNT = 10000;
    public void run() {

        testHashMap();
        testConcurrentHashMap();
    }

    private void testHashMap(){
        map = new HashMap<>();
        Thread[] threadsWrite = new Thread[COUNT];
        Thread[] threadsRead = new Thread[COUNT];
        for (int i = 0; i < COUNT; i++) {
            int temp = i;
            threadsWrite[i] = new Thread( () -> {
                synchronized (this.map) {
                    map.put(temp, temp);
                }
            });
            threadsRead[i] = new Thread( () -> {
               synchronized (this.map) {
                    map.get(temp);
                    //System.out.println(map.get(temp));
                }
            });
        }

        long start = System.nanoTime();
        //Start of threads
        for (int i = 0; i < COUNT; i++) {
            threadsWrite[i].start();
            threadsRead[i].start();
        }
        for (int i = 0; i < COUNT ; i++) {
            try {
                threadsWrite[i].join();
                threadsRead[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println("\n Time = " + (end - start)/1000000000.0);
    }

    private void testConcurrentHashMap(){
        map = new ConcurrentHashMap<>();
        Thread[] threadsWrite = new Thread[COUNT];
        Thread[] threadsRead = new Thread[COUNT];
        for (int i = 0; i < COUNT; i++) {
            int temp = i;
            threadsWrite[i] = new Thread( () -> {
                    map.put(temp, temp);
            });
            threadsRead[i] = new Thread( () -> {
                map.get(temp);
                    //System.out.println(map.get(temp));
            });
        }

        long start = System.nanoTime();
        //Start of threads
        for (int i = 0; i < COUNT; i++) {
            threadsWrite[i].start();
            threadsRead[i].start();
        }
        for (int i = 0; i < COUNT ; i++) {
            try {
                threadsWrite[i].join();
                threadsRead[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println("\n Time = " + (end - start)/1000000000.0);
    }
}
