package GPL;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Integer;
import java.util.Collections;
import java.util.Comparator;
public class Vertex  { 
public LinkedList neighbors;
public String name;
public  Vertex representative;
public LinkedList members;
public boolean visited;
private void  display__wrappee__MSTKruskal  ()
    { 
if(representative == null)//1
{ 
System.out.print( "Rep null " );
} 
else
{ 
System.out.print( " Rep " + representative.getName() + " " );
} 
display__wrappee__UndirectedWithEdges();
} 
public void init_vertex( WorkSpace w )
    { 
visited = false;
w.init_vertex( ( Vertex ) this );
} 
public void adjustAdorns( Neighbor sourceNeighbor )
    { 
Neighbor targetNeighbor =
            ( Neighbor )adjacentNeighbors.getLast();
targetNeighbor.weight = sourceNeighbor.weight;
original( sourceNeighbor );
} 
private void  VertexConstructor__wrappee__MSTKruskal  ( )
    { 
name      = null;
neighbors = new LinkedList( );
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
private void  display__wrappee__WeightedWithEdges  ( )
    { 
if(visited)//1
{ 
System.out.print( "  visited" );
} 
else
{ 
System.out.println( " !visited " );
} 
display__wrappee__MSTKruskal( );
} 
private void  display__wrappee__UndirectedWithEdges  ( )
    { 
System.out.print( " Node " + name + " connected to: " );
for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) //1
{ 
System.out.print( vxiter.next().getName() + ", " );
} 
System.out.println( );
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
public void display()
    { 
display__wrappee__WeightedWithEdges();
} 
public void addNeighbor( Neighbor n )
    { 
neighbors.add( n );
} 
public void addWeight( Vertex end, int theWeight )
    { 
Neighbor the_neighbor =
            ( Neighbor ) ( end.adjacentNeighbors ).removeLast();
the_neighbor.weight = theWeight;
( end.adjacentNeighbors ).add( the_neighbor );
} 
public void VertexConstructor( )
    { 
VertexConstructor__wrappee__MSTKruskal( );
visited = false;
} 
public LinkedList getNeighborsObj( )
    { 
return neighbors;
} 
public Vertex( )
    { 
VertexConstructor( );
} 
public void nodeSearch( WorkSpace w )
    { 
Vertex v;
w.preVisitAction( ( Vertex ) this );
if(visited)//1
{ 
return;
} 
visited = true;
for ( VertexIter  vxiter = getNeighbors(); vxiter.hasNext(); ) //1
{ 
v = vxiter.next( );
w.checkNeighborAction( ( Vertex ) this, v );
v.nodeSearch( w );
} 
w.postVisitAction( ( Vertex ) this );
} 

 } 
