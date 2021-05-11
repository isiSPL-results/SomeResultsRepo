
//#if 2101973141 
// Compilation Unit of /ActionCreatePseudostate.java 
 

//#if -906003733 
package org.argouml.uml.diagram.state.ui;
//#endif 


//#if 1874099218 
import org.argouml.model.Model;
//#endif 


//#if -1029943934 
import org.argouml.ui.CmdCreateNode;
//#endif 


//#if -283954837 
public class ActionCreatePseudostate extends 
//#if -2128400396 
CmdCreateNode
//#endif 

  { 

//#if 1303161736 
public ActionCreatePseudostate(Object kind, String name)
    { 

//#if 418278250 
super(kind, name);
//#endif 


//#if -853249029 
if(!Model.getFacade().isAPseudostateKind(kind))//1
{ 

//#if 1616593461 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if 509246905 
setArg("className", Model.getMetaTypes().getPseudostate());
//#endif 


//#if 321033968 
setArg("kind", kind);
//#endif 

} 

//#endif 


//#if 1238435965 
public Object makeNode()
    { 

//#if 1690538706 
Object newNode = super.makeNode();
//#endif 


//#if 542400391 
Object kind = getArg("kind");
//#endif 


//#if 349322332 
Model.getCoreHelper().setKind(newNode, kind);
//#endif 


//#if 1421750004 
return newNode;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

