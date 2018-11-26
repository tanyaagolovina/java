package task85;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DirectoryProccessor implements Callable<Integer>, Serializable {

    private File directory;
    private static File newFile;
    private String ch;
    private int counter;


    public DirectoryProccessor(File directory, String ch){
        this.directory = directory;
        this.ch = ch;
    }

    static {
        newFile = new File("E:\\JavaBasics\\java\\Task8\\new file.txt");
    }

    public boolean search(File file){
        counter = 0;
        boolean flag = false;
        try (Scanner scanner = new Scanner(new FileInputStream(file))){
            while(scanner.hasNextLine()){
                String string = scanner.nextLine();
                String[] arrOfStr = string.split(" ");
                for(String str : arrOfStr) {
                    if (str.startsWith(ch)) {
                        ++counter;
                        System.out.println(string);
                        flag = true;
                    }
                }
                }
            writeToFile(newFile);
        } catch (IOException e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Integer call() {

        File[] files = directory.listFiles();
        ArrayList<Future<Integer>> result = new ArrayList<>();
        for (File file: files) {
            System.out.println(file.getPath());
            if(file.isDirectory()) {
                DirectoryProccessor proccessor = new DirectoryProccessor(file, ch);
                FutureTask task = new FutureTask(proccessor);
                result.add(task);
                new Thread(task).start();
            } else {
                if (search(file)){
                    String[] arr = readFile();
                    for (String str: arr) {
                        System.out.println(str);
                    }
                }
            }
        }
        return null;
    }

    private String[] readFile(){
        System.out.println("Read File");
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(newFile))){
            System.out.println(inputStream.readObject());
            return (String[])inputStream.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            String[] result = new String[1];
            result[0] = "Nothing";
            return new String[0];
        }
    }

    private void writeToFile(File ff){
        ObjectOutputStream ostream = null;
        if(!newFile.canWrite()){
                try{
                    ostream = new ObjectOutputStream(new FileOutputStream(newFile));
                } catch (FileNotFoundException e) {
                    System.err.println("File not found");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }

            try{
                ostream.writeObject(ff.getPath() + " - " + counter);
            } catch (IOException e) {
                System.err.println("Error in writing to file " + ff.getName());
            }

    }
}
