package GPL;
import java.util.Iterator;
import java.util.LinkedList;
import java.lang.Integer;
import java.util.Collections;
import java.util.Comparator;
public class Vertex  { 
public String name;
public boolean visited;
public int VertexCycle;
public int VertexColor;
public LinkedList adjacentNeighbors;
public int finishTime;
public int strongComponentNumber;
public LinkedList weightsList;
public void adjustAdorns( Vertex the_vertex, int index )
    { 
int the_weight = ( ( Integer )the_vertex.weightsList.get( index ) ).intValue();
weightsList.add( new Integer( the_weight ) );
original( the_vertex, index );
} 
public void init_vertex( WorkSpace w )
    { 
visited = false;
w.init_vertex( ( Vertex ) this );
} 
public void adjustAdorns( Neighbor sourceNeighbor )
    { 
} 
private void  display__wrappee__DFS  ( )
    { 
if(visited)//1
{ 
System.out.print( "  visited" );
} 
else
{ 
System.out.println( " !visited " );
} 
display__wrappee__Cycle( );
} 
private void  display__wrappee__Cycle  ()
    { 
System.out.print( " VertexCycle# " + VertexCycle + " " );
display__wrappee__DirectedWithNeighbors();
} 
public String getName( )
    { 
return name;
} 
public  Vertex assignName( String name )
    { 
this.name = name;
return ( Vertex ) this;
} 
private void  display__wrappee__WeightedWithEdges  ( )
    { 
System.out.print( " FinishTime -> " + finishTime + " SCCNo -> "
                          + strongComponentNumber );
display__wrappee__DFS();
} 
public void addWeight( int weight )
    { 
weightsList.add( new Integer( weight ) );
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
public void display()
    { 
int s = weightsList.size();
int i;
System.out.print( " Weights : " );
for ( i=0; i<s; i++ ) //1
{ 
System.out.print( ( ( Integer )weightsList.get( i ) ).intValue() + ", " );
} 
display__wrappee__WeightedWithEdges();
} 
private void  VertexConstructor__wrappee__WeightedWithEdges  ( )
    { 
VertexConstructor__wrappee__Cycle( );
visited = false;
} 
private void  display__wrappee__DirectedWithNeighbors  ()
    { 
System.out.print( "Node " + getName( ) + " connected to: " );
for(VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) //1
{ 
Vertex v = vxiter.next( );
System.out.print( v.getName( ) + ", " );
} 
System.out.println( );
} 
public void VertexConstructor( )
    { 
VertexConstructor__wrappee__WeightedWithEdges();
weightsList = new LinkedList();
} 
public void addEdge( Neighbor n )
    { 
adjacentNeighbors.add( n );
} 
private void  VertexConstructor__wrappee__Cycle  ()
    { 
name      = null;
adjacentNeighbors = new LinkedList();
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
