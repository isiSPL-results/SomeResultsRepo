// Compilation Unit of /CrObjectWithoutComponent.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
import org.argouml.uml.diagram.deployment.ui.FigObject;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
import org.tigris.gef.presentation.Fig;
public class CrObjectWithoutComponent extends CrUML
  { 
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

public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 
Collection figs = dd.getLayer().getContents();
ListSet offs = null;
for (Object obj : figs) //1
{ 
if(!(obj instanceof FigObject))//1
{ 
continue;
} 

FigObject fo = (FigObject) obj;
Fig enclosing = fo.getEnclosingFig();
if(enclosing == null
                    || (!(Model.getFacade().isAComponent(enclosing.getOwner())
                          || Model.getFacade().isAComponentInstance(
                              enclosing.getOwner()))))//1
{ 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(dd);
} 

offs.add(fo);
} 

} 

return offs;
} 

@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
ListSet offs = computeOffenders(dd);
return new UMLToDoItem(this, offs, dsgr);
} 

public CrObjectWithoutComponent()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
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

 } 


