package GPL;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
public class Graph
{
    public LinkedList vertices;
    public static boolean isDirected = true;
    public Graph()
    {
        vertices = new LinkedList();
    }
    public  Graph StrongComponents()
    {
        FinishTimeWorkSpace FTWS = new FinishTimeWorkSpace();
        GraphSearch( FTWS );
        sortVertices(
        new Comparator() {
            public int compare( Object o1, Object o2 ) {
                Vertex v1 = ( Vertex )o1;
                Vertex v2 = ( Vertex )o2;

                if ( v1.finishTime > v2.finishTime ) {
                    return -1;
                }

                if ( v1.finishTime == v2.finishTime ) {
                    return 0;
                }
                return 1;
            }
        } );
        Graph gaux = ComputeTranspose( ( Graph )this );
        WorkSpaceTranspose WST = new WorkSpaceTranspose();
        gaux.GraphSearch( WST );
        return gaux;
    }
    public void addAnEdge( Vertex start,  Vertex end, int weight )
    {
        addEdge( start,end, weight );
    }
    private void  run__wrappee__DFS  ( Vertex s )
    {
        System.out.println( "Cycle? " + CycleCheck() );
        run__wrappee__DirectedWithNeighbors( s );
    }
    public EdgeIfc addEdge(Vertex start,  Vertex end)
    {
        Neighbor e = new Neighbor( end );
        addEdge( start, e );
        return e;
    }
    public void addEdge( Vertex start,  Neighbor theNeighbor )
    {
        start.addEdge( theNeighbor );
    }
    public void addEdge( Vertex start,  Vertex end, int weight )
    {
        addEdge( start,end );
        start.addWeight( weight );
        if(isDirected==false) { //1
            end.addWeight( weight );
        }
    }
    private void  display__wrappee__WeightedWithEdges  ()
    {
        System.out.println( "******************************************" );
        System.out.println( "Vertices " );
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext() ; ) { //1
            vxiter.next().display();
        }
        System.out.println( "******************************************" );
    }
    public boolean CycleCheck()
    {
        CycleWorkSpace c = new CycleWorkSpace( isDirected );
        GraphSearch( c );
        return c.AnyCycles;
    }
    public void display()
    {
        display__wrappee__WeightedWithEdges();
    }
    public void run( Vertex s )
    {
        System.out.println("StronglyConnected");
        Graph gaux = StrongComponents();
        gaux.display();
        run__wrappee__DFS( s );
    }
    public void sortVertices(Comparator c)
    {
        Collections.sort(vertices, c);
    }
    public void addVertex( Vertex v )
    {
        vertices.add( v );
    }
    public VertexIter getVertices()
    {
        return new VertexIter() {
            private Iterator iter = vertices.iterator();
            public Vertex next() {
                return (Vertex)iter.next();
            }
            public boolean hasNext() {
                return iter.hasNext();
            }
        };
    }
    public void GraphSearch( WorkSpace w )
    {
        VertexIter vxiter = getVertices( );
        if(vxiter.hasNext( ) == false) { //1
            return;
        }
        while( vxiter.hasNext( ) ) { //1
            Vertex v = vxiter.next( );
            v.init_vertex( w );
        }
        for( vxiter = getVertices( ); vxiter.hasNext( ); ) { //1
            Vertex v = vxiter.next( );
            if(!v.visited) { //1
                w.nextRegionAction( v );
                v.nodeSearch( w );
            }
        }
    }
    public  Vertex findsVertex( String theName )
    {
        Vertex theVertex = null;
        if(theName==null) { //1
            return null;
        }
        for(VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) { //1
            theVertex = vxiter.next( );
            if(theName.equals( theVertex.getName( ) )) { //1
                return theVertex;
            }
        }
        return theVertex;
    }
    public  Graph ComputeTranspose( Graph the_graph )
    {
        int i;
        String theName;
        Map newVertices = new HashMap( );
        Graph newGraph = new  Graph();
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) { //1
            theName = vxiter.next().getName();
            Vertex v = new  Vertex( ).assignName( theName );
            newGraph.addVertex( v );
            newVertices.put( theName, v );
        }
        Vertex theVertex, newVertex;
        Vertex theNeighbor;
        Vertex newAdjacent;
        EdgeIfc newEdge;
        VertexIter newvxiter = newGraph.getVertices( );
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) { //2
            theVertex = vxiter.next();
            newAdjacent = newvxiter.next( );
            for( VertexIter neighbors = theVertex.getNeighbors(); neighbors.hasNext(); ) { //1
                theNeighbor = neighbors.next();
                newVertex = ( Vertex ) newVertices.get( theNeighbor.getName( ) );
                newEdge = newGraph.addEdge( newVertex, newAdjacent );
            }
        }
        return newGraph;
    }
    private void  run__wrappee__DirectedWithNeighbors  ( Vertex s )
    {
    }
}
