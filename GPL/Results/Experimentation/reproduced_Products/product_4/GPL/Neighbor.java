package GPL;
import java.util.LinkedList;
public class Neighbor implements NeighborIfc
    ,EdgeIfc
{
    public  Vertex neighbor;
    public Vertex getOtherVertex( Vertex vertex )
    {
        return neighbor;
    }
    public void display()
    {
        System.out.print( neighbor.name + " ," );
    }
    public void setWeight(int weight)
    {
    }
    public void NeighborConstructor( Vertex theNeighbor )
    {
        neighbor = theNeighbor;
    }
    public void adjustAdorns( EdgeIfc the_edge )
    {
    } public Vertex getEnd( )
    {
        return null;
    }
    public Vertex getStart( )
    {
        return null;
    }
    public int getWeight()
    {
        return 0;
    }
    public Neighbor( Vertex theNeighbor )
    {
        NeighborConstructor( theNeighbor );
    }
    public Neighbor( )
    {
        neighbor = null;
    }

}
