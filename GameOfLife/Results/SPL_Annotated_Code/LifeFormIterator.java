
//#if  ModelBase
// Compilation Unit of /LifeFormIterator.java


//#if  ModelBase
import java.util.Iterator;
//#endif

class LifeFormIterator implements Iterator
{
    private final Playground playground;
    private int currentX = 0;
    private int currentY = 0;
    LifeFormIterator(Playground playground)
    {
        this.playground = playground;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public LifeForm next()
    {
        LifeForm result = new LifeForm(currentX, currentY, this.playground.field[currentX][currentY], this.playground.getNeighbourhood(currentX, currentY));
        currentX++;
        if(currentX >= this.playground.xSize) { //1
            currentX = 0;
            currentY++;
            assert (currentY < this.playground.ySize);
        }

        return result;
    }

    public boolean hasNext()
    {
        return (currentX < this.playground.xSize) && (currentY < this.playground.ySize);
    }

}


//#endif

