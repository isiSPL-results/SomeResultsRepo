// Compilation Unit of /ActionCreatePseudostate.java 
 
package org.argouml.uml.diagram.state.ui;
import org.argouml.model.Model;
import org.argouml.ui.CmdCreateNode;
public class ActionCreatePseudostate extends CmdCreateNode
  { 
public ActionCreatePseudostate(Object kind, String name)
    { 
super(kind, name);
if(!Model.getFacade().isAPseudostateKind(kind))//1
{ 
throw new IllegalArgumentException();
} 

setArg("className", Model.getMetaTypes().getPseudostate());
setArg("kind", kind);
} 

public Object makeNode()
    { 
Object newNode = super.makeNode();
Object kind = getArg("kind");
Model.getCoreHelper().setKind(newNode, kind);
return newNode;
} 

 } 


