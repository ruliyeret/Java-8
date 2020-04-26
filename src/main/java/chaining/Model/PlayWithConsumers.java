package chaining.Model;


import chaining.interfaces.IConsumer;

public class PlayWithConsumers {

    public static void main(String[] args){

        IConsumer<String> consumer1 = (s) -> System.out.println("consumer1 = " + s);
        IConsumer<String> consumer2 = (s2) -> System.out.println("consumer2 = " + s2);

        // try to send null as consumer2
        // IConsumer<String> consumer3  = consumer1.andThen(null);
        // for this problem there must to use in the consumer interface Objects.requireNonNull(consumer2);
        IConsumer<String> consumer3  = consumer1.andThen(consumer2);

        consumer3.accept("Hello world");


        System.out.println("Exiting main");

    }
}
