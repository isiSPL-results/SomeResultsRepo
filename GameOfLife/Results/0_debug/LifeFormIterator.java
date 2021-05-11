
//#if 738449783
// Compilation Unit of /LifeFormIterator.java


//#if -1281682253
import java.util.Iterator;
//#endif


//#if -2079804879
class LifeFormIterator implements
//#if 805880441
    Iterator
//#endif

{

//#if 365907367
    private final Playground playground;
//#endif


//#if -2730606
    private int currentX = 0;
//#endif


//#if -2700815
    private int currentY = 0;
//#endif


//#if -1977512284
    LifeFormIterator(Playground playground)
    {

//#if -1628267126
        this.playground = playground;
//#endif

    }

//#endif


//#if -1504578771
    public void remove()
    {

//#if -2099230551
        throw new UnsupportedOperationException();
//#endif

    }

//#endif


//#if -1876858552
    public LifeForm next()
    {

//#if 357050702
        LifeForm result = new LifeForm(currentX, currentY, this.playground.field[currentX][currentY], this.playground.getNeighbourhood(currentX, currentY));
//#endif


//#if -401030137
        currentX++;
//#endif


//#if 647209290
        if(currentX >= this.playground.xSize) { //1

//#if 1579833115
            currentX = 0;
//#endif


//#if 1579845453
            currentY++;
//#endif


//#if 2114071105
            assert (currentY < this.playground.ySize);
//#endif

        }

//#endif


//#if 36033881
        return result;
//#endif

    }

//#endif


//#if 1791943258
    public boolean hasNext()
    {

//#if -1661871786
        return (currentX < this.playground.xSize) && (currentY < this.playground.ySize);
//#endif

    }

//#endif

}

//#endif


//#endif

