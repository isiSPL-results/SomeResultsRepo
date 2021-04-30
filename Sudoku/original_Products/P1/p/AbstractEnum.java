package p;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;


public abstract class AbstractEnum implements Comparable
{
    private static final Map ALL_VALUES_BY_NAME = new HashMap(4);
    private static final Map ALL_VALUES_BY_ORDINAL = new HashMap(4);
    private static final Map ALL_COUNTS = new HashMap(4);

    private final int ordinal = createNextOrdinal(getClass());

    private final String name;


    protected static AbstractEnum[] values0(final Class clazz,
                                            final AbstractEnum[] array)
    {
        checkClassIsEnum(clazz);
        int i = 0;
        for (final Iterator valueIt = getValuesByOrdinal(clazz).iterator(); valueIt
                .hasNext(); ++i) {
            array[i] = (AbstractEnum) valueIt.next();
        }
        return array;
    }


    protected static int count(final Class clazz)
    {
        checkClassIsEnum(clazz);
        return ALL_COUNTS.containsKey(clazz) ? ((Integer) ALL_COUNTS.get(clazz))
               .intValue() : 0;
    }


    protected static AbstractEnum valueOf0(final Class clazz, final String name)
    throws IllegalArgumentException
    {
        checkClassIsEnum(clazz);
        final Map values = getValuesByName(clazz);
        if (values.containsKey(name)) {
            return (AbstractEnum) values.get(name);
        }
        throw new IllegalArgumentException(name);
    }


    protected AbstractEnum(final String name)
    {
        this.name = name;
        getValuesByName(getClass()).put(name, this);
        getValuesByOrdinal(getClass()).add(this);
    }


    public String name()
    {
        return name;
    }


    public int ordinal()
    {
        return ordinal;
    }


    protected Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }


    public String toString()
    {
        return name;
    }


    public int compareTo(final Object o)
    {
        if (!getClass().equals(o.getClass())) {
            throw new ClassCastException(o.getClass().toString());
        }
        return ordinal - ((AbstractEnum) o).ordinal;
    }

    private static Map getValuesByName(final Class clazz)
    {
        final Map values;
        if (ALL_VALUES_BY_NAME.containsKey(clazz)) {
            values = (Map) ALL_VALUES_BY_NAME.get(clazz);
        } else {
            ALL_VALUES_BY_NAME.put(clazz, values = new HashMap(8));
        }
        return values;
    }

    private static SortedSet getValuesByOrdinal(final Class clazz)
    {
        final SortedSet values;
        if (ALL_VALUES_BY_ORDINAL.containsKey(clazz)) {
            values = (SortedSet) ALL_VALUES_BY_ORDINAL.get(clazz);
        } else {
            ALL_VALUES_BY_ORDINAL.put(clazz, values = new TreeSet());
        }
        return values;
    }

    private static int createNextOrdinal(final Class clazz)
    {
        final int count = count(clazz);
        ALL_COUNTS.put(clazz, new Integer(count + 1));
        return count;
    }

    private static void checkClassIsEnum(final Class clazz)
    {
        if (!AbstractEnum.class.isAssignableFrom(clazz)) {
            throw new ClassCastException(clazz.toString());
        }
    }
}
