package chaining.interfaces;

import java.util.Objects;

@FunctionalInterface
public interface IFunction<T, R> {

    R apply(T t);

     default <V> IFunction<T, V> andThen(IFunction<R, V> func){
         Objects.requireNonNull(func);
         return (T t ) -> func.apply(this.apply(t));

     }
}
