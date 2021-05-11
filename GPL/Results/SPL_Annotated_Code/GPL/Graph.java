// Compilation Unit of /Graph.java

package GPL;
import java.util.LinkedList;
import java.util.Iterator;

//#if  WeightedWithEdges
import java.util.Collections;
//#endif


//#if  WeightedWithEdges
import java.util.Comparator;
//#endif

import java.util.HashMap;
import java.util.Map;

//#if  WeightedWithEdges
import java.lang.Integer;
//#endif


//#if  MSTPrim
import java.util.Set;
//#endif


//#if  MSTPrim
import java.util.HashSet;
//#endif

public class Graph
{

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    private LinkedList vertices;
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    private LinkedList edges;
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public static final boolean isDirected = false;
//#endif


//#if  Undirected
    private Map verticesMap;
//#endif


//#if  Unweighted  &&  WithNeighbors
    public LinkedList vertices;
//#endif


//#if  UndirectedWithNeighbors
    public static boolean isDirected = false;
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
    public static boolean isDirected = true;
//#endif

    public Graph()
    {
        vertices = new LinkedList();

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        edges = new LinkedList();
//#endif


//#if  Undirected
        verticesMap = new HashMap( );
//#endif

    }


//#if  Undirected
    public  EdgeIfc findsEdge( Vertex theSource,
                               Vertex theTarget )
    {

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        EdgeIfc theEdge;
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        for( EdgeIter edgeiter = theSource.getEdges(); edgeiter.hasNext(); ) { //1
            theEdge = edgeiter.next();
            if(( theEdge.getStart().getName().equals( theSource.getName() ) &&
                    theEdge.getEnd().getName().equals( theTarget.getName() ) ) ||
                    ( theEdge.getStart().getName().equals( theTarget.getName() ) &&
                      theEdge.getEnd().getName().equals( theSource.getName() ) )) { //1
                return theEdge;
            }

        }

//#endif


//#if  UndirectedWithNeighbors
        Vertex v1 = theSource;
//#endif


//#if  UndirectedWithNeighbors
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

//#endif

        return null;
    }

//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
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

//#endif


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! UndirectedWithNeighbors  && ! MSTPrim  && ! Number  && ! Connected  && ! BFS
    public void addAnEdge( Vertex start,  Vertex end, int weight )
    {

//#if  WeightedWithNeighbors
        addEdge( start, new  Neighbor( end, weight ) );
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        addEdge( start,end, weight );
//#endif

    }

//#endif


//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )
    private void  run__wrappee__Connected  ( Vertex s )
    {
        System.out.println("Connected");
        ConnectedComponents( );
        run__wrappee__Number( s );
    }

//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
    private void  run__wrappee__DFS  ( Vertex s )
    {
        System.out.println( "Cycle? " + CycleCheck() );
        run__wrappee__DirectedWithNeighbors( s );
    }

//#endif

    public EdgeIfc addEdge(Vertex start,  Vertex end)
    {

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        Edge theEdge = new  Edge();
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        theEdge.EdgeConstructor( start, end );
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        edges.add( theEdge );
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        start.addNeighbor( new  Neighbor( end, theEdge ) );
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        end.addNeighbor( new  Neighbor( start, theEdge ) );
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
        return theEdge;
//#endif


//#if  Unweighted  &&  WithNeighbors
        Neighbor e = new Neighbor( end );
//#endif


//#if  Unweighted  &&  WithNeighbors
        addEdge( start, e );
//#endif


//#if  Unweighted  &&  WithNeighbors
        return e;
//#endif

    }


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! MSTPrim  && ! Number
    public void addEdge( Vertex start,  Neighbor theNeighbor )
    {

//#if  WeightedWithNeighbors
        original( start,theNeighbor );
//#endif


//#if  WeightedWithNeighbors
        if(isDirected==false) { //1
            Vertex end = theNeighbor.neighbor;
            end.addWeight( end,theNeighbor.weight );
        }

//#endif


//#if  Unweighted  &&  WithNeighbors
        start.addEdge( theNeighbor );
//#endif


//#if  UndirectedWithNeighbors
        Vertex end = theNeighbor.neighbor;
//#endif


//#if  UndirectedWithNeighbors
        end.addEdge( new  Neighbor( start ) );
//#endif

    }

//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
    public void addEdge( Vertex start,  Vertex end, int weight )
    {
        addEdge( start,end );
        start.addWeight( weight );
        if(isDirected==false) { //1
            end.addWeight( weight );
        }

    }

//#endif


//#if  Number
    public void NumberVertices( )
    {
        GraphSearch( new NumberWorkSpace( ) );
    }

//#endif


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! UndirectedWithNeighbors  && ! MSTPrim  && ! Number  && ! Connected  && ! BFS
    private void  display__wrappee__WeightedWithEdges  ()
    {
        System.out.println( "******************************************" );
        System.out.println( "Vertices " );
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext() ; ) { //1
            vxiter.next().display();
        }

