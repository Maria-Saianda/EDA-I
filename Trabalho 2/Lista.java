public interface Lista<T> {
    void add(T x);
    void add(int i, T x);
    void set(int i, T x);
    T get(int i);
    int size();
    public String toString();
}
