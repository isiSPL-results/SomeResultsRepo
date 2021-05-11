
//#if 245582145
// Compilation Unit of /Vertex.java


//#if -900133496
package GPL;
//#endif


//#if -684217678
import java.util.Iterator;
//#endif


//#if 1025025193
import java.util.LinkedList;
//#endif


//#if 1111101580
import java.lang.Integer;
//#endif


//#if 1495570945
import java.util.Collections;
//#endif


//#if 1935687178
import java.util.Comparator;
//#endif


//#if 657709021
public class Vertex
{

//#if -962974527
    public LinkedList neighbors;
//#endif


//#if 11318543
    public String name;
//#endif


//#if -1092322422
    public  Vertex representative;
//#endif


//#if -29519831
    public LinkedList members;
//#endif


//#if -1091640823
    public boolean visited;
//#endif


//#if 595578511
    public int VertexNumber;
//#endif


//#if 446783444
    public int componentNumber;
//#endif


//#if -430850056
    public int VertexCycle;
//#endif


//#if -439813861
    public int VertexColor;
//#endif


//#if 13664313
    public String pred;
//#endif


//#if 821998011
    public int key;
//#endif


//#if -1248325469
    public LinkedList adjacentNeighbors;
//#endif


//#if -1800585892
    public int finishTime;
//#endif


//#if 1822863691
    public int strongComponentNumber;
//#endif


//#if -1964427895
    public LinkedList weightsList;
//#endif


//#if -586246312
    private void  display__wrappee__MSTKruskal  ()
    {

//#if -642113239
        if(representative == null) { //1

//#if -1756589856
            System.out.print( "Rep null " );
//#endif

        } else {

//#if -1221434341
            System.out.print( " Rep " + representative.getName() + " " );
//#endif

        }

//#endif


//#if 1928077085
        display__wrappee__UndirectedWithEdges();
//#endif


//#if 1734091942
        display__wrappee__Cycle();
//#endif

    }

//#endif


//#if 1450208551
    private void  display__wrappee__UndirectedWithNeighbors  ( )
    {

//#if -147802860
        System.out.print( "Node " + name + " connected to: " );
//#endif


//#if 1856544173
        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) { //1

//#if 1862191655
            System.out.print( vxiter.next( ).getName( ) + ", " );
//#endif

        }

//#endif


//#if 468793013
        System.out.println();
//#endif

    }

//#endif


//#if 957975930
    public void adjustAdorns( Vertex the_vertex, int index )
    {

//#if 1147614421
        int the_weight = ( ( Integer )the_vertex.weightsList.get( index ) ).intValue();
//#endif


//#if 1759829296
        weightsList.add( new Integer( the_weight ) );
//#endif


//#if -1073543336
        original( the_vertex, index );
//#endif

    }

//#endif


//#if -1725563090
    public void init_vertex( WorkSpace w )
    {

//#if 1812592024
        visited = false;
//#endif


//#if -439878266
        w.init_vertex( ( Vertex ) this );
//#endif

    }

//#endif


//#if -147774176
    public void adjustAdorns( Neighbor sourceNeighbor )
    {

//#if -1273898682
        Neighbor targetNeighbor =
            ( Neighbor )adjacentNeighbors.getLast();
//#endif


//#if -781216438
        targetNeighbor.weight = sourceNeighbor.weight;
//#endif


//#if 744533000
        original( sourceNeighbor );
//#endif

    }

//#endif


//#if -1408748028
    private void  VertexConstructor__wrappee__MSTKruskal  ( )
    {

//#if -1463992444
        name      = null;
//#endif


//#if -84319167
        neighbors = new LinkedList( );
//#endif

    }

//#endif


//#if -560670114
    private void  display__wrappee__DFS  ( )
    {

//#if 1880772404
        if(visited) { //1

//#if -27961893
            System.out.print( "  visited" );
//#endif

        } else {

//#if -330551297
            System.out.println( " !visited " );
//#endif

        }

//#endif


//#if -2126258843
        display__wrappee__Cycle( );
//#endif

    }

//#endif


//#if -1343623469
    private void  display__wrappee__Cycle  ()
    {

//#if -204113719
        System.out.print( " VertexCycle# " + VertexCycle + " " );
//#endif


//#if -1878493903
        display__wrappee__Connected();
//#endif


//#if -716227641
        display__wrappee__DirectedWithNeighbors();
//#endif

    }

//#endif


//#if 15502622
    private void  display__wrappee__Number  ( )
    {

//#if -930046309
        System.out.print( " # "+ VertexNumber + " " );
//#endif


//#if -1503327458
        display__wrappee__UndirectedWithEdges( );
//#endif

    }

