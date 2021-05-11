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
import org.argouml.uml.diagram.ui.FigNodeModelElement;
public class CrInstanceWithoutClassifier extends CrUML
  { 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
ListSet offs = computeOffenders(dd);
return new UMLToDoItem(this, offs, dsgr);
} 
public CrInstanceWithoutClassifier()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
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
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 
Collection figs = dd.getLayer().getContents();
ListSet offs = null;
Iterator figIter = figs.iterator();
while (figIter.hasNext()) //1
{ 
Object obj = figIter.next();
if(!(obj instanceof FigNodeModelElement))//1
{ 
continue;
} 
FigNodeModelElement figNodeModelElement = (FigNodeModelElement) obj;
if(figNodeModelElement != null
                    && (Model.getFacade().isAInstance(
                            figNodeModelElement.getOwner())))//1
{ 
Object instance = figNodeModelElement.getOwner();
if(instance != null)//1
{ 
Collection col = Model.getFacade().getClassifiers(instance);
if(col.size() > 0)//1
{ 
continue;
} 
} 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(dd);
} 
offs.add(figNodeModelElement);
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

 } 
