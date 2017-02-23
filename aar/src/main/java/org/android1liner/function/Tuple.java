package org.android1liner.function;

/**
 * Created by hongyew on 23/02/2017.
 */

public class Tuple<F,S,T> {
    final public F first;
    final public S second;
    final public T third;
    
    public Tuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public static <F,S,T> Tuple<F,S,T> create(F f, S s, T t) {
        return new Tuple<>(f,s,t);
    }
}
