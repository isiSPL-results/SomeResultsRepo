package GPL;
import java.util.LinkedList;
public class Edge extends Neighbor
 implements EdgeIfc
  { 
public Vertex start;
private int weight;
private void  display__wrappee__DFS  ( )
    { 
System.out.println( " start=" + start.getName() + " end=" + end.getName( ) );
} 
public Vertex getOtherVertex( Vertex vertex )
    { 
if(vertex == start)//1
{ 
return end;
} 
else
if(vertex == end)//1
{ 
return start;
} 
else
{ 
return null;
} 
} 
public void setWeight  (int weight)
    { 
this.weight = weight;
} 
public Vertex getEnd( )
    { 
return end;
} 
public void EdgeConstructor( Vertex the_start, Vertex the_end )
    { 
start = the_start;
end = the_end;
} 
public void adjustAdorns( EdgeIfc the_edge )
    { 
setWeight(the_edge.getWeight());
adjustAdorns__wrappee__DFS( the_edge );
} 
public void EdgeConstructor( Vertex the_start,  Vertex the_end,
                                 int the_weight )
    { 
EdgeConstructor( the_start,the_end );
weight = the_weight;
} 
public Vertex getStart( )
    { 
return start;
} 
private void  adjustAdorns__wrappee__DFS  ( EdgeIfc the_edge )
    {
}public int getWeight  ()
    { 
return this.weight;
} 
public void display()
    { 
System.out.print( " Weight=" + weight );
display__wrappee__DFS();
} 

 } 
