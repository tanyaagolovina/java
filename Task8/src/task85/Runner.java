package task85;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class Runner {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory: ");
        String dir = scanner.nextLine();
        System.out.print("Enter a char: ");
        String ch = scanner.next();
        DirectoryProccessor processor = new DirectoryProccessor(new File(dir), ch);
        FutureTask<Integer> task =
                new FutureTask <Integer> (processor);
        new Thread(task).start();
    }
}
