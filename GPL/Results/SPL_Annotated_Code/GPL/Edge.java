
//#if  WeightedWithEdges
// Compilation Unit of /Edge.java

package GPL;

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
import java.util.LinkedList;
//#endif

public class Edge extends
//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    Neighbor
//#endif

    implements
//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    EdgeIfc
//#endif

{

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public Vertex start;
//#endif

    private int weight;

//#if  MSTKruskal
    private void  display__wrappee__DFS  ( )
    {
        System.out.println( " start=" + start.getName() + " end=" + end.getName( ) );
    }

//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public Vertex getOtherVertex( Vertex vertex )
    {
        if(vertex == start) { //1
            return end;
        } else

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
            if(vertex == end) { //1
                return start;
            } else {
                return null;
            }

//#endif


    }

//#endif

    public void setWeight  (int weight)
    {
        this.weight = weight;
    }


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public Vertex getEnd( )
    {
        return end;
    }

//#endif


//#if  MSTPrim
    private void  display__wrappee__BFS  ( )
    {
        System.out.println( " start=" + start.getName() + " end=" + end.getName( ) );
    }

//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public void EdgeConstructor( Vertex the_start, Vertex the_end )
    {
        start = the_start;
        end = the_end;
    }

//#endif

    public void adjustAdorns( EdgeIfc the_edge )
    {
        setWeight(the_edge.getWeight());

//#if  MSTKruskal
        adjustAdorns__wrappee__DFS( the_edge );
//#endif


//#if  MSTPrim
        adjustAdorns__wrappee__BFS( the_edge );
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        original( the_edge );
//#endif

    }

    public void EdgeConstructor( Vertex the_start,  Vertex the_end,
                                 int the_weight )
    {
        EdgeConstructor( the_start,the_end );
        weight = the_weight;
    }


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public Vertex getStart( )
    {
        return start;
    }

//#endif


//#if  MSTKruskal
    private void  adjustAdorns__wrappee__DFS  ( EdgeIfc the_edge )
    {
    }
//#endif

    public int getWeight  ()
    {
        return this.weight;
    }

    public void display()
    {
        System.out.print( " Weight=" + weight );

//#if  MSTKruskal
        display__wrappee__DFS();
//#endif


//#if  MSTPrim
        display__wrappee__BFS();
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        original();
//#endif

    }


//#if  MSTPrim
    private void  adjustAdorns__wrappee__BFS  ( EdgeIfc the_edge )
    {
    }
//#endif

}


//#endif

