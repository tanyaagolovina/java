package services;

import java.io.*;

public class FileReader {
    public String readText(){
        StringBuilder textLine = new StringBuilder();
        String fileName = "src/data/book.txt";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName)
                    )
            );

            while(bufferedReader.read() != -1) {
                textLine.append(bufferedReader.readLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                bufferedReader.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }
        return textLine.toString();
    }
}
