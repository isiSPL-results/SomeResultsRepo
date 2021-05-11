package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
public class CrCompInstanceWithoutNode extends CrUML
  { 
public ListSet computeOffenders(UMLDeploymentDiagram deploymentDiagram)
    { 
Collection figs = deploymentDiagram.getLayer().getContents();
ListSet offs = null;
boolean isNode = false;
Iterator it = figs.iterator();
Object obj = null;
while (it.hasNext()) //1
{ 
obj = it.next();
if(obj instanceof FigNodeInstance)//1
{ 
isNode = true;
} 
} 
it = figs.iterator();
while (it.hasNext()) //2
{ 
obj = it.next();
if(!(obj instanceof FigComponentInstance))//1
{ 
continue;
} 
FigComponentInstance fc = (FigComponentInstance) obj;
if((fc.getEnclosingFig() == null) && isNode)//1
{ 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(deploymentDiagram);
} 
offs.add(fc);
} 
else
if(fc.getEnclosingFig() != null
                       && ((Model.getFacade().getNodeInstance(fc.getOwner()))
                           == null))//1
{ 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(deploymentDiagram);
} 
offs.add(fc);
} 
} 
return offs;
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
public CrCompInstanceWithoutNode()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
} 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
ListSet offs = computeOffenders(dd);
return new UMLToDoItem(this, offs, dsgr);
} 
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

 } 
