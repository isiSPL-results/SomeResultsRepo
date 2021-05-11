
//#if -305877938
// Compilation Unit of /Edge.java


//#if -1150711155
package GPL;
//#endif


//#if -1830783058
import java.util.LinkedList;
//#endif


//#if -1209450309
public class Edge extends
//#if 1103695030
    Neighbor
//#endif

    implements
//#if -1332223579
    EdgeIfc
//#endif

{

//#if -1266904982
    public Vertex start;
//#endif


//#if -486735213
    private int weight;
//#endif


//#if -1067823237
    private void  display__wrappee__DFS  ( )
    {

//#if 85317986
        System.out.println( " start=" + start.getName() + " end=" + end.getName( ) );
//#endif

    }

//#endif


//#if -1826909624
    public Vertex getOtherVertex( Vertex vertex )
    {

//#if 1729256032
        if(vertex == start) { //1

//#if -677541436
            return end;
//#endif

        } else

//#if 136453725
            if(vertex == end) { //1

//#if 1547624337
                return start;
//#endif

            } else {

//#if 1108390240
                return null;
//#endif

            }

//#endif


//#endif

    }

//#endif


//#if 272850929
    public void setWeight  (int weight)
    {

//#if -339624410
        this.weight = weight;
//#endif

    }

//#endif


//#if -1384226441
    public Vertex getEnd( )
    {

//#if 1862975041
        return end;
//#endif

    }

//#endif


//#if -1069670279
    private void  display__wrappee__BFS  ( )
    {

//#if 1160626407
        System.out.println( " start=" + start.getName() + " end=" + end.getName( ) );
//#endif

    }

//#endif


//#if 1625241064
    public void EdgeConstructor( Vertex the_start, Vertex the_end )
    {

//#if -212491316
        start = the_start;
//#endif


//#if 764050778
        end = the_end;
//#endif

    }

//#endif


//#if -1667871742
    public void adjustAdorns( EdgeIfc the_edge )
    {

//#if -1080049894
        setWeight(the_edge.getWeight());
//#endif


//#if -36240878
        adjustAdorns__wrappee__DFS( the_edge );
//#endif


//#if 974876372
        adjustAdorns__wrappee__BFS( the_edge );
//#endif


//#if -289401594
        original( the_edge );
//#endif

    }

//#endif


//#if 2133450303
    public void EdgeConstructor( Vertex the_start,  Vertex the_end,
                                 int the_weight )
    {

//#if -1427793528
        EdgeConstructor( the_start,the_end );
//#endif


//#if -291536988
        weight = the_weight;
//#endif

    }

//#endif


//#if 909683838
    public Vertex getStart( )
    {

//#if -158396632
        return start;
//#endif

    }

//#endif


//#if -293371195
    private void  adjustAdorns__wrappee__DFS  ( EdgeIfc the_edge )
    {
    }
//#endif


//#if 1934135789
    public int getWeight  ()
    {

//#if 1720675094
        return this.weight;
//#endif

    }

//#endif


//#if -955298238
    public void display()
    {

//#if 1611192470
        System.out.print( " Weight=" + weight );
//#endif


//#if 349950599
        display__wrappee__DFS();
//#endif


//#if 292692297
        display__wrappee__BFS();
//#endif


//#if 2122584783
        original();
//#endif

    }

//#endif


//#if 524277255
    private void  adjustAdorns__wrappee__BFS  ( EdgeIfc the_edge )
    {
    }
//#endif

}

//#endif


//#endif

