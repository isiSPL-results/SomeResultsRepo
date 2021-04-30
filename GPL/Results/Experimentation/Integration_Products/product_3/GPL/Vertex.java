package GPL;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Integer;
import java.util.Collections;
import java.util.Comparator;
public class Vertex  { 
public LinkedList neighbors;
public String name;
public boolean visited;
public int VertexNumber;
public String pred;
public int key;
public void init_vertex( WorkSpace w )
    { 
visited = false;
w.init_vertex( ( Vertex ) this );
} 
private void  display__wrappee__Number  ( )
    { 
System.out.print( " # "+ VertexNumber + " " );
display__wrappee__UndirectedWithEdges( );
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
private void  VertexConstructor__wrappee__MSTPrim  ( )
    { 
name      = null;
neighbors = new LinkedList( );
} 
public void display()
    { 
if(visited)//1
{ 
System.out.print( "  visited" );
} 
else
{ 
System.out.println( " !visited " );
} 
display__wrappee__MSTPrim( );
} 
public void addNeighbor( Neighbor n )
    { 
neighbors.add( n );
} 
public void VertexConstructor( )
    { 
VertexConstructor__wrappee__MSTPrim();
visited = false;
} 
private void  display__wrappee__MSTPrim  ( )
    { 
System.out.print( " Pred " + pred + " Key " + key + " " );
display__wrappee__Number( );
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
int     s, c;
Vertex v;
Vertex  header;
w.preVisitAction( ( Vertex ) this );
if(visited)//1
{ 
return;
} 
visited = true;
w.postVisitAction( ( Vertex ) this );
for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) //1
{ 
v = vxiter.next( );
if(!v.visited)//1
{ 
GlobalVarsWrapper.Queue.add( v );
} 
} 
while( GlobalVarsWrapper.Queue.size( )!= 0 ) //1
{ 
header = ( Vertex ) GlobalVarsWrapper.Queue.get( 0 );
GlobalVarsWrapper.Queue.remove( 0 );
header.nodeSearch( w );
} 
} 

 } 
