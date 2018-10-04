import java.util.Scanner;

public class Matrix {
    private int [][] arr;
    private int size;

    public int setSize(){
        System.out.print("Enter a size of square matrix: ");
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        if(size<=0) {
            return setSize();
        } else {
            return size;
        }
    }
    public int random(){
        double randomNumber = Math.random();
        randomNumber = randomNumber*100;
        int randomInt = (int)randomNumber - 50;
        return randomInt;
    }
    public int[][] createMatrix(){
        arr = new int [size][size];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                arr[i][j] = random();
            }
        }
        return arr;
    }
    public void showMatrix(int [][] arrMatrix){
        for(int i=0;i<arrMatrix.length;i++){
            for(int j=0;j<arrMatrix.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] revertMatrix(){
        int temp;
        for(int i=0;i<arr.length/2;i++){
            for(int j=i;j<arr.length-1-i;j++){
                temp = arr[i][j];
                arr[i][j] = arr[j][arr.length-1-i];
                arr[j][arr.length-1-i] = arr[arr.length-1-i][arr.length-1-j];
                arr[arr.length-1-i][arr.length-1-j] = arr[arr.length-1-j][i];
                arr[arr.length-1-j][i] = temp;
            }
        }
        return arr;
    }

}
