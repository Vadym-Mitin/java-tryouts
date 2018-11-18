package iterator.pattern;

import java.util.Iterator;

/**
 * @author Vadym Mitin
 */
public class SImpleIterator<T> implements Iterator<T> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
