// Compilation Unit of /GoCollaborationToDiagram.java 
 

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


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if COLLABORATION 
public class GoCollaborationToDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.collaboration.diagram");
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(!Model.getFacade().isACollaboration(parent))//1
{ 
return Collections.EMPTY_SET;
} 

Project p = ProjectManager.getManager().getCurrentProject();
if(p == null)//1
{ 
return Collections.EMPTY_SET;
} 

Set<ArgoDiagram> res = new HashSet<ArgoDiagram>();
for (ArgoDiagram d : p.getDiagramList()) //1
{ 
if(d instanceof UMLCollaborationDiagram
                    && ((UMLCollaborationDiagram) d).getNamespace() == parent)//1
{ 
res.add(d);
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
if((d instanceof UMLSequenceDiagram)
                    && (Model.getFacade().getRepresentedClassifier(parent) == null)
                    && (Model.getFacade().getRepresentedOperation(parent) == null)
                    && (parent == ((UMLSequenceDiagram) d).getNamespace()))//1
{ 
res.add(d);
} 

//#endif 

} 

return res;
} 

 } 

//#endif 


