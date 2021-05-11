
//#if -1297930983 
// Compilation Unit of /GoOperationToSequenceDiagram.java 
 

//#if -842615406 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1130192974 
import java.util.Collection;
//#endif 


//#if 676245621 
import java.util.Collections;
//#endif 


//#if -1328160522 
import java.util.HashSet;
//#endif 


//#if -44985784 
import java.util.Set;
//#endif 


//#if -914715747 
import org.argouml.i18n.Translator;
//#endif 


//#if -466142393 
import org.argouml.kernel.Project;
//#endif 


//#if 251775426 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1646505187 
import org.argouml.model.Model;
//#endif 


//#if 353014306 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 742024442 
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
//#endif 


//#if 1960012303 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if 1519633597 
public class GoOperationToSequenceDiagram extends 
//#if 939961613 
AbstractPerspectiveRule
//#endif 

  { 

//#if -702320165 
public String getRuleName()
    { 

//#if 1988975269 
return Translator.localize("misc.operation.sequence-diagram");
//#endif 

} 

//#endif 


//#if -111659801 
public Set getDependencies(Object parent)
    { 

//#if -1599760250 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -157103459 
public Collection getChildren(Object parent)
    { 

//#if 647285625 
if(Model.getFacade().isAOperation(parent))//1
{ 

//#if 1387160448 
Collection col = Model.getFacade().getCollaborations(parent);
//#endif 


//#if -1815820021 
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
//#endif 


//#if -299050333 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1500708799 
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 

//#if 826288576 
if(diagram instanceof UMLSequenceDiagram
                        && col.contains(
                            (
                                (SequenceDiagramGraphModel)
                                ((UMLSequenceDiagram) diagram)
                                .getGraphModel())
                            .getCollaboration()))//1
{ 

//#if -798091724 
ret.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -496583123 
return ret;
//#endif 

} 

//#endif 


//#if 17880599 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

