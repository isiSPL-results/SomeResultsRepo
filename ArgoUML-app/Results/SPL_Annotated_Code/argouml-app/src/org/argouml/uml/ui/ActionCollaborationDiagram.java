// Compilation Unit of /ActionCollaborationDiagram.java 
 
package org.argouml.uml.ui;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.ArgoDiagram;
public class ActionCollaborationDiagram extends ActionNewDiagram
  { 
private static final long serialVersionUID = -1089352213298998155L;
public ArgoDiagram createDiagram(Object namespace)
    { 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Collaboration,
                   createCollaboration(namespace),
                   null);
} 

public ActionCollaborationDiagram()
    { 
super("action.collaboration-diagram");
} 

 } 


