/**
 * interface to accept multiple arg (3 in this case) and
 * return the result
 */
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
