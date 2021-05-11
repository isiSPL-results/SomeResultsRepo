
//#if -517095961
// Compilation Unit of /ConcreteIterator.java


//#if 1112601472
package lib.util;
//#endif


//#if 447324130
import java.util.List;
//#endif


//#if -727240212
public class ConcreteIterator implements
//#if -485515707
    LocalIterator
//#endif

    ,
//#if -290689489
    java.io.Serializable
//#endif

{

//#if 1149628546
    private List list = null;
//#endif


//#if 595702764
    private int index = -1;
//#endif


//#if -1612722616
    public void close()
    {
    }
//#endif


//#if -1490558763
    public ConcreteIterator(List list)
    {

//#if 131384626
        this.list = list;
//#endif


//#if -2023415862
        this.index = 0;
//#endif

    }

//#endif


//#if 264396739
    public boolean hasNext()
    {

//#if -168837609
        if(list != null) { //1

//#if -199682013
            return list.size() > index;
//#endif

        } else {

//#if 858421588
            return false;
//#endif

        }

//#endif

    }

//#endif


//#if -843313584
    public Object next()
    {

//#if -2071462820
        if(list != null) { //1

//#if 250330746
            return list.get(index++);
//#endif

        } else {

//#if -18348968
            return null;
//#endif

        }

//#endif

    }

//#endif


//#if -60388074
    public void remove()
    {
    }
//#endif

}

//#endif


//#endif

