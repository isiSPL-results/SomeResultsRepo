package lib.util;
public interface LocalIterator extends IteratorDsk
{
    public void close();
    public Object next();
    public void remove();
    public boolean hasNext();
}
