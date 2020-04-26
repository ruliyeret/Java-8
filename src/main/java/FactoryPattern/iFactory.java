package FactoryPattern;
import FactoryPattern.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface iFactory<T> extends Supplier<T> {


    static <T> iFactory<T> createFactory(Supplier<T> supplier) {

        // option to return always the same instance in fact this is singleton implementation
//        T singlton  = supplier.get();
//        return singlton;
        return () -> supplier.get() ;
    }

    static <T, P> iFactory<T> createFactory(Function<P, T> func, P params) {
        return () -> func.apply(params);
    }

    default T getInstance(){
        return this.get();
    }

    default List<T> createListOfInstances(int range){
         return IntStream.range(0, range).
                mapToObj(index -> this.get()).collect(Collectors.toList());
    }


}
