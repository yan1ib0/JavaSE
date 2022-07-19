package cc.excalibur.list;

public interface MyList<T> {
    public boolean add(T ele);
    public T get(int index);
    public T remove(int index);
    public int size();
}
