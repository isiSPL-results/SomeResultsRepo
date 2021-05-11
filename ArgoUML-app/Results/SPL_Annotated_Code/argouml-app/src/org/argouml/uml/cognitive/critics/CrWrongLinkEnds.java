// Compilation Unit of /CrWrongLinkEnds.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigLink;
public class CrWrongLinkEnds extends CrUML
  { 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
ListSet offs = computeOffenders(dd);
return new UMLToDoItem(this, offs, dsgr);
} 

@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 

ListSet offs = i.getOffenders();
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
ListSet newOffs = computeOffenders(dd);
boolean res = offs.equals(newOffs);
return res;
} 

public CrWrongLinkEnds()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 
return NO_PROBLEM;
} 

UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
ListSet offs = computeOffenders(dd);
if(offs == null)//1
{ 
return NO_PROBLEM;
} 

return PROBLEM_FOUND;
} 

public ListSet computeOffenders(UMLDeploymentDiagram deploymentDiagram)
    { 
Collection figs = deploymentDiagram.getLayer().getContents();
ListSet offs = null;
for (Object obj : figs) //1
{ 
if(!(obj instanceof FigLink))//1
{ 
continue;
} 

FigLink figLink = (FigLink) obj;
if(!(Model.getFacade().isALink(figLink.getOwner())))//1
{ 
continue;
} 

Object link = figLink.getOwner();
Collection ends = Model.getFacade().getConnections(link);
if(ends != null && (ends.size() > 0))//1
{ 
int count = 0;
for (Object end : ends) //1
{ 
Object instance = Model.getFacade().getInstance(end);
if(Model.getFacade().isAComponentInstance(instance)
                            || Model.getFacade().isANodeInstance(instance))//1
{ 
Collection residencies =
                            Model.getFacade().getResidents(instance);
if(residencies != null
                                && (residencies.size() > 0))//1
{ 
count = count + 2;
} 

} 

Object component =
                        Model.getFacade().getComponentInstance(instance);
if(component != null)//1
{ 
count = count + 1;
} 

} 

if(count == 3)//1
{ 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(deploymentDiagram);
} 

offs.add(figLink);
offs.add(figLink.getSourcePortFig());
offs.add(figLink.getDestPortFig());
} 

} 

} 

return offs;
} 

 } 


