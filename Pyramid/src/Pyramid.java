import java.util.Scanner;

public class Pyramid {
    private int height;

    private void gapTyping(){
        System.out.print(" ");
    }
    public int setHeight(){
        System.out.print("Enter a height of pyramid: ");
        Scanner in = new Scanner(System.in);
        height = in.nextInt();
        if(checkNumber()) {
            return height;
        } else {
            return setHeight();
        }
    }
    private boolean checkNumber(){
        if(height<=0) {
            System.out.println("Enter a positive number higher than 0");
            return false;
        } else {
            return true;
        }
    }
    public void buildPyramid(){
        for(int i=1;i<=height;i++){
            for(int j=1;j<=(height-i);j++){
                gapTyping();
            }
            for(int n=1;n<=i;n++) {
                System.out.print(n);
            }
            for(int m=1;m<=i;m++){
                if(m!=i) {
                    System.out.print(m);
                }
            }
            System.out.println();
        }
    }
}


