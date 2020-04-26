package Lamda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class classReceiveFunctionsAsArgument {

    public Integer testReceiveFunction(Function<String, Integer> function, String name){
        return function.apply(name);
    }

    public void testReceiveConsumer(Consumer<String> consumer, String name){
        consumer.accept(name);
    }

    public void testReceiveSupplier(Supplier<String> supplier){
        System.out.println(supplier.get());
    }

    public void testReceiveIFunctionInterface(iFunctionInterface functionInterface, int number, int numberTwo){
        functionInterface.getSomething(number, numberTwo);
    }

    public static void main(String[] args) {
        classReceiveFunctionsAsArgument classReceiveFunctionsAsArgument = new classReceiveFunctionsAsArgument();

        System.out.println(classReceiveFunctionsAsArgument.testReceiveFunction((String)->{return 34;}, "ruli"));

        classReceiveFunctionsAsArgument.testReceiveConsumer((String s) -> System.out.println(s), "shulamit");

        classReceiveFunctionsAsArgument.testReceiveIFunctionInterface((int a, int b) -> {
             ArrayList<String> arr = new  ArrayList<String>();
             arr.add(String.valueOf(a));
             arr.add(String.valueOf(b));
            System.out.println("tuli");
             return arr;
        }, 4,5);


        String a = "ruli";
        classReceiveFunctionsAsArgument.testReceiveSupplier(()-> {return new String("ruli");});
    }
}
