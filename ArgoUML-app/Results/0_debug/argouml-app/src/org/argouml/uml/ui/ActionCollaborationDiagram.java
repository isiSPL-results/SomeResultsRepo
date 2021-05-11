
//#if -21812408 
// Compilation Unit of /ActionCollaborationDiagram.java 
 

//#if -1161200359 
package org.argouml.uml.ui;
//#endif 


//#if 683449502 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if 1017075143 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -294590684 
public class ActionCollaborationDiagram extends 
//#if -1395367505 
ActionNewDiagram
//#endif 

  { 

//#if -1211388430 
private static final long serialVersionUID = -1089352213298998155L;
//#endif 


//#if 1726245641 
public ArgoDiagram createDiagram(Object namespace)
    { 

//#if 52756920 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Collaboration,
                   createCollaboration(namespace),
                   null);
//#endif 

} 

//#endif 


//#if 668783444 
public ActionCollaborationDiagram()
    { 

//#if 6062746 
super("action.collaboration-diagram");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

