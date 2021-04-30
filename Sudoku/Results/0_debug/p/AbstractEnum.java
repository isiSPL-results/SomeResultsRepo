
//#if -1138611257
// Compilation Unit of /AbstractEnum.java


//#if 818385953
package p;
//#endif


//#if 753640738
import java.util.HashMap;
//#endif


//#if -400590952
import java.util.Iterator;
//#endif


//#if -302630540
import java.util.Map;
//#endif


//#if 2004385739
import java.util.SortedSet;
//#endif


//#if 1991793004
import java.util.TreeSet;
//#endif


//#if 1479057216
public abstract class AbstractEnum implements
//#if 1971017412
    Comparable
//#endif

{

//#if 701167112
    private static final Map ALL_VALUES_BY_NAME = new HashMap(4);
//#endif


//#if 1643119662
    private static final Map ALL_VALUES_BY_ORDINAL = new HashMap(4);
//#endif


//#if 1119753050
    private static final Map ALL_COUNTS = new HashMap(4);
//#endif


//#if -1467264551
    private final int ordinal = createNextOrdinal(getClass());
//#endif


//#if -1313775550
    private final String name;
//#endif


//#if -1887795423
    protected static AbstractEnum valueOf0(final Class clazz, final String name)
    throws IllegalArgumentException
    {

//#if 766778883
        checkClassIsEnum(clazz);
//#endif


//#if 863354701
        final Map values = getValuesByName(clazz);
//#endif


//#if 1940520407
        if(values.containsKey(name)) { //1

//#if -85271768
            return (AbstractEnum) values.get(name);
//#endif

        }

//#endif


//#if 1805492073
        throw new IllegalArgumentException(name);
//#endif

    }

//#endif


//#if -1693193672
    protected AbstractEnum(final String name)
    {

//#if -1015330082
        this.name = name;
//#endif


//#if 947053618
        getValuesByName(getClass()).put(name, this);
//#endif


//#if -896385355
        getValuesByOrdinal(getClass()).add(this);
//#endif

    }

//#endif


//#if 1279035749
    private static void checkClassIsEnum(final Class clazz)
    {

//#if 1060955927
        if(!AbstractEnum.class.isAssignableFrom(clazz)) { //1

//#if 1778215305
            throw new ClassCastException(clazz.toString());
//#endif

        }

//#endif

    }

//#endif


//#if 769194603
    public int compareTo(final Object o)
    {

//#if 563224009
        if(!getClass().equals(o.getClass())) { //1

//#if 2075202398
            throw new ClassCastException(o.getClass().toString());
//#endif

        }

//#endif


//#if -432680010
        return ordinal - ((AbstractEnum) o).ordinal;
//#endif

    }

//#endif


//#if -159854849
    protected Object clone() throws CloneNotSupportedException
    {

//#if -1396626893
        throw new CloneNotSupportedException();
//#endif

    }

//#endif


//#if -758802844
    protected static AbstractEnum[] values0(final Class clazz,
                                            final AbstractEnum[] array)
    {

//#if -1617023059
        checkClassIsEnum(clazz);
//#endif


//#if 989534430
        int i = 0;
//#endif


//#if 16339987
        for (final Iterator valueIt = getValuesByOrdinal(clazz).iterator(); valueIt
                .hasNext(); ++i) { //1

//#if -955344755
            array[i] = (AbstractEnum) valueIt.next();
//#endif

        }

//#endif


//#if 1847987650
        return array;
//#endif

    }

//#endif


//#if 2116227312
    public String name()
    {

//#if 990217893
        return name;
//#endif

    }

//#endif


//#if -2023308655
    public String toString()
    {

//#if 865279017
        return name;
//#endif

    }

//#endif


//#if -2085658399
    private static int createNextOrdinal(final Class clazz)
    {

//#if 1862967314
        final int count = count(clazz);
//#endif


//#if 1240180943
        ALL_COUNTS.put(clazz, new Integer(count + 1));
//#endif


//#if 677025780
        return count;
//#endif

    }

//#endif


//#if 409532105
    protected static int count(final Class clazz)
    {

//#if -1905728363
        checkClassIsEnum(clazz);
//#endif


//#if 49326235
        return ALL_COUNTS.containsKey(clazz) ? ((Integer) ALL_COUNTS.get(clazz))
               .intValue() : 0;
//#endif

    }

//#endif


//#if 119308091
    private static SortedSet getValuesByOrdinal(final Class clazz)
    {

//#if 607586062
        final SortedSet values;
//#endif


//#if -140573226
        if(ALL_VALUES_BY_ORDINAL.containsKey(clazz)) { //1

//#if -1921969589
            values = (SortedSet) ALL_VALUES_BY_ORDINAL.get(clazz);
//#endif

        } else {

//#if 837197145
            ALL_VALUES_BY_ORDINAL.put(clazz, values = new TreeSet());
//#endif

        }

//#endif


//#if -1208531379
        return values;
//#endif

    }

//#endif


//#if -1296034090
    private static Map getValuesByName(final Class clazz)
    {

//#if -73198282
        final Map values;
//#endif


//#if -1781130867
        if(ALL_VALUES_BY_NAME.containsKey(clazz)) { //1

//#if 103190330
            values = (Map) ALL_VALUES_BY_NAME.get(clazz);
//#endif

        } else {

//#if -1435721757
            ALL_VALUES_BY_NAME.put(clazz, values = new HashMap(8));
//#endif

        }

//#endif


//#if -1340878452
        return values;
//#endif

    }

//#endif


//#if 87306454
    public int ordinal()
    {

//#if 1527146267
        return ordinal;
//#endif

    }

//#endif

}

//#endif


//#endif

