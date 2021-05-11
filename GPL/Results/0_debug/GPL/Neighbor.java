
//#if -131782254
// Compilation Unit of /Neighbor.java


//#if -1549051044
package GPL;
//#endif


//#if 383568509
import java.util.LinkedList;
//#endif


//#if -1612484417
public class Neighbor implements
//#if 1555342007
    NeighborIfc
//#endif

    ,
//#if -2028109428
    EdgeIfc
//#endif

{

//#if -142045366
    public  Vertex end;
//#endif


//#if 1052702939
    public  Edge   edge;
//#endif


//#if -1123657030
    public int weight;
//#endif


//#if -373756609
    public  Vertex neighbor;
//#endif


//#if 1697114824
    public void NeighborConstructor( Vertex theNeighbor, int theWeight )
    {

//#if 477406783
        NeighborConstructor( theNeighbor );
//#endif


//#if 1363666049
        weight = theWeight;
//#endif

    }

//#endif


//#if 1974380683
    public Neighbor( Vertex v,  Edge e )
    {

//#if 1222815400
        end = v;
//#endif


//#if -1029810987
        edge = e;
//#endif

    }

//#endif


//#if 1135594305
    public Vertex getOtherVertex( Vertex vertex )
    {

//#if -1640996541
        return neighbor;
//#endif

    }

//#endif


//#if -1755755607
    public void display()
    {

//#if 1331405864
        System.out.print( " Weight = " + weight + " " );
//#endif


//#if -1776320960
        original();
//#endif


//#if -577196459
        System.out.print( neighbor.name + " ," );
//#endif

    }

//#endif


//#if 1194822578
    public Neighbor( Vertex theNeighbor, int theWeight )
    {

//#if 1405926151
        NeighborConstructor( theNeighbor, theWeight );
//#endif

    }

//#endif


//#if 289590314
    public void setWeight(int weight)
    {

//#if 792794540
        this.weight = weight;
//#endif

    }

//#endif


//#if 1071627460
    public void NeighborConstructor( Vertex theNeighbor )
    {

//#if 1182110727
        neighbor = theNeighbor;
//#endif

    }

//#endif


//#if -1433759767
    public void adjustAdorns( EdgeIfc the_edge )
    {
    }
//#endif


//#if -428601104
    public Vertex getEnd( )
    {

//#if -218746001
        return null;
//#endif


//#if 974882276
        return neighbor;
//#endif

    }

//#endif


//#if 142631351
    public Vertex getStart( )
    {

//#if 1823713784
        return null;
//#endif

    }

//#endif


//#if -1405206170
    public int getWeight()
    {

//#if 375758012
        return this.weight;
//#endif


//#if 320834708
        return 0;
//#endif

    }

//#endif


//#if -500504678
    public Neighbor( Vertex theNeighbor )
    {

//#if -180802548
        NeighborConstructor( theNeighbor );
//#endif

    }

//#endif


//#if 42895449
    public Neighbor( )
    {

//#if -231668479
        end = null;
//#endif


//#if -1327230875
        edge = null;
//#endif


//#if 880279898
        neighbor = null;
//#endif

    }

//#endif

}

//#endif


//#endif