//#endif


//#if -1592135103
    public String getName( )
    {

//#if 165617700
        return this.name;
//#endif


//#if -1971803092
        return name;
//#endif

    }

//#endif


//#if 979694227
    public  Vertex assignName( String name )
    {

//#if 316437172
        this.name = name;
//#endif


//#if -2014225994
        return ( Vertex ) this;
//#endif

    }

//#endif


//#if -689590010
    private void  display__wrappee__WeightedWithEdges  ( )
    {

//#if 1590401170
        if(visited) { //1

//#if -569434366
            System.out.print( "  visited" );
//#endif

        } else {

//#if -1026238407
            System.out.println( " !visited " );
//#endif

        }

//#endif


//#if -360269112
        display__wrappee__MSTKruskal( );
//#endif


//#if -717655561
        System.out.print( " FinishTime -> " + finishTime + " SCCNo -> "
                          + strongComponentNumber );
//#endif


//#if -873213352
        display__wrappee__DFS();
//#endif

    }

//#endif


//#if 1746656508
    private void  display__wrappee__UndirectedWithEdges  ( )
    {

//#if 122856237
        System.out.print( " Node " + name + " connected to: " );
//#endif


//#if 1881222726
        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) { //1

//#if -2063181346
            System.out.print( vxiter.next().getName() + ", " );
//#endif

        }

//#endif


//#if 1657184206
        System.out.println( );
//#endif

    }

//#endif


//#if -1631896075
    public void addWeight( int weight )
    {

//#if 150520673
        weightsList.add( new Integer( weight ) );
//#endif

    }

//#endif


