package GPL;

import java.util.Iterator;

import java.util.LinkedList;

import java.lang.Integer;
import java.util.Collections;
import java.util.Comparator;

// of Graph

// The weighted layer needs to extend Vertex to provide a new
// LinkedList to hold the  weigths  of the edges
// ************************************************************

public   class  Vertex
{

    public LinkedList adjacentNeighbors;


    public String name;



    public Vertex()
    {
        VertexConstructor();
    }


    public String getName( )
    {
        return name;
    }



    private void  VertexConstructor__wrappee__Cycle  ()
    {
        name      = null;
        adjacentNeighbors = new LinkedList();
    }



    private void  VertexConstructor__wrappee__WeightedWithEdges  ( )
    {
        VertexConstructor__wrappee__Cycle( );
        visited = false;
    }



    public void VertexConstructor()
    {
        VertexConstructor__wrappee__WeightedWithEdges();
        weightsList = new LinkedList();
    }



    public  Vertex assignName( String name )
    {
        this.name = name;
        return ( Vertex ) this;
    }



    public void addEdge( Neighbor n )
    {
        adjacentNeighbors.add( n );
    }




    public VertexIter getNeighbors( )
    {
        return new VertexIter( ) {
            private Iterator iter = adjacentNeighbors.iterator( );
            public Vertex next( ) {
                return ( ( Neighbor )iter.next( ) ).neighbor;
            }

            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
    }



    public void adjustAdorns( Neighbor sourceNeighbor )
    {}



    private void  display__wrappee__DirectedWithNeighbors  ()
    {
        System.out.print( "Node " + getName( ) + " connected to: " );

        for(VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) {
            Vertex v = vxiter.next( );
            System.out.print( v.getName( ) + ", " );
        }
        System.out.println( );
    }

    // white ->0, gray ->1, black->2

    private void  display__wrappee__Cycle  ()
    {
        System.out.print( " VertexCycle# " + VertexCycle + " " );
        display__wrappee__DirectedWithNeighbors();
    }

    // of dftNodeSearch

    private void  display__wrappee__DFS  ( )
    {
        if ( visited ) {
            System.out.print( "  visited" );
        } else {
            System.out.println( " !visited " );
        }
        display__wrappee__Cycle( );
    }



    private void  display__wrappee__WeightedWithEdges  ()
    {
        System.out.print( " FinishTime -> " + finishTime + " SCCNo -> "
                          + strongComponentNumber );
        display__wrappee__DFS();
    }



    public void display()
    {
        int s = weightsList.size();
        int i;

        System.out.print( " Weights : " );

        for ( i=0; i<s; i++ ) {
            System.out.print( ( ( Integer )weightsList.get( i ) ).intValue() + ", " );
        }

        display__wrappee__WeightedWithEdges();
    }


    public int VertexCycle;


    public int VertexColor;


    public boolean visited;



    public void init_vertex( WorkSpace w )
    {
        visited = false;
        w.init_vertex( ( Vertex ) this );
    }



    public void nodeSearch( WorkSpace w )
    {
        Vertex v;

        // Step 1: Do preVisitAction.
        //            If we've already visited this node return
        w.preVisitAction( ( Vertex ) this );

        if ( visited ) {
            return;
        }

        // Step 2: else remember that we've visited and
        //         visit all neighbors
        visited = true;

        for ( VertexIter  vxiter = getNeighbors(); vxiter.hasNext(); ) {
            v = vxiter.next( );
            w.checkNeighborAction( ( Vertex ) this, v );
            v.nodeSearch( w );
        }

        // Step 3: do postVisitAction now
        w.postVisitAction( ( Vertex ) this );
    }


    public int finishTime;


    public int strongComponentNumber;


    public LinkedList weightsList;



    public void addWeight( int weight )
    {
        weightsList.add( new Integer( weight ) );
    }



    public void adjustAdorns( Vertex the_vertex, int index )
    {
        int the_weight = ( ( Integer )the_vertex.weightsList.get( index ) ).intValue();
        weightsList.add( new Integer( the_weight ) );
        original( the_vertex, index );
    }


}
