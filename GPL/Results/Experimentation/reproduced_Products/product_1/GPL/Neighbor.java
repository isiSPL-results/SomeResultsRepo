package GPL;
import java.util.LinkedList;
public class Neighbor implements NeighborIfc
{
    public  Vertex end;
    public  Edge   edge;
    public int weight;
    public void NeighborConstructor( Vertex theNeighbor, int theWeight )
    {
        NeighborConstructor( theNeighbor );
        weight = theWeight;
    }
    public Neighbor( Vertex v,  Edge e )
    {
        end = v;
        edge = e;
    }
    public void display()
    {
        System.out.print( " Weight = " + weight + " " );
        original();
    }
    public Neighbor( Vertex theNeighbor, int theWeight )
    {
        NeighborConstructor( theNeighbor, theWeight );
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public int getWeight()
    {
        return this.weight;
    }
    public Neighbor( )
    {
        end = null;
        edge = null;
    }

}
