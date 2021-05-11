// Compilation Unit of /GoOperationToCollaborationDiagram.java 
 

//#if COLLABORATION 
package org.argouml.ui.explorer.rules;
//#endif 


//#if COLLABORATION 
import java.util.Collection;
//#endif 


//#if COLLABORATION 
import java.util.Collections;
//#endif 


//#if COLLABORATION 
import java.util.HashSet;
//#endif 


//#if COLLABORATION 
import java.util.Set;
//#endif 


//#if COLLABORATION 
import org.argouml.i18n.Translator;
//#endif 


//#if COLLABORATION 
import org.argouml.kernel.Project;
//#endif 


//#if COLLABORATION 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if COLLABORATION 
import org.argouml.model.Model;
//#endif 


//#if COLLABORATION 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if COLLABORATION 
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;
//#endif 


//#if COLLABORATION 
public class GoOperationToCollaborationDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.operation.collaboration-diagram");
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAOperation(parent))//1
{ 
Object operation = parent;
Collection col = Model.getFacade().getCollaborations(operation);
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
Project p = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 
if(diagram instanceof UMLCollaborationDiagram
                        && col.contains(((UMLCollaborationDiagram) diagram)
                                        .getNamespace()))//1
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


