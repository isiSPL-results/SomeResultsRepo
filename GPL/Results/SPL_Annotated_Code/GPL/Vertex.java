// Compilation Unit of /Vertex.java 
 
package GPL;
import java.util.Iterator;
import java.util.LinkedList;

//#if  WeightedWithEdges  
import java.lang.Integer;
//#endif 


//#if  WeightedWithEdges  
import java.util.Collections;
//#endif 


//#if  WeightedWithEdges  
import java.util.Comparator;
//#endif 

public class Vertex  { 

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges  
public LinkedList neighbors;
//#endif 

public String name;

//#if  MSTKruskal  
public  Vertex representative;
//#endif 


//#if  MSTKruskal  
public LinkedList members;
//#endif 

public boolean visited;

//#if  Number  
public int VertexNumber;
//#endif 


//#if  Connected  
public int componentNumber;
//#endif 


//#if  Cycle  
public int VertexCycle;
//#endif 


//#if  Cycle  
public int VertexColor;
//#endif 


//#if  MSTPrim  
public String pred;
//#endif 


//#if  MSTPrim  
public int key;
//#endif 


//#if  Unweighted  &&  WithNeighbors  
public LinkedList adjacentNeighbors;
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
public int finishTime;
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
public int strongComponentNumber;
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
public LinkedList weightsList;
//#endif 


//#if  MSTKruskal  
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


//#if  WeightedWithNeighbors  
display__wrappee__UndirectedWithEdges();
//#endif 


//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )  
display__wrappee__Cycle();
//#endif 

} 

//#endif 


//#if  UndirectedWithNeighbors  
private void  display__wrappee__UndirectedWithNeighbors  ( )
    { 
System.out.print( "Node " + name + " connected to: " );
for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) //1
{ 
System.out.print( vxiter.next( ).getName( ) + ", " );
} 

System.out.println();
} 

//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
public void adjustAdorns( Vertex the_vertex, int index )
    { 
int the_weight = ( ( Integer )the_vertex.weightsList.get( index ) ).intValue();
weightsList.add( new Integer( the_weight ) );
original( the_vertex, index );
} 

//#endif 

public void init_vertex( WorkSpace w )
    { 
visited = false;
w.init_vertex( ( Vertex ) this );
} 


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! MSTPrim  && ! Number  
public void adjustAdorns( Neighbor sourceNeighbor )
    { 

//#if  WeightedWithNeighbors  
Neighbor targetNeighbor =
            ( Neighbor )adjacentNeighbors.getLast();
//#endif 


//#if  WeightedWithNeighbors  
targetNeighbor.weight = sourceNeighbor.weight;
//#endif 


//#if  WeightedWithNeighbors  
original( sourceNeighbor );
//#endif 

} 

//#endif 


//#if  MSTKruskal  
private void  VertexConstructor__wrappee__MSTKruskal  ( )
    { 
name      = null;
neighbors = new LinkedList( );
} 

//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
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

//#endif 


//#if  Cycle  
private void  display__wrappee__Cycle  ()
    { 
System.out.print( " VertexCycle# " + VertexCycle + " " );

//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )  
display__wrappee__Connected();
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
display__wrappee__DirectedWithNeighbors();
//#endif 

} 

//#endif 


//#if  Number  
private void  display__wrappee__Number  ( )
    { 
System.out.print( " # "+ VertexNumber + " " );
display__wrappee__UndirectedWithEdges( );
} 

//#endif 

public String getName( )
    { 

//#if  Undirected  
return this.name;
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
return name;
//#endif 

} 

public  Vertex assignName( String name )
    { 
this.name = name;
return ( Vertex ) this;
} 


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! UndirectedWithNeighbors  && ! MSTPrim  && ! Number  && ! Connected  && ! BFS  
private void  display__wrappee__WeightedWithEdges  ( )
    { 

//#if  WeightedWithNeighbors  
if(visited)//1
{ 
System.out.print( "  visited" );
} 
else
{ 
System.out.println( " !visited " );
} 

//#endif 


//#if  WeightedWithNeighbors  
display__wrappee__MSTKruskal( );
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
System.out.print( " FinishTime -> " + finishTime + " SCCNo -> "
                          + strongComponentNumber );
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
display__wrappee__DFS();
//#endif 

} 

//#endif 


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges  
private void  display__wrappee__UndirectedWithEdges  ( )
    { 
System.out.print( " Node " + name + " connected to: " );
for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) //1
{ 
System.out.print( vxiter.next().getName() + ", " );
} 

System.out.println( );
} 

//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
public void addWeight( int weight )
    { 
weightsList.add( new Integer( weight ) );
} 

//#endif 

