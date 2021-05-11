package org.argouml.uml.ui;
import org.argouml.uml.diagram.DiagramFactory;
import org.argouml.uml.diagram.ArgoDiagram;
public final class ActionSequenceDiagram extends ActionNewDiagram
  { 
public ActionSequenceDiagram()
    { 
super("action.sequence-diagram");
} 
public ArgoDiagram createDiagram(Object namespace)
    { 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Sequence,



                   createCollaboration(

                       namespace



                   )

                   ,
                   null);
} 

 } 
