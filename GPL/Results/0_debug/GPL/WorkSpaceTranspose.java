
//#if 1090407048 
// Compilation Unit of /WorkSpaceTranspose.java 
 

//#if 723405167 
package GPL;
//#endif 


//#if 1666134672 
import java.util.LinkedList;
//#endif 


//#if -104871686 
import java.util.Collections;
//#endif 


//#if -1718170639 
import java.util.Comparator;
//#endif 


//#if 1506645796 
public class WorkSpaceTranspose extends 
//#if 138409870 
WorkSpace
//#endif 

  { 

//#if -556460054 
int SCCCounter;
//#endif 


//#if -1185396683 
public WorkSpaceTranspose()
    { 

//#if -1696202647 
SCCCounter = 0;
//#endif 

} 

//#endif 


//#if 1895301245 
public void preVisitAction( Vertex v )
    { 

//#if 1963225117 
if(v.visited!=true)//1
{ 

//#if -1310291107 
v.strongComponentNumber = SCCCounter;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1485185986 
public void nextRegionAction( Vertex v )
    { 

//#if -171760261 
SCCCounter++;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