        System.out.println( "******************************************" );

//#if  WeightedWithNeighbors
        System.out.println( "Edges " );
//#endif


//#if  WeightedWithNeighbors
        for ( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) { //1
            edgeiter.next().display();
        }

//#endif


//#if  WeightedWithNeighbors
        System.out.println( "******************************************" );
//#endif

    }

//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
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

//#endif


//#if  Cycle
    public boolean CycleCheck()
    {
        CycleWorkSpace c = new CycleWorkSpace( isDirected );
        GraphSearch( c );
        return c.AnyCycles;
    }

//#endif

    public void display()
    {

//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! UndirectedWithNeighbors  && ! MSTPrim  && ! Number  && ! Connected  && ! BFS
        display__wrappee__WeightedWithEdges();
//#endif


//#if (  ( MSTPrim  &&  BFS  &&  Undirected  &&  Number  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  WeightedWithEdges ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) ) && ! WeightedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )
        System.out.println( "******************************************" );
//#endif


//#if (  ( MSTPrim  &&  BFS  &&  Undirected  &&  Number  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  WeightedWithEdges ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) ) && ! WeightedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )
        System.out.println( "Vertices " );
//#endif


//#if (  ( MSTPrim  &&  BFS  &&  Undirected  &&  Number  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  WeightedWithEdges ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) ) && ! WeightedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext() ; ) { //1
            vxiter.next().display();
        }

//#endif


//#if (  ( MSTPrim  &&  BFS  &&  Undirected  &&  Number  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  WeightedWithEdges ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) ) && ! WeightedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )
        System.out.println( "******************************************" );
//#endif


//#if  Number
        System.out.println( "Edges " );
//#endif


//#if  Number
        for ( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) { //1
            edgeiter.next().display();
        }

//#endif


//#if  Number
        System.out.println( "******************************************" );
//#endif

    }

    public void run( Vertex s )
    {

//#if  MSTKruskal
        System.out.println("MSTKruskal");
//#endif


//#if  MSTKruskal
        Graph gaux = Kruskal();
//#endif


//#if  MSTPrim
        System.out.println("MSTPrim");
//#endif


//#if  MSTPrim
        Graph gaux = Prim( s );
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        System.out.println("StronglyConnected");
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        Graph gaux = StrongComponents();
//#endif


//#if  WeightedWithEdges
        gaux.display();
//#endif


//#if  WeightedWithNeighbors
        run__wrappee__UndirectedWithEdges( s );
//#endif


//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )
        run__wrappee__Cycle( s );
//#endif


//#if  MSTPrim
        run__wrappee__Number( s );
//#endif


//#if  UndirectedWithNeighbors
        System.out.println("Connected");
//#endif


//#if  UndirectedWithNeighbors
        ConnectedComponents( );
//#endif


//#if  UndirectedWithNeighbors
        run__wrappee__UndirectedWithNeighbors( s );
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        run__wrappee__DFS( s );
//#endif

    }


//#if  Number
    private void  run__wrappee__Number  ( Vertex s )
    {
        System.out.println("Number");
        NumberVertices( );
        run__wrappee__UndirectedWithEdges( s );
    }

//#endif


//#if  Connected
    public void ConnectedComponents( )
    {
        GraphSearch( new RegionWorkSpace( ) );
    }

//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    private void  run__wrappee__UndirectedWithEdges  ( Vertex s )
    {
    }
//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    protected void addVertex( Vertex v )
    {
        vertices.add( v );
        verticesMap.put( v.name, v );
    }

//#endif


//#if  UndirectedWithNeighbors
    private void  run__wrappee__UndirectedWithNeighbors  ( Vertex s )
    {
    }
//#endif


//#if  WeightedWithEdges
    public void sortVertices(Comparator c)
    {
        Collections.sort(vertices, c);
    }

//#endif


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges
    public void sortEdges(Comparator c)
    {
        Collections.sort(edges, c);
    }

//#endif


//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )
    private void  run__wrappee__Cycle  ( Vertex s )
    {
        System.out.println( "Cycle? " + CycleCheck() );
        run__wrappee__Connected( s );
    }

//#endif


//#if  MSTPrim
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

//#endif


//#if  Unweighted  &&  WithNeighbors
    public void addVertex( Vertex v )
    {
        vertices.add( v );

//#if  UndirectedWithNeighbors
        verticesMap.put( v.name, v );
//#endif

    }

//#endif


//#if  MSTKruskal
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

//#endif

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

//#if  Undirected
        Vertex theVertex;
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        Vertex theVertex = null;
//#endif

        if(theName==null) { //1
            return null;
        }


//#if  Undirected
        return ( Vertex ) verticesMap.get( theName );
//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        for(VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) { //1
            theVertex = vxiter.next( );
            if(theName.equals( theVertex.getName( ) )) { //1
                return theVertex;
            }

        }

//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
        return theVertex;
//#endif

    }


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
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

//#endif


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
    private void  run__wrappee__DirectedWithNeighbors  ( Vertex s )
    {
    }
//#endif

}


