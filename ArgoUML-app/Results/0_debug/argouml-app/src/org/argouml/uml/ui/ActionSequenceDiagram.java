
//#if 1220237939 
// Compilation Unit of /ActionSequenceDiagram.java 
 

//#if 1437225682 
package org.argouml.uml.ui;
//#endif 


//#if -315780539 
import org.argouml.uml.diagram.DiagramFactory;
//#endif 


//#if -1208510080 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 217643561 
public final class ActionSequenceDiagram extends 
//#if 231459900 
ActionNewDiagram
//#endif 

  { 

//#if -1919725887 
public ActionSequenceDiagram()
    { 

//#if -432954689 
super("action.sequence-diagram");
//#endif 

} 

//#endif 


//#if -1542263076 
public ArgoDiagram createDiagram(Object namespace)
    { 

//#if -169541528 
return DiagramFactory.getInstance().createDiagram(
                   DiagramFactory.DiagramType.Sequence,



                   createCollaboration(

                       namespace



                   )

                   ,
                   null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

