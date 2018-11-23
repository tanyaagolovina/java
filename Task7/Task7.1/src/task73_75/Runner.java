package task73_75;

import java.util.*;
import java.util.function.Predicate;

public class Runner {

    public void run(){

        //73

        Integer[] arrInt = createArrayInt(12);
        System.out.println("Array : " + Arrays.toString(arrInt));
        /** Descending order with lambda */
        Arrays.sort(arrInt, (o1, o2) -> o2.compareTo(o1));
        /** Ascending order with lambda */
        Arrays.sort(arrInt, Integer::compareTo);

        Arrays.sort(arrInt, Comparator.reverseOrder());
        System.out.println("Sort : " + Arrays.toString(arrInt));

        List<String> list = createListStrings();
        System.out.println("List: " + list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println("Sorted list: " + list);

        //74

        System.out.println("______________________________________________________");
        System.out.println("Sum : " + sum(arrInt, x -> x%2 == 0));
        System.out.println("Sum : " + sum(arrInt, x -> x > 10 && x%3 == 0));

        System.out.println("Select: " + selectString(list, x -> x.startsWith("c") || x.startsWith("z")));

        updateList(list, x -> x.toUpperCase());
        System.out.println("Converted list: " + list);

        List<String> newList = Arrays.asList("", null, "   ", "   lllo");
        updateList(newList, String::toUpperCase);
        System.out.println(newList);
        //75


    }

    private Integer[] createArrayInt(int size){
        Integer[] array = new Integer[size];
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private List<String> createListStrings(){
        List<String> list = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++){
            list.add("" + ch + ch);
        }
        Collections.shuffle(list);
        return list;
    }

    private int sum(Integer[] array, Predicate<Integer> filter) {
        int result = 0;
        for (Integer value : array) {
            if(filter.test(value)) {
                result += value;
            }
        }
        return result;
    }

    private List<String> selectString(List<String> list, Predicate<String> filter){
        List<String> newList = new ArrayList<>();
        for (String string : list) {
            if(filter.test(string)){
                newList.add(string);
            }
        }
        return newList;

    }

    private void updateList(List<String> list, ConvertString convertString){
        for (int i = 0; i < list.size(); i++) {
            if(!convertString.isNull(list.get(i))) {
                list.set(i, convertString.convert(list.get(i)));
            }
        }
    }
}
