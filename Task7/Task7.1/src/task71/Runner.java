package runner;

import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Class for task with reflection(task 7.1)
 */

public class Runner {
    public void run() throws NoSuchFieldException, IllegalAccessException{
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String string = in.nextLine();
        System.out.println(string);

        Class<?> clazz = string.getClass();
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        field.set(string, "New".toCharArray());
        System.out.println("new -> " + string);

    }
}
