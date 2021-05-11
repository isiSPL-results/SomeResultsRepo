
//#if 1590299 
// Compilation Unit of /CrInterfaceWithoutComponent.java 
 

//#if 1261503798 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1587412481 
import java.util.Collection;
//#endif 


//#if -79120591 
import java.util.Iterator;
//#endif 


//#if -1633252541 
import org.argouml.cognitive.Designer;
//#endif 


//#if -7597340 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1141729109 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -963424688 
import org.argouml.model.Model;
//#endif 


//#if 1644358098 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1428586677 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 789820610 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if -163533462 
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
//#endif 


//#if 1805006919 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -824886265 
public class CrInterfaceWithoutComponent extends 
//#if 1932215773 
CrUML
//#endif 

  { 

//#if 1149177494 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 65293825 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 1295797582 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -2003852167 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1896006767 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 1447251757 
if(offs == null)//1
{ 

//#if 253019992 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 615044346 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1068571173 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 697319144 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1155600126 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -190422767 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 1816991147 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -489889652 
if(!isActive())//1
{ 

//#if 1790456891 
return false;
//#endif 

} 

//#endif 


//#if -520717633 
ListSet offs = i.getOffenders();
//#endif 


//#if -1583256557 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -720751433 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -755043217 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1782779096 
return res;
//#endif 

} 

//#endif 


//#if 2051324669 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 1711320123 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -338985156 
ListSet offs = null;
//#endif 


//#if -466735873 
Iterator figIter = figs.iterator();
//#endif 


//#if 558993130 
while (figIter.hasNext()) //1
{ 

//#if 1648356667 
Object obj = figIter.next();
//#endif 


//#if -1321081482 
if(!(obj instanceof FigInterface))//1
{ 

//#if 1695142715 
continue;
//#endif 

} 

//#endif 


//#if 1408524000 
FigInterface fi = (FigInterface) obj;
//#endif 


//#if 255375991 
Fig enclosing = fi.getEnclosingFig();
//#endif 


//#if 1380739043 
if(enclosing == null || (!(Model.getFacade()
                                        .isAComponent(enclosing.getOwner()))))//1
{ 

//#if 541633627 
if(offs == null)//1
{ 

//#if -1716657715 
offs = new ListSet();
//#endif 


//#if -1357126573 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 1925088131 
offs.add(fi);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1578929284 
return offs;
//#endif 

} 

//#endif 


//#if -1005578193 
public CrInterfaceWithoutComponent()
    { 

//#if -1295922940 
setupHeadAndDesc();
//#endif 


//#if 2115797543 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

