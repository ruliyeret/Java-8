package Optional;

import java.util.Optional;

public class OptionalExample {

     public static void main(String[] args) {


        Optional<String> name = Optional.of("ruli");
        System.out.println(name.get());

        Optional<String> nameNull = Optional.ofNullable(null);
        nameNull.ifPresent(System.out::println);

        Optional<String> nameWithOptionToBeNull = Optional.ofNullable("rulii is not null");
        nameWithOptionToBeNull.ifPresent(System.out::println);

        Optional<String> nameOrNull = Optional.ofNullable(null);
        nameOrNull.orElse("ruli");
        System.out.println(nameOrNull);
    }
}
