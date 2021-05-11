
//#if 523656675 
// Compilation Unit of /GoOperationToCollaborationDiagram.java 
 

//#if -1373097943 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -945562715 
import java.util.Collection;
//#endif 


//#if 752328702 
import java.util.Collections;
//#endif 


//#if -1504838401 
import java.util.HashSet;
//#endif 


//#if -817685807 
import java.util.Set;
//#endif 


//#if -2004225946 
import org.argouml.i18n.Translator;
//#endif 


//#if 884185438 
import org.argouml.kernel.Project;
//#endif 


//#if 2126164939 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1747901996 
import org.argouml.model.Model;
//#endif 


//#if 2050039275 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 688000256 
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;
//#endif 


//#if 2047803468 
public class GoOperationToCollaborationDiagram extends 
//#if 940716762 
AbstractPerspectiveRule
//#endif 

  { 

//#if 23378024 
public String getRuleName()
    { 

//#if 1669205641 
return Translator.localize("misc.operation.collaboration-diagram");
//#endif 

} 

//#endif 


//#if -335496326 
public Set getDependencies(Object parent)
    { 

//#if 1014993148 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1613190954 
public Collection getChildren(Object parent)
    { 

//#if 376456148 
if(Model.getFacade().isAOperation(parent))//1
{ 

//#if 216233163 
Object operation = parent;
//#endif 


//#if 180398855 
Collection col = Model.getFacade().getCollaborations(operation);
//#endif 


//#if -671385991 
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
//#endif 


//#if 1733106805 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1999891731 
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 

//#if -1920907850 
if(diagram instanceof UMLCollaborationDiagram
                        && col.contains(((UMLCollaborationDiagram) diagram)
                                        .getNamespace()))//1
{ 

//#if 818239464 
ret.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 326535835 
return ret;
//#endif 

} 

//#endif 


//#if -1460498340 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

