// Compilation Unit of /CrWrongDepEnds.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
import org.argouml.uml.diagram.ui.FigDependency;
public class CrWrongDepEnds extends CrUML
  { 
private static final long serialVersionUID = -6587198606342935144L;
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

public CrWrongDepEnds()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.PATTERNS);
} 

public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 
Collection figs = dd.getLayer().getContents();
ListSet offs = null;
for (Object obj : figs) //1
{ 
if(!(obj instanceof FigDependency))//1
{ 
continue;
} 

FigDependency figDependency = (FigDependency) obj;
if(!(Model.getFacade().isADependency(figDependency.getOwner())))//1
{ 
continue;
} 

Object dependency = figDependency.getOwner();
Collection suppliers = Model.getFacade().getSuppliers(dependency);
int count = 0;
if(suppliers != null)//1
{ 
for (Object moe : suppliers) //1
{ 
if(Model.getFacade().isAObject(moe))//1
{ 
Object objSup = moe;
if(Model.getFacade().getElementResidences(objSup)
                                != null
                                && (Model.getFacade().getElementResidences(objSup)
                                    .size() > 0))//1
{ 
count += 2;
} 

if(Model.getFacade().getComponentInstance(objSup)
                                != null)//1
{ 
count++;
} 

} 

} 

} 

Collection clients = Model.getFacade().getClients(dependency);
if(clients != null && (clients.size() > 0))//1
{ 
for (Object moe : clients) //1
{ 
if(Model.getFacade().isAObject(moe))//1
{ 
Object objCli = moe;
if(Model.getFacade().getElementResidences(objCli)
                                != null
                                && (Model.getFacade().getElementResidences(objCli)
                                    .size() > 0))//1
{ 
count += 2;
} 

if(Model.getFacade().getComponentInstance(objCli)
                                != null)//1
{ 
count++;
} 

} 

} 

} 

if(count == 3)//1
{ 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(dd);
} 

offs.add(figDependency);
offs.add(figDependency.getSourcePortFig());
offs.add(figDependency.getDestPortFig());
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

 } 


