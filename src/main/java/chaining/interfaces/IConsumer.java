package chaining.interfaces;

import java.util.Objects;

@FunctionalInterface
public interface IConsumer<T> {

    void accept(T t);

    default IConsumer<T> andThen(IConsumer<T> consumer2){
        Objects.requireNonNull(consumer2);
        return (T t) ->{
            this.accept(t);
            consumer2.accept(t);
        };
    }
}

