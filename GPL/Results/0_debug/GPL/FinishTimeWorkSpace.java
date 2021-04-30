
//#if 467159974 
// Compilation Unit of /FinishTimeWorkSpace.java 
 

//#if 511562568 
package GPL;
//#endif 


//#if 7989865 
import java.util.LinkedList;
//#endif 


//#if 32246849 
import java.util.Collections;
//#endif 


//#if 918651850 
import java.util.Comparator;
//#endif 


//#if 838920956 
public class FinishTimeWorkSpace extends 
//#if 177358965 
WorkSpace
//#endif 

  { 

//#if 976255329 
int FinishCounter;
//#endif 


//#if -1975772339 
public FinishTimeWorkSpace()
    { 

//#if -2043647046 
FinishCounter = 1;
//#endif 

} 

//#endif 


//#if 2096090212 
public void preVisitAction( Vertex v )
    { 

//#if 643727518 
if(v.visited!=true)//1
{ 

//#if -95379848 
FinishCounter++;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 457294395 
public void postVisitAction( Vertex v )
    { 

//#if -2051892311 
v.finishTime = FinishCounter++;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

