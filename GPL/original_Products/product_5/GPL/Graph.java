package GPL;

import java.util.Iterator;

import java.util.LinkedList;
//dja: added to fix compile problems when doing the performance improvements
import java.util.Comparator;
import java.util.Collections;

import java.lang.Integer;

//dja: added for performance improvement
import java.util.HashMap;
import java.util.Map;

// ************************************************************

public   class  Graph
{

    public LinkedList vertices;


    public static boolean isDirected = true;



    public Graph()
    {
        vertices = new LinkedList();
    }



    // Fall back method that stops the execution of programs
    private void  run__wrappee__DirectedWithNeighbors  ( Vertex s )
    { }



    // Executes Cycle Checking
    private void  run__wrappee__DFS  ( Vertex s )
    {
        System.out.println( "Cycle? " + CycleCheck() );
        run__wrappee__DirectedWithNeighbors( s );
    }



    // Executes Strongly Connected Components
    public void run( Vertex s )
    {
        System.out.println("StronglyConnected");
        Graph gaux = StrongComponents();
//        Graph.stopProfile();
        gaux.display();
//        Graph.resumeProfile();
        run__wrappee__DFS( s );
    }



    //dja: fix for compile problems during performance improvements
    public void sortVertices(Comparator c)
    {
        Collections.sort(vertices, c);
    }




    // Adds an edge without weights if Weighted layer is not present
//    public void addAnEdge( Vertex start,  Vertex end, int weight )
    //    {
    //    addEdge( start, new  Neighbor( end ) );
//    }

    // Adds an edge without weights if Weighted layer is not present
    public EdgeIfc addEdge( Vertex start,  Vertex end )
    {
        Neighbor e = new Neighbor( end );
        addEdge( start, e );
        return e;
    }




    public void addVertex( Vertex v )
    {
        vertices.add( v );
    }



    public void addEdge( Vertex start,  Neighbor theNeighbor )
    {
        start.addEdge( theNeighbor );
    }



    // Finds a vertex given its name in the vertices list
    public  Vertex findsVertex( String theName )
    {
        Vertex theVertex = null;

        // if we are dealing with the root
        if ( theName==null ) {
            return null;
        }

        for(VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) {
            theVertex = vxiter.next( );
            if ( theName.equals( theVertex.getName( ) ) ) {
                return theVertex;
            }
        }

        return theVertex;
    }



    public VertexIter getVertices( )
    {
        return new VertexIter( ) {
            private Iterator iter = vertices.iterator( );
            public Vertex next( ) {
                return (Vertex)iter.next( );
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
    }




    private void  display__wrappee__WeightedWithEdges  ( )
    {
        System.out.println( "******************************************" );
        System.out.println( "Vertices " );
        for ( VertexIter vxiter = getVertices( ); vxiter.hasNext( ) ; ) {
            vxiter.next( ).display( );
        }
        System.out.println( "******************************************" );

    }



    public void display()
    {
        display__wrappee__WeightedWithEdges();
    }



    public boolean CycleCheck()
    {
        CycleWorkSpace c = new CycleWorkSpace( isDirected );
        GraphSearch( c );
        return c.AnyCycles;
    }


    public void GraphSearch( WorkSpace w )
    {
        // Step 1: initialize visited member of all nodes
        VertexIter vxiter = getVertices( );
        if ( vxiter.hasNext( ) == false ) {
            return; // if there are no vertices return
        }

        // Initializing the vertices
        while( vxiter.hasNext( ) ) {
            Vertex v = vxiter.next( );
            v.init_vertex( w );
        }

        // Step 2: traverse neighbors of each node
        for( vxiter = getVertices( ); vxiter.hasNext( ); ) {
            Vertex v = vxiter.next( );
            if ( !v.visited ) {
                w.nextRegionAction( v );
                v.nodeSearch( w );
            }
        }
    }



    public  Graph StrongComponents()
    {

        FinishTimeWorkSpace FTWS = new FinishTimeWorkSpace();

        // 1. Computes the finishing times for each vertex
        GraphSearch( FTWS );

        // 2. Order in decreasing  & call DFS Transposal
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

        // 3. Compute the transpose of G
        // Done at layer transpose
        Graph gaux = ComputeTranspose( ( Graph )this );

        // 4. Traverse the transpose G
        WorkSpaceTranspose WST = new WorkSpaceTranspose();
        gaux.GraphSearch( WST );

        return gaux;

    }



    public  Graph ComputeTranspose( Graph the_graph )
    {
        int i;
        String theName;

        //dja: added for performance improvement
        Map newVertices = new HashMap( );

        // Creating the new Graph
        Graph newGraph = new  Graph();

        // Creates and adds the vertices with the same name
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) {
            theName = vxiter.next().getName();
            //dja: changes for performance improvement
            Vertex v = new  Vertex( ).assignName( theName );
//            newGraph.addVertex( new  Vertex().assignName( theName ) );
            newGraph.addVertex( v );

            //dja: added for performance improvement
            newVertices.put( theName, v );
        }

        Vertex theVertex, newVertex;
        Vertex theNeighbor;
        Vertex newAdjacent;
        EdgeIfc newEdge;

        // adds the transposed edges
        // dja: added line below for performance improvements
        VertexIter newvxiter = newGraph.getVertices( );
        for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) {
            // theVertex is the original source vertex
            // the newAdjacent is the reference in the newGraph to theVertex
            theVertex = vxiter.next();

            // dja: performance improvement fix
            // newAdjacent = newGraph.findsVertex( theVertex.getName() );
            newAdjacent = newvxiter.next( );

            for( VertexIter neighbors = theVertex.getNeighbors(); neighbors.hasNext(); ) {
                // Gets the neighbor object
                theNeighbor = neighbors.next();

                // the new Vertex is the vertex that was adjacent to theVertex
                // but now in the new graph
                // dja: performance improvement fix
                // newVertex = newGraph.findsVertex( theNeighbor.getName() );
                newVertex = ( Vertex ) newVertices.get( theNeighbor.getName( ) );

                // Creates a new Edge object and adjusts the adornments
                newEdge = newGraph.addEdge( newVertex, newAdjacent );
                //newEdge.adjustAdorns( theNeighbor.edge );

                // Adds the new Neighbor object with the newly formed edge
                // newNeighbor = new $TEqn.Neighbor(newAdjacent, newEdge);
                // (newVertex.neighbors).add(newNeighbor);

            } // all adjacentNeighbors
        } // all the vertices

        return newGraph;

    }


    // Adds an edge with weights
    public void addAnEdge( Vertex start,  Vertex end, int weight )
    {
        addEdge( start,end, weight );
    }



    public void addEdge( Vertex start,  Vertex end, int weight )
    {
        addEdge( start,end ); // adds the start and end as adjacent
        start.addWeight( weight ); // the direction layer takes care of that

        // if the graph is undirected you have to include
        // the weight of the edge coming back
        if ( isDirected==false ) {
            end.addWeight( weight );
        }
    }


}
