package servise;

public interface List<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    T get(int index);

    void add(T val);

    void add(int index, T val);

    void delete(int index);
}