public VertexIter getNeighbors( )
    { 

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges  
return new VertexIter( ) {
            private Iterator iter = neighbors.iterator( );
            public Vertex next( ) {
                return ( ( Neighbor )iter.next( ) ).end;
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif 


//#if  Unweighted  &&  WithNeighbors  
return new VertexIter( ) {
            private Iterator iter = adjacentNeighbors.iterator( );
            public Vertex next( ) {
                return ( ( Neighbor )iter.next( ) ).neighbor;
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif 

} 


//#if  Undirected  
public EdgeIter getEdges( )
    { 

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges  
return new EdgeIter( ) {
            private Iterator iter = neighbors.iterator( );
            public EdgeIfc next( ) {
                return ( ( EdgeIfc ) ( ( Neighbor )iter.next( ) ).edge );
            }
            public boolean hasNext( ) {
                return iter.hasNext( );
            }
        };
//#endif 


//#if  UndirectedWithNeighbors  
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
//#endif 

} 

//#endif 


//#if  MSTPrim  
private void  VertexConstructor__wrappee__MSTPrim  ( )
    { 
name      = null;
neighbors = new LinkedList( );
} 

//#endif 

public void display()
    { 

//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
int s = weightsList.size();
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
int i;
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
System.out.print( " Weights : " );
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
for ( i=0; i<s; i++ ) //1
{ 
System.out.print( ( ( Integer )weightsList.get( i ) ).intValue() + ", " );
} 

//#endif 


//#if (  ( WeightedWithNeighbors  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  WeightedWithEdges  &&  DFS ) ||  ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  &&  Cycle  &&  DFS  &&  WeightedWithEdges  &&  Unweighted  &&  WithNeighbors ) ) && ! UndirectedWithNeighbors  && ! MSTPrim  && ! Number  && ! Connected  && ! BFS  
display__wrappee__WeightedWithEdges();
//#endif 


//#if (  ( MSTPrim  &&  BFS  &&  Undirected  &&  Number  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  WeightedWithEdges ) ||  ( UndirectedWithNeighbors  &&  BFS  &&  Undirected  &&  Unweighted  &&  WithNeighbors  &&  Connected ) ||  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) ) && ! WeightedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  
if(visited)//1
{ 
System.out.print( "  visited" );
} 
else
{ 
System.out.println( " !visited " );
} 

//#endif 


//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )  
display__wrappee__MSTKruskal( );
//#endif 


//#if  MSTPrim  
display__wrappee__MSTPrim( );
//#endif 


//#if  UndirectedWithNeighbors  
display__wrappee__Connected( );
//#endif 

} 


//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges  
public void addNeighbor( Neighbor n )
    { 
neighbors.add( n );
} 

//#endif 


//#if  WeightedWithNeighbors  
public void addWeight( Vertex end, int theWeight )
    { 
Neighbor the_neighbor =
            ( Neighbor ) ( end.adjacentNeighbors ).removeLast();
the_neighbor.weight = theWeight;
( end.adjacentNeighbors ).add( the_neighbor );
} 

//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
private void  VertexConstructor__wrappee__WeightedWithEdges  ( )
    { 
VertexConstructor__wrappee__Cycle( );
visited = false;
} 

//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
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

//#endif 

public void VertexConstructor( )
    { 

//#if  MSTKruskal  
VertexConstructor__wrappee__MSTKruskal( );
//#endif 


//#if  MSTPrim  
VertexConstructor__wrappee__MSTPrim();
//#endif 


//#if  UndirectedWithNeighbors  
VertexConstructor__wrappee__Connected();
//#endif 


//#if  Undirected  
visited = false;
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
VertexConstructor__wrappee__WeightedWithEdges();
//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
weightsList = new LinkedList();
//#endif 

} 


//#if  Unweighted  &&  WithNeighbors  
public void addEdge( Neighbor n )
    { 
adjacentNeighbors.add( n );
} 

//#endif 


//#if  MSTPrim  
private void  display__wrappee__MSTPrim  ( )
    { 
System.out.print( " Pred " + pred + " Key " + key + " " );
display__wrappee__Number( );
} 

//#endif 


//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices  
private void  VertexConstructor__wrappee__Cycle  ()
    { 
name      = null;
adjacentNeighbors = new LinkedList();
} 

//#endif 


//#if  UndirectedWithNeighbors  
private void  VertexConstructor__wrappee__Connected  ()
    { 
name      = null;
adjacentNeighbors = new LinkedList();
} 

//#endif 


//#if  Undirected  
public LinkedList getNeighborsObj( )
    { 

//#if  UndirectedWithEdges  &&  Weighted  &&  WithEdges  
return neighbors;
//#endif 


//#if  UndirectedWithNeighbors  
return adjacentNeighbors;
//#endif 

} 

//#endif 

public Vertex( )
    { 
VertexConstructor( );
} 

public void nodeSearch( WorkSpace w )
    { 

//#if  BFS  
int     s, c;
//#endif 

Vertex v;

//#if  BFS  
Vertex  header;
//#endif 

w.preVisitAction( ( Vertex ) this );
if(visited)//1
{ 
return;
} 

visited = true;

//#if  DFS  
for ( VertexIter  vxiter = getNeighbors(); vxiter.hasNext(); ) //1
{ 
v = vxiter.next( );
w.checkNeighborAction( ( Vertex ) this, v );
v.nodeSearch( w );
} 

//#endif 

w.postVisitAction( ( Vertex ) this );

//#if  BFS  
for ( VertexIter vxiter = getNeighbors( ); vxiter.hasNext( ); ) //1
{ 
v = vxiter.next( );
if(!v.visited)//1
{ 
GlobalVarsWrapper.Queue.add( v );
} 

} 

//#endif 


//#if  BFS  
while( GlobalVarsWrapper.Queue.size( )!= 0 ) //1
{ 
header = ( Vertex ) GlobalVarsWrapper.Queue.get( 0 );
GlobalVarsWrapper.Queue.remove( 0 );
header.nodeSearch( w );
} 

//#endif 

} 


//#if  Connected  
private void  display__wrappee__Connected  ( )
    { 
System.out.print( " comp# "+ componentNumber + " " );

//#if  ( Cycle  &&  DFS  &&  WeightedWithEdges  &&  MSTKruskal  &&  UndirectedWithEdges  &&  Weighted  &&  WithEdges  &&  Undirected  &&  Number  &&  Connected ) && ! WeightedWithNeighbors  && ! UndirectedWithNeighbors  && ! ( DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices )  && ! MSTPrim  && ! BFS  && ! ( Unweighted  &&  WithNeighbors )  
display__wrappee__Number( );
//#endif 


//#if  UndirectedWithNeighbors  
display__wrappee__UndirectedWithNeighbors( );
//#endif 

} 

//#endif 

 } 


