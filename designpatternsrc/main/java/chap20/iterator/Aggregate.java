package chap20.iterator;

/**
 * 聚集接口
 *
 * @param <T>
 */
public interface Aggregate<T> {

    public Iterator<T> createIterator();
}
