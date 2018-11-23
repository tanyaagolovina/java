package task72;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public void run() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UnaryOperation unaryOperation;

        Class<?> clazz = UnaryOperation.class;
        Constructor constructor = clazz.getConstructor();
        constructor.newInstance();

        unaryOperation = (UnaryOperation) constructor.newInstance();
        System.out.println(unaryOperation);

        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().startsWith("set")) {
                method.invoke(unaryOperation, 7.2);
                System.out.println(unaryOperation);
            }
            if (method.getName().startsWith("inc")){
                method.invoke(unaryOperation);
                System.out.println(unaryOperation);
            }
            if (method.getName().startsWith("dec")) {
                method.invoke(unaryOperation);
                System.out.println(unaryOperation);
            }
        }


    }
}
