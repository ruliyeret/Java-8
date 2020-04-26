package chaining.Model;

import chaining.interfaces.IFunction;

public class PlayWithFunctions {

    public static void main(String[] args){

        IFunction<String, Integer>  function1 =  (numberAsString) -> Integer.valueOf(numberAsString);
        IFunction<Integer, String> function2 = (number) -> number.toString();
        IFunction<String, String> function3 = function1.andThen(function2);

        System.out.println(function3.apply("3"));

    }
}
