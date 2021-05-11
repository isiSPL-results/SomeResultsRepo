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
    private LinkedList vertices;
    private LinkedList edges;
    public static final boolean isDirected = false;
    private Map verticesMap;
    public Graph()
    {
        vertices = new LinkedList();
        edges = new LinkedList();
        verticesMap = new HashMap( );
    }
    public  EdgeIfc findsEdge( Vertex theSource,
                               Vertex theTarget )
    {
        EdgeIfc theEdge;
        for( EdgeIter edgeiter = theSource.getEdges(); edgeiter.hasNext(); ) { //1
            theEdge = edgeiter.next();
            if(( theEdge.getStart().getName().equals( theSource.getName() ) &&
                    theEdge.getEnd().getName().equals( theTarget.getName() ) ) ||
                    ( theEdge.getStart().getName().equals( theTarget.getName() ) &&
                      theEdge.getEnd().getName().equals( theSource.getName() ) )) { //1
                return theEdge;
            }
        }
        return null;
    }
    public void addAnEdge( Vertex start,  Vertex end, int weight )
    {
        addEdge( start, new  Neighbor( end, weight ) );
    }
    public EdgeIfc addEdge(Vertex start,  Vertex end)
    {
        Edge theEdge = new  Edge();
        theEdge.EdgeConstructor( start, end );
        edges.add( theEdge );
        start.addNeighbor( new  Neighbor( end, theEdge ) );
        end.addNeighbor( new  Neighbor( start, theEdge ) );
        return theEdge;
    }
    public void addEdge( Vertex start,  Neighbor theNeighbor )
    {
        original( start,theNeighbor );
        if(isDirected==false) { //1
            Vertex end = theNeighbor.neighbor;
            end.addWeight( end,theNeighbor.weight );
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
        System.out.println( "Edges " );
        for ( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) { //1
            edgeiter.next().display();
        }
        System.out.println( "******************************************" );
    }
    public EdgeIter getEdges()
    {
        return new EdgeIter() {
            private Iterator iter = edges.iterator();
            public EdgeIfc next() {
                return (EdgeIfc)iter.next();
            }
            public boolean hasNext() {
                return iter.hasNext();
            }
        };
    }
    public void display()
    {
        display__wrappee__WeightedWithEdges();
    }
    public void run( Vertex s )
    {
        System.out.println("MSTKruskal");
        Graph gaux = Kruskal();
        gaux.display();
        run__wrappee__UndirectedWithEdges( s );
    }
    private void  run__wrappee__UndirectedWithEdges  ( Vertex s )
    {
    } protected void addVertex( Vertex v )
    {
        vertices.add( v );
        verticesMap.put( v.name, v );
    }
    public void sortVertices(Comparator c)
    {
        Collections.sort(vertices, c);
    }
    public void sortEdges(Comparator c)
    {
        Collections.sort(edges, c);
    }
    public  Graph Kruskal()
    {
        LinkedList A = new LinkedList();
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) { //1
            Vertex v = vxiter.next();
            v.representative = v;
            v.members = new LinkedList();
        }
        LinkedList Vneighbors = new LinkedList();
        sortEdges(
        new Comparator() {
            public int compare( Object o1, Object o2 ) {
                Edge e1 = ( Edge )o1;
                Edge e2 = ( Edge )o2;
                if ( e1.getWeight() < e2.getWeight() ) {
                    return -1;
                }
                if ( e1.getWeight() == e2.getWeight() ) {
                    return 0;
                }
                return 1;
            }
        } );
        Vertex vaux, urep, vrep;
        for( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) { //1
            EdgeIfc e1 = edgeiter.next();
            Vertex u = e1.getStart();
            Vertex v = e1.getEnd();
            if(! ( v.representative.getName() ).equals( u.representative.getName() )) { //1
                A.add( e1 );
                urep = u.representative;
                vrep = v.representative;
                if(( urep.members ).size() > ( vrep.members ).size()) { //1
                    for( int j=0; j< ( vrep.members ).size(); j++ ) { //1
                        vaux = ( Vertex ) ( vrep.members ).get( j );
                        vaux.representative = urep;
                        ( urep.members ).add( vaux );
                    }
                    v.representative = urep;
                    vrep.representative = urep;
                    ( urep.members ).add( v );
                    if(!v.equals( vrep )) { //1
                        ( urep.members ).add( vrep );
                    }
                    ( vrep.members ).clear();
                } else {
                    for( int j=0; j< ( urep.members ).size(); j++ ) { //1
                        vaux = ( Vertex ) ( urep.members ).get( j );
                        vaux.representative = vrep;
                        ( vrep.members ).add( vaux );
                    }
                    u.representative = vrep;
                    urep.representative = vrep;
                    ( vrep.members ).add( u );
                    if(!u.equals( urep )) { //1
                        ( vrep.members ).add( urep );
                    }
                    ( urep.members ).clear();
                }
            }
        }
        String theName;
        Graph newGraph = new  Graph();
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) { //2
            theName = vxiter.next().getName();
            newGraph.addVertex( new  Vertex().assignName( theName ) );
        }
        Vertex theStart, theEnd;
        Vertex theNewStart, theNewEnd;
        EdgeIfc   theEdge;
        for( int i=0; i<A.size(); i++ ) { //1
            theEdge = ( Edge )A.get( i );
            theStart = theEdge.getStart();
            theEnd = theEdge.getEnd();
            theNewStart = newGraph.findsVertex( theStart.getName() );
            theNewEnd = newGraph.findsVertex( theEnd.getName() );
            Edge theNewEdge = ( Edge ) newGraph.addEdge( theNewStart, theNewEnd );
            theNewEdge.adjustAdorns( ( Edge )  theEdge );
        }
        return newGraph;
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
