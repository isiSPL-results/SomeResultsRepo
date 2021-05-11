
//#if 151740560 
// Compilation Unit of /GoCollaborationToDiagram.java 
 

//#if -1649234221 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1259521743 
import java.util.Collection;
//#endif 


//#if 390470164 
import java.util.Collections;
//#endif 


//#if -2146897387 
import java.util.HashSet;
//#endif 


//#if 264243943 
import java.util.Set;
//#endif 


//#if -1401028100 
import org.argouml.i18n.Translator;
//#endif 


//#if -204735224 
import org.argouml.kernel.Project;
//#endif 


//#if 612678881 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1894197954 
import org.argouml.model.Model;
//#endif 


//#if -711116415 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1336123094 
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;
//#endif 


//#if 2129129552 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if -109541727 
public class GoCollaborationToDiagram extends 
//#if -969047585 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1309124051 
public String getRuleName()
    { 

//#if 698491078 
return Translator.localize("misc.collaboration.diagram");
//#endif 

} 

//#endif 


//#if 1304879573 
public Set getDependencies(Object parent)
    { 

//#if -392822542 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1913704175 
public Collection getChildren(Object parent)
    { 

//#if -113100350 
if(!Model.getFacade().isACollaboration(parent))//1
{ 

//#if 1583072407 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 233075593 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -500857167 
if(p == null)//1
{ 

//#if -302450661 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1866644614 
Set<ArgoDiagram> res = new HashSet<ArgoDiagram>();
//#endif 


//#if -1799993866 
for (ArgoDiagram d : p.getDiagramList()) //1
{ 

//#if -1019460819 
if(d instanceof UMLCollaborationDiagram
                    && ((UMLCollaborationDiagram) d).getNamespace() == parent)//1
{ 

//#if -1742682412 
res.add(d);
//#endif 

} 

//#endif 


//#if 2067141475 
if((d instanceof UMLSequenceDiagram)
                    && (Model.getFacade().getRepresentedClassifier(parent) == null)
                    && (Model.getFacade().getRepresentedOperation(parent) == null)
                    && (parent == ((UMLSequenceDiagram) d).getNamespace()))//1
{ 

//#if 1132593456 
res.add(d);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2119114216 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

