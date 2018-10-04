import java.util.Scanner;

public class AbsoluteNumbers {
    private int range;
    public int setRange(){
        System.out.print("Enter an integer: ");
        Scanner scanner = new Scanner(System.in);
        range = scanner.nextInt();
        if(range<=0) {
            System.out.println("Error! Enter a positive integer!");
            return setRange();
        } else {
            return range;
        }
    }
    public void findNumbers(int range) {
        int i;
        int divisor = 0;
        for(i=range;i>=1;i--) {
            for (int j=0;j<i;j++) {
                if(j!=0) {
                    if(j<=i/2) {
                        if (i % j == 0) {
                            divisor += j;
                        }
                    }
                }
            }
            if (divisor==i){
                System.out.println(i+" is absolute number");
            }
            divisor = 0;
        }
    }
}

