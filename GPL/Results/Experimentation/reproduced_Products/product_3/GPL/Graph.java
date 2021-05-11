package GPL;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.lang.Integer;
import java.util.Set;
import java.util.HashSet;
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
    public EdgeIfc addEdge(Vertex start,  Vertex end)
    {
        Edge theEdge = new  Edge();
        theEdge.EdgeConstructor( start, end );
        edges.add( theEdge );
        start.addNeighbor( new  Neighbor( end, theEdge ) );
        end.addNeighbor( new  Neighbor( start, theEdge ) );
        return theEdge;
    }
    public void NumberVertices( )
    {
        GraphSearch( new NumberWorkSpace( ) );
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
    public void run( Vertex s )
    {
        System.out.println("MSTPrim");
        Graph gaux = Prim( s );
        gaux.display();
        run__wrappee__Number( s );
    }
    private void  run__wrappee__Number  ( Vertex s )
    {
        System.out.println("Number");
        NumberVertices( );
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
    public  Graph Prim( Vertex r )
    {
        Vertex root;
        root = r;
        Vertex x;
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) { //1
            x = vxiter.next();
            x.pred = null;
            x.key = Integer.MAX_VALUE;
        }
        root.key = 0;
        root.pred = null;
        LinkedList Queue = new LinkedList();
        Set indx = new HashSet( );
        Queue.add( root );
        indx.add( root.getName( ) );
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) { //2
            x = vxiter.next();
            if(x.key != 0) { //1
                Queue.add( x );
                indx.add( x.getName( ) );
            }
        }
        Vertex ucurrent;
        int j,k,l;
        int pos;
        LinkedList Uneighbors;
        Vertex u,v;
        EdgeIfc en;
        NeighborIfc vn;
        int wuv;
        boolean isNeighborInQueue = false;
        while ( Queue.size()!=0 ) { //1
            u = ( Vertex )Queue.removeFirst();
            indx.remove( u.getName( ) );
            Uneighbors = u.getNeighborsObj( );
            k = 0;
            for( EdgeIter edgeiter = u.getEdges(); edgeiter.hasNext(); k++ ) { //1
                vn = ( NeighborIfc )Uneighbors.get( k );
                en = edgeiter.next();
                v = en.getOtherVertex(u);
                isNeighborInQueue = false;
                if(indx.contains( v.getName( ) )) { //1
                    isNeighborInQueue = true;
                }
                wuv = en.getWeight();
                if(isNeighborInQueue && ( wuv < v.key )) { //1
                    v.key = wuv;
                    v.pred = u.getName();
                    Uneighbors.set( k,vn );
                    Object residue = ( Object ) v;
                    Queue.remove( residue );
                    indx.remove( v.getName( ) );
                    int position = Collections.binarySearch( Queue,v,
                    new Comparator() {
                        public int compare( Object o1, Object o2 ) {
                            Vertex v1 = ( Vertex )o1;
                            Vertex v2 = ( Vertex )o2;

                            if ( v1.key < v2.key ) {
                                return -1;
                            }
                            if ( v1.key == v2.key ) {
                                return 0;
                            }
                            return 1;
                        }
                    } );
                    if(position < 0) { //1
                        Queue.add( - ( position+1 ),v );
                    } else {
                        Queue.add( position,v );
                    }
                    indx.add( v.getName( ) );
                }
            }
        }
        String theName;
        Graph newGraph = new  Graph();
        for ( VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) { //3
            Vertex vtx = vxiter.next( );
            theName = vtx.name;
            newGraph.addVertex( new  Vertex().assignName( theName ) );
        }
        Vertex theVertex, thePred;
        Vertex theNewVertex, theNewPred;
        EdgeIfc   e;
        for ( VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) { //4
            theVertex = vxiter.next( );
            thePred = findsVertex( theVertex.pred );
            if(thePred==null) { //1
                continue;
            }
            theNewVertex = newGraph.findsVertex( theVertex.name );
            theNewPred = newGraph.findsVertex( thePred.name );
            EdgeIfc theNewEdge = newGraph.addEdge( theNewPred, theNewVertex );
            e = findsEdge( thePred,theVertex );
            theNewEdge.adjustAdorns( e );
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
