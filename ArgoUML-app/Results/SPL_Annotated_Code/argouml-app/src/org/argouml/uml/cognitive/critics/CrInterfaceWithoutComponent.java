// Compilation Unit of /CrInterfaceWithoutComponent.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
import org.tigris.gef.presentation.Fig;
public class CrInterfaceWithoutComponent extends CrUML
  { 
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

public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
ListSet offs = computeOffenders(dd);
return new UMLToDoItem(this, offs, dsgr);
} 

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

public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 
Collection figs = dd.getLayer().getContents();
ListSet offs = null;
Iterator figIter = figs.iterator();
while (figIter.hasNext()) //1
{ 
Object obj = figIter.next();
if(!(obj instanceof FigInterface))//1
{ 
continue;
} 

FigInterface fi = (FigInterface) obj;
Fig enclosing = fi.getEnclosingFig();
if(enclosing == null || (!(Model.getFacade()
                                        .isAComponent(enclosing.getOwner()))))//1
{ 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(dd);
} 

offs.add(fi);
} 

} 

return offs;
} 

public CrInterfaceWithoutComponent()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
} 

 } 


