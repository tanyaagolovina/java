package task76;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

    public void run(){

        //First task
        List<Integer> integerList = Stream.iterate(10, n -> n + 10)
                .limit(10)
                .map(n -> n/2)
                .collect(Collectors.toList());
        System.out.println("Generated list: " + integerList);

        //Second task

        List<Person> people = createList();
        System.out.println("People list: " + people);
        people.stream().filter(person -> person.getSex() == Person.Sex.MALE && person.getAge() >= 18 && person.getAge() <= 55)
                .forEach(System.out::println);
        double averageAge = people.stream().filter(person -> person.getSex() == Person.Sex.FEMALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();

        System.out.println("Total age of women : " + averageAge);
    }

    private List<Person> createList(){
        return Arrays.asList(
                new Person("Oleg", 34, Person.Sex.MALE),
                new Person("Katya", 19, Person.Sex.FEMALE),
                new Person("Nikita", 70, Person.Sex.MALE),
                new Person("Pavel", 40, Person.Sex.MALE),
                new Person("Olga", 20, Person.Sex.FEMALE),
                new Person("Dmitriy", 25, Person.Sex.MALE),
                new Person("Pavel", 60, Person.Sex.MALE),
                new Person("Nastya", 20, Person.Sex.FEMALE),
                new Person("Dan", 15, Person.Sex.MALE)
        );
    }
}