//#if 813775800
    public VertexIter getNeighbors( )
    {

//#if -274702524
        return new VertexIter( ) {
            private Iterator iter = neighbors.iterator( );
            public Vertex next( ) {
                return ( ( Neighbor )iter.next( ) ).end;
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif


//#if 454585393
        return new VertexIter( ) {
            private Iterator iter = adjacentNeighbors.iterator( );
            public Vertex next( ) {
                return ( ( Neighbor )iter.next( ) ).neighbor;
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif

    }

//#endif


//#if -50914202
    public EdgeIter getEdges( )
    {

//#if -783228516
        return new EdgeIter( ) {
            private Iterator iter = neighbors.iterator( );
            public EdgeIfc next( ) {
                return ( ( EdgeIfc ) ( ( Neighbor )iter.next( ) ).edge );
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif


//#if 184074346
        return new EdgeIter( ) {
            private Iterator iter = adjacentNeighbors.iterator( );
            public EdgeIfc next( ) {
                return ( Neighbor ) iter.next( );

//              return ( ( EdgeIfc ) ( ( Neighbor )iter.next( ) ).edge );
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif

    }

//#endif


//#if -1914139755
    private void  VertexConstructor__wrappee__MSTPrim  ( )
    {

//#if -539975002
        name      = null;
//#endif


//#if 326517603
        neighbors = new LinkedList( );
//#endif

    }

//#endif


//#if 594196927
    public void display()
    {

//#if 718897271
        int s = weightsList.size();
//#endif


//#if -1150134219
        int i;
//#endif


//#if -2050050271
        System.out.print( " Weights : " );
//#endif


//#if -1714782164
        for ( i=0; i<s; i++ ) { //1

//#if 834673157
            System.out.print( ( ( Integer )weightsList.get( i ) ).intValue() + ", " );
//#endif

        }

//#endif


//#if 160525681
        display__wrappee__WeightedWithEdges();
//#endif


//#if 1866025875
        if(visited) { //1

//#if 1402059952
            System.out.print( "  visited" );
//#endif

        } else {

//#if 879685907
            System.out.println( " !visited " );
//#endif

        }

//#endif


//#if -412661273
        display__wrappee__MSTKruskal( );
//#endif


//#if -1969490410
        display__wrappee__MSTPrim( );
//#endif


//#if 177719873
        display__wrappee__Connected( );
//#endif

    }

//#endif


//#if -54821210
    public void addNeighbor( Neighbor n )
    {

//#if -91892612
        neighbors.add( n );
//#endif

    }

//#endif


//#if -1028827481
    public void addWeight( Vertex end, int theWeight )
    {

//#if -1755259795
        Neighbor the_neighbor =
            ( Neighbor ) ( end.adjacentNeighbors ).removeLast();
//#endif


//#if -2126035719
        the_neighbor.weight = theWeight;
//#endif


//#if 1498607986
        ( end.adjacentNeighbors ).add( the_neighbor );
//#endif

    }

//#endif


//#if -1295484710
    private void  VertexConstructor__wrappee__WeightedWithEdges  ( )
    {

//#if 1532883615
        VertexConstructor__wrappee__Cycle( );
//#endif


//#if -1706907162
        visited = false;
//#endif

    }

//#endif


//#if 451855072
    private void  display__wrappee__DirectedWithNeighbors  ()
    {

//#if 1614238609
        System.out.print( "Node " + getName( ) + " connected to: " );
//#endif


//#if -1848424535
        for(VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) { //1

//#if 1810300841
            Vertex v = vxiter.next( );
//#endif


//#if 635821306
            System.out.print( v.getName( ) + ", " );
//#endif

        }

//#endif


//#if 123154097
        System.out.println( );
//#endif

    }

//#endif


//#if 2079731859
    public void VertexConstructor( )
    {

//#if 2073354137
        VertexConstructor__wrappee__MSTKruskal( );
//#endif


//#if -1477210716
        VertexConstructor__wrappee__MSTPrim();
//#endif


//#if 812103247
        VertexConstructor__wrappee__Connected();
//#endif


//#if -809835047
        visited = false;
//#endif


//#if 577989503
        VertexConstructor__wrappee__WeightedWithEdges();
//#endif


//#if -802762539
        weightsList = new LinkedList();
//#endif

    }

//#endif


//#if -1881048965
    public void addEdge( Neighbor n )
    {

//#if 1266564982
        adjacentNeighbors.add( n );
//#endif

    }

//#endif


//#if 1945750209
    private void  display__wrappee__MSTPrim  ( )
    {

//#if 1879412737
        System.out.print( " Pred " + pred + " Key " + key + " " );
//#endif


//#if -82749614
        display__wrappee__Number( );
//#endif

    }

//#endif


//#if 712692903
    private void  VertexConstructor__wrappee__Cycle  ()
    {

//#if 1005707357
        name      = null;
//#endif


//#if -313827588
        adjacentNeighbors = new LinkedList();
//#endif

    }

//#endif


//#if 519377418
    private void  VertexConstructor__wrappee__Connected  ()
    {

//#if -1056584604
        name      = null;
//#endif


//#if 1303209475
        adjacentNeighbors = new LinkedList();
//#endif

    }

//#endif


//#if -427149338
    public LinkedList getNeighborsObj( )
    {

//#if 732006657
        return neighbors;
//#endif


//#if -861983517
        return adjacentNeighbors;
//#endif

    }

//#endif


//#if 1511929909
    public Vertex( )
    {

//#if -549703356
        VertexConstructor( );
//#endif

    }

//#endif


//#if 869956813
    public void nodeSearch( WorkSpace w )
    {

//#if -616563760
        int     s, c;
//#endif


//#if -139478535
        Vertex v;
//#endif


//#if 1069337690
        Vertex  header;
//#endif


//#if 1745857040
        w.preVisitAction( ( Vertex ) this );
//#endif


//#if -836062505
        if(visited) { //1

//#if 1401180644
            return;
//#endif

        }

//#endif


//#if 673498442
        visited = true;
//#endif


//#if -1492421646
        for ( VertexIter  vxiter = getNeighbors(); vxiter.hasNext(); ) { //1

//#if 2126014771
            v = vxiter.next( );
//#endif


//#if -1489338657
            w.checkNeighborAction( ( Vertex ) this, v );
//#endif


//#if -1244025604
            v.nodeSearch( w );
//#endif

        }

//#endif


//#if 690679995
        w.postVisitAction( ( Vertex ) this );
//#endif


//#if 979569279
        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) { //1

//#if 1221323208
            v = vxiter.next( );
//#endif


//#if -350277674
            if(!v.visited) { //1

//#if -1229238776
                GlobalVarsWrapper.Queue.add( v );
//#endif

            }

//#endif

        }

//#endif


//#if 362713196
        while( GlobalVarsWrapper.Queue.size( )!= 0 ) { //1

//#if -1328630332
            header = ( Vertex ) GlobalVarsWrapper.Queue.get( 0 );
//#endif


//#if 819752653
            GlobalVarsWrapper.Queue.remove( 0 );
//#endif


//#if -303356604
            header.nodeSearch( w );
//#endif

        }

//#endif

    }

//#endif


//#if -978110922
    private void  display__wrappee__Connected  ( )
    {

//#if 1848028570
        System.out.print( " comp# "+ componentNumber + " " );
//#endif


//#if -350986597
        display__wrappee__Number( );
//#endif


//#if -821386250
        display__wrappee__UndirectedWithNeighbors( );
//#endif

    }

//#endif

}

//#endif


//#endif

