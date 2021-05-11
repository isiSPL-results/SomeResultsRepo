package GPL;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
public class Graph
{
    private Map verticesMap;
    public LinkedList vertices;
    public static boolean isDirected = false;
    public Graph()
    {
        vertices = new LinkedList();
        verticesMap = new HashMap( );
    }
    public  EdgeIfc findsEdge( Vertex theSource,
                               Vertex theTarget )
    {
        Vertex v1 = theSource;
        for( EdgeIter edgeiter = v1.getEdges(); edgeiter.hasNext(); ) { //1
            EdgeIfc theEdge = edgeiter.next();
            Vertex v2 = theEdge.getOtherVertex( v1 );
            if(( v1.getName().equals( theSource.getName() ) &&
                    v2.getName().equals( theTarget.getName() ) ) ||
                    ( v1.getName().equals( theTarget.getName() ) &&
                      v2.getName().equals( theSource.getName() ) )) { //1
                return theEdge;
            }
        }
        return null;
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
        Vertex end = theNeighbor.neighbor;
        end.addEdge( new  Neighbor( start ) );
    }
    public void display()
    {
        System.out.println( "******************************************" );
        System.out.println( "Vertices " );
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext() ; ) { //1
            vxiter.next().display();
        }
        System.out.println( "******************************************" );
    }
    public void run( Vertex s )
    {
        System.out.println("Connected");
        ConnectedComponents( );
        run__wrappee__UndirectedWithNeighbors( s );
    }
    public void ConnectedComponents( )
    {
        GraphSearch( new RegionWorkSpace( ) );
    }
    private void  run__wrappee__UndirectedWithNeighbors  ( Vertex s )
    {
    } public void addVertex( Vertex v )
    {
        vertices.add( v );
        verticesMap.put( v.name, v );
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
        Vertex theVertex;
        if(theName==null) { //1
            return null;
        }
        return ( Vertex ) verticesMap.get( theName );
    }

}
