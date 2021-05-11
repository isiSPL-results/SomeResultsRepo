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
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
public class CrComponentInstanceWithoutClassifier extends CrUML
  { 
private static final long serialVersionUID = -2178052428128671983L;
public ListSet computeOffenders(UMLDeploymentDiagram deploymentDiagram)
    { 
Collection figs = deploymentDiagram.getLayer().getContents();
ListSet offs = null;
Iterator figIter = figs.iterator();
while (figIter.hasNext()) //1
{ 
Object obj = figIter.next();
if(!(obj instanceof FigComponentInstance))//1
{ 
continue;
} 
FigComponentInstance figComponentInstance =
                (FigComponentInstance) obj;
if(figComponentInstance != null)//1
{ 
Object coi =
                    figComponentInstance.getOwner();
if(coi != null)//1
{ 
Collection col = Model.getFacade().getClassifiers(coi);
if(col.size() > 0)//1
{ 
continue;
} 
} 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(deploymentDiagram);
} 
offs.add(figComponentInstance);
} 
} 
return offs;
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
public CrComponentInstanceWithoutClassifier()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
} 

 } 
