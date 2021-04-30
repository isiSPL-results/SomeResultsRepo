package GPL;

import java.util.LinkedList;

// end of Vertex class

// *************************************************************************

public   class  Neighbor  implements NeighborIfc
{

    public  Vertex end;


    public  Edge   edge;



    public Neighbor( )
    {
        end = null;
        edge = null;
    }



    public Neighbor( Vertex v,  Edge e )
    {
        end = v;
        edge = e;
    }


    public int weight;



    public Neighbor( Vertex theNeighbor, int theWeight )
    {
        NeighborConstructor( theNeighbor, theWeight );
    }



    public void NeighborConstructor( Vertex theNeighbor, int theWeight )
    {
        NeighborConstructor( theNeighbor );
        weight = theWeight;
    }



    public void display()
    {
        System.out.print( " Weight = " + weight + " " );
        original();
    }



    public void setWeight(int weight)
    {
        this.weight = weight;
    }



    public int getWeight()
    {
        return this.weight;
    }


}
