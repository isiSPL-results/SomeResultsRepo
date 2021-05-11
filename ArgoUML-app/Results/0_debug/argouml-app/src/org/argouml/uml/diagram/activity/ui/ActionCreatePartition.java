
//#if -889850703 
// Compilation Unit of /ActionCreatePartition.java 
 

//#if -310050419 
package org.argouml.uml.diagram.activity.ui;
//#endif 


//#if -439877556 
import org.argouml.model.Model;
//#endif 


//#if -1022075512 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if 470056291 
import org.tigris.gef.base.Mode;
//#endif 


//#if -1522102660 
public class ActionCreatePartition extends 
//#if -1905846870 
CmdCreateNode
//#endif 

  { 

//#if -1095877816 
private Object machine;
//#endif 


//#if -1500177507 
@Override
    protected Mode createMode(String instructions)
    { 

//#if 1547505632 
return new ModePlacePartition(this, instructions, machine);
//#endif 

} 

//#endif 


//#if -186732848 
public ActionCreatePartition(Object activityGraph)
    { 

//#if 1041812951 
super(Model.getMetaTypes().getPartition(),
              "button.new-partition");
//#endif 


//#if -738775234 
machine = activityGraph;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

