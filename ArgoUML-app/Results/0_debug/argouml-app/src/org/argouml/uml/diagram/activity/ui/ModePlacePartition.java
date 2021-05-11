
//#if 1678876903 
// Compilation Unit of /ModePlacePartition.java 
 

//#if 954930037 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -377048858 
import java.awt.event.MouseEvent;
//#endif 


//#if -1517587676 
import org.tigris.gef.base.ModePlace;
//#endif 


//#if 82833231 
import org.tigris.gef.graph.GraphFactory;
//#endif 


//#if 805302858 
public class ModePlacePartition extends 
//#if -1724281183 
ModePlace
//#endif 

  { 

//#if -1541441645 
private Object machine;
//#endif 


//#if 1729405732 
public ModePlacePartition(GraphFactory gf, String instructions,
                              Object activityGraph)
    { 

//#if 1362536687 
super(gf, instructions);
//#endif 


//#if -112725862 
machine = activityGraph;
//#endif 

} 

//#endif 


//#if 1491379440 
@Override
    public void mouseReleased(MouseEvent me)
    { 

//#if 363610600 
if(me.isConsumed())//1
{ 

//#if 298563953 
return;
//#endif 

} 

//#endif 


//#if -1167266206 
FigPartition fig = (FigPartition) _pers;
//#endif 


//#if -1022574811 
super.mouseReleased(me);
//#endif 


//#if 752074126 
fig.appendToPool(machine);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

