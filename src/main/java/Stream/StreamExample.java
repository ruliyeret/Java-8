package Stream;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*
    @stream
    @IntStream.range - give me a random of number from x ,y
    @filter allowing to filter by predicate
    @Stream.of - initialization Stream
    @collect - get Collector useful: Collector.toList() - return me a new list after filter
               and groupBy - allow to group data by predicate and return map
    @reduce - function that combines all elements of stream into a single result.
 */
public class StreamExample {

    public void example1(){
        List<Integer> numbers = Arrays.asList(1,2,8,5,3);

        numbers
                .stream()
                .filter(num -> num >3)
                .map(String::valueOf)
                .sorted()
                .forEach(System.out::println);
    }

    public void example2(){
        IntStream.range(1,4).forEach(System.out::println);
    }

    public void example3(){
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    public void example4(){
        List<Person> people = Arrays.asList(new Person(3,"ruli"),
                new Person(4,"daa"),
                new Person(5,"yehuda"));

        people
                .stream()
                .filter((person) -> person.name.startsWith("y"))
                .collect(Collectors.toList())
                .forEach((person -> System.out.println(person.name)));

        Map<Integer,List<Person>> personByAge =  people
                .stream()
                .collect(Collectors.groupingBy(person -> person.age));

        personByAge.forEach((age,p) -> System.out.format("age %s: %s\n", age, p.get(0).name));

        System.out.println("reduce function ");
        people.stream().reduce((p1, p2) -> p1.age > p2.age ? p1: p2).ifPresent((person -> System.out.println(person.name)));
    }

    public void example5(){
       List<Integer> list = Arrays.asList(1,2,3,4,4,5,3,2,10);
       list.stream().parallel().distinct().forEach(System.out::println);
    }
    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();
        streamExample.example5();
    }


}
