// Compilation Unit of /Neighbor.java

package GPL;
import java.util.LinkedList;
public class Neighbor implements NeighborIfc
    ,
//#if  Unweighted  &&  WithNeighbors
    EdgeIfc
//#endif

{

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public  Vertex end;
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public  Edge   edge;
//#endif


//#if  WeightedWithNeighbors
    public int weight;
//#endif


//#if  Unweighted  &&  WithNeighbors
    public  Vertex neighbor;
//#endif


//#if  WeightedWithNeighbors
    public void NeighborConstructor( Vertex theNeighbor, int theWeight )
    {
        NeighborConstructor( theNeighbor );
        weight = theWeight;
    }

//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public Neighbor( Vertex v,  Edge e )
    {
        end = v;
        edge = e;
    }

//#endif


//#if  Unweighted  &&  WithNeighbors
    public Vertex getOtherVertex( Vertex vertex )
    {
        return neighbor;
    }

//#endif


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! MSTPrim  && ! Number
    public void display()
    {

//#if  WeightedWithNeighbors
        System.out.print( " Weight = " + weight + " " );
//#endif


//#if  WeightedWithNeighbors
        original();
//#endif


//#if  Unweighted  &&  WithNeighbors
        System.out.print( neighbor.name + " ," );
//#endif

    }

//#endif


//#if  WeightedWithNeighbors
    public Neighbor( Vertex theNeighbor, int theWeight )
    {
        NeighborConstructor( theNeighbor, theWeight );
    }

//#endif


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! MSTPrim  && ! Number
    public void setWeight(int weight)
    {

//#if  WeightedWithNeighbors
        this.weight = weight;
//#endif

    }

//#endif


//#if  Unweighted  &&  WithNeighbors
    public void NeighborConstructor( Vertex theNeighbor )
    {
        neighbor = theNeighbor;
    }

//#endif


//#if  Unweighted  &&  WithNeighbors
    public void adjustAdorns( EdgeIfc the_edge )
    {
    }
//#endif


//#if  Unweighted  &&  WithNeighbors
    public Vertex getEnd( )
    {

//#if  UndirectedWithNeighbors
        return null;
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        return neighbor;
//#endif

    }

//#endif


//#if  Unweighted  &&  WithNeighbors
    public Vertex getStart( )
    {
        return null;
    }

//#endif


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ) && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! Number  && ! Cycle
    public int getWeight()
    {

//#if  WeightedWithNeighbors
        return this.weight;
//#endif


//#if  UndirectedWithNeighbors
        return 0;
//#endif

    }

//#endif


//#if  Unweighted  &&  WithNeighbors
    public Neighbor( Vertex theNeighbor )
    {
        NeighborConstructor( theNeighbor );
    }

//#endif

    public Neighbor( )
    {

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        end = null;
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        edge = null;
//#endif


//#if  Unweighted  &&  WithNeighbors
        neighbor = null;
//#endif

    }

}


