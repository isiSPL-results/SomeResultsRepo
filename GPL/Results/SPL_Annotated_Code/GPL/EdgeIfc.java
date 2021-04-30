// Compilation Unit of /EdgeIfc.java 
 
package GPL;
public interface EdgeIfc  { 
public void display( );
public Vertex getStart( );
public void setWeight( int weight );
public void adjustAdorns( EdgeIfc the_edge );
public Vertex getEnd( );

//#if  WeightedWithEdges  
public int getWeight  ();
//#endif 

public Vertex getOtherVertex( Vertex vertex );
 } 


