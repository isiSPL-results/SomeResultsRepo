package GPL;
import java.util.Iterator;
import java.util.LinkedList;
public class Vertex
{
    public String name;
    public boolean visited;
    public int componentNumber;
    public LinkedList adjacentNeighbors;
    private void  display__wrappee__UndirectedWithNeighbors  ( )
    {
        System.out.print( "Node " + name + " connected to: " );
        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) { //1
            System.out.print( vxiter.next( ).getName( ) + ", " );
        }
        System.out.println();
    }
    public void init_vertex( WorkSpace w )
    {
        visited = false;
        w.init_vertex( ( Vertex ) this );
    }
    public void adjustAdorns( Neighbor sourceNeighbor )
    {
    }
    public String getName( )
    {
        return this.name;
    }
    public  Vertex assignName( String name )
    {
        this.name = name;
        return ( Vertex ) this;
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
    public EdgeIter getEdges( )
    {
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
    }
    public void display()
    {
        if(visited) { //1
            System.out.print( "  visited" );
        } else {
            System.out.println( " !visited " );
        }
        display__wrappee__Connected( );
    }
    public void VertexConstructor( )
    {
        VertexConstructor__wrappee__Connected();
        visited = false;
    }
    public void addEdge( Neighbor n )
    {
        adjacentNeighbors.add( n );
    }
    private void  VertexConstructor__wrappee__Connected  ()
    {
        name      = null;
        adjacentNeighbors = new LinkedList();
    }
    public LinkedList getNeighborsObj( )
    {
        return adjacentNeighbors;
    }
    public Vertex( )
    {
        VertexConstructor( );
    }
    public void nodeSearch( WorkSpace w )
    {
        int     s, c;
        Vertex v;
        Vertex  header;
        w.preVisitAction( ( Vertex ) this );
        if(visited) { //1
            return;
        }
        visited = true;
        w.postVisitAction( ( Vertex ) this );
        for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) { //1
            v = vxiter.next( );
            if(!v.visited) { //1
                GlobalVarsWrapper.Queue.add( v );
            }
        }
        while( GlobalVarsWrapper.Queue.size( )!= 0 ) { //1
            header = ( Vertex ) GlobalVarsWrapper.Queue.get( 0 );
            GlobalVarsWrapper.Queue.remove( 0 );
            header.nodeSearch( w );
        }
    }
    private void  display__wrappee__Connected  ( )
    {
        System.out.print( " comp# "+ componentNumber + " " );
        display__wrappee__UndirectedWithNeighbors( );
    }

}
