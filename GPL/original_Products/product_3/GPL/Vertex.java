package GPL;

import java.util.Iterator;

import java.util.LinkedList;

import java.lang.Integer;
import java.util.Collections;
import java.util.Comparator;

// *************************************************************************

public   class  Vertex
{

    public LinkedList neighbors;


    public String name;



    public Vertex( )
    {
        VertexConstructor( );
    }



    private void  VertexConstructor__wrappee__MSTPrim  ( )
    {
        name      = null;
        neighbors = new LinkedList( );
    }



    public void VertexConstructor( )
    {
        VertexConstructor__wrappee__MSTPrim();
        visited = false;
    }



    public  Vertex assignName( String name )
    {
        this.name = name;
        return ( Vertex ) this;
    }



    public String getName( )
    {
        return this.name;
    }



    public LinkedList getNeighborsObj( )
    {
        return neighbors;
    }




    public VertexIter getNeighbors( )
    {
        return new VertexIter( ) {
            private Iterator iter = neighbors.iterator( );
            public Vertex next( ) {
                return ( ( Neighbor )iter.next( ) ).end;
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
    }



    private void  display__wrappee__UndirectedWithEdges  ( )
    {
        System.out.print( " Node " + name + " connected to: " );

        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) {
            System.out.print( vxiter.next().getName() + ", " );
        }

        System.out.println( );
    }



    private void  display__wrappee__Number  ( )
    {
        System.out.print( " # "+ VertexNumber + " " );
        display__wrappee__UndirectedWithEdges( );
    }

    // weight so far from s to it

    private void  display__wrappee__MSTPrim  ( )
    {
        System.out.print( " Pred " + pred + " Key " + key + " " );
        display__wrappee__Number( );
    }

    // of bfsNodeSearch

    public void display( )
    {
        if ( visited ) {
            System.out.print( "  visited " );
        } else {
            System.out.println( " !visited " );
        }
        display__wrappee__MSTPrim( );
    }


//--------------------
// differences
//--------------------

    public void addNeighbor( Neighbor n )
    {
        neighbors.add( n );
    }



    public EdgeIter getEdges( )
    {
        return new EdgeIter( ) {
            private Iterator iter = neighbors.iterator( );
            public EdgeIfc next( ) {
                return ( ( EdgeIfc ) ( ( Neighbor )iter.next( ) ).edge );
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
    }


    public int VertexNumber;


    public String pred;

    // the predecessor vertex if any
    public int key;


    public boolean visited;



    public void init_vertex( WorkSpace w )
    {
        visited = false;
        w.init_vertex( ( Vertex ) this );
    }



    public void nodeSearch( WorkSpace w )
    {
        int     s, c;
        Vertex  v;
        Vertex  header;

        // Step 1: if preVisitAction is true or if we've already
        //         visited this node
        w.preVisitAction( ( Vertex ) this );

        if ( visited ) {
            return;
        }

        // Step 2: Mark as visited, put the unvisited neighbors in the queue
        //     and make the recursive call on the first element of the queue
        //     if there is such if not you are done
        visited = true;

        // Step 3: do postVisitAction now, you are no longer going through the
        // node again, mark it as black
        w.postVisitAction( ( Vertex ) this );

        // enqueues the vertices not visited
        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) {
            v = vxiter.next( );

            // if your neighbor has not been visited then enqueue
            if ( !v.visited ) {
                GlobalVarsWrapper.Queue.add( v );
            }

        } // end of for

        // while there is something in the queue
        while( GlobalVarsWrapper.Queue.size( )!= 0 ) {
            header = ( Vertex ) GlobalVarsWrapper.Queue.get( 0 );
            GlobalVarsWrapper.Queue.remove( 0 );
            header.nodeSearch( w );
        }
    }


}
