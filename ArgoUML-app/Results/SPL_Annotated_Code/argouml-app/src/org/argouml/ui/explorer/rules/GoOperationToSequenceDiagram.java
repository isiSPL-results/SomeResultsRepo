// Compilation Unit of /GoOperationToSequenceDiagram.java 
 

//#if SEQUENCE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if SEQUENCE 
import java.util.Collection;
//#endif 


//#if SEQUENCE 
import java.util.Collections;
//#endif 


//#if SEQUENCE 
import java.util.HashSet;
//#endif 


//#if SEQUENCE 
import java.util.Set;
//#endif 


//#if SEQUENCE 
import org.argouml.i18n.Translator;
//#endif 


//#if SEQUENCE 
import org.argouml.kernel.Project;
//#endif 


//#if SEQUENCE 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if SEQUENCE 
import org.argouml.model.Model;
//#endif 


//#if SEQUENCE 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if SEQUENCE 
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
//#endif 


//#if SEQUENCE 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if SEQUENCE 
public class GoOperationToSequenceDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.operation.sequence-diagram");
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAOperation(parent))//1
{ 
Collection col = Model.getFacade().getCollaborations(parent);
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
Project p = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 
if(diagram instanceof UMLSequenceDiagram
                        && col.contains(
                            (
                                (SequenceDiagramGraphModel)
                                ((UMLSequenceDiagram) diagram)
                                .getGraphModel())
                            .getCollaboration()))//1
{ 
ret.add(diagram);
} 

} 

return ret;
} 

return Collections.EMPTY_SET;
} 

 } 

//#endif 


