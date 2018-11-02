import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an amount of numbers: ");
        int amountOfNumbers = in.nextInt();
        System.out.print("Enter an range of numbers: ");
        int range = in.nextInt();

        Set <Integer> set = new HashSet<> ();
        List <Integer> list = new LinkedList<>();

        if (amountOfNumbers >= range) {
            System.out.println("Set will not generate this amount of numbers in this range");
        }

        for(int number = 0; number < amountOfNumbers; number++){
            int random = (int) (Math.random()*range);
            set.add(random);
            list.add(random);
        }

        System.out.println("Set: " + set);
        System.out.println("List: " + list);
    }
}
