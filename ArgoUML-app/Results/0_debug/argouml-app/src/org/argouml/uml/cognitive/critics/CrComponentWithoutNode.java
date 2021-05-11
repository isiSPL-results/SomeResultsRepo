
//#if -1212709643 
// Compilation Unit of /CrComponentWithoutNode.java 
 

//#if -660943511 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1537330036 
import java.util.Collection;
//#endif 


//#if -642300572 
import java.util.Iterator;
//#endif 


//#if 2043307254 
import org.argouml.cognitive.Designer;
//#endif 


//#if -2105755951 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 523321608 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1679075325 
import org.argouml.model.Model;
//#endif 


//#if -889499457 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1105270878 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -1752008106 
import org.argouml.uml.diagram.deployment.ui.FigComponent;
//#endif 


//#if -1080831612 
import org.argouml.uml.diagram.deployment.ui.FigMNode;
//#endif 


//#if 1665455093 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 727517607 
public class CrComponentWithoutNode extends 
//#if 1777204999 
CrUML
//#endif 

  { 

//#if -1235961259 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -1718504867 
if(!isActive())//1
{ 

//#if -1340530481 
return false;
//#endif 

} 

//#endif 


//#if 1472007246 
ListSet offs = i.getOffenders();
//#endif 


//#if 661987618 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -457796536 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -526138240 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1695209991 
return res;
//#endif 

} 

//#endif 


//#if -1703727292 
public CrComponentWithoutNode()
    { 

//#if -1762205283 
setupHeadAndDesc();
//#endif 


//#if -613965888 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if -1443156820 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1462428904 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if -1414129971 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1909273120 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -600771382 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 2006620774 
if(offs == null)//1
{ 

//#if -143615613 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 304321313 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1647451825 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1618182197 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 120381269 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -1868632604 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -2115717081 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if -1650074470 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if 989915227 
ListSet offs = null;
//#endif 


//#if -922516992 
Iterator figIter = figs.iterator();
//#endif 


//#if -212668859 
boolean isNode = false;
//#endif 


//#if -2025235127 
while (figIter.hasNext()) //1
{ 

//#if -1517866637 
Object obj = figIter.next();
//#endif 


//#if -341317880 
if(obj instanceof FigMNode)//1
{ 

//#if 103850691 
isNode = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1116871822 
figIter = figs.iterator();
//#endif 


//#if 1920982216 
while (figIter.hasNext()) //2
{ 

//#if -690977066 
Object obj = figIter.next();
//#endif 


//#if 514917389 
if(!(obj instanceof FigComponent))//1
{ 

//#if -365847779 
continue;
//#endif 

} 

//#endif 


//#if 839795897 
FigComponent fc = (FigComponent) obj;
//#endif 


//#if 720669921 
if((fc.getEnclosingFig() == null) && isNode)//1
{ 

//#if 1945269299 
if(offs == null)//1
{ 

//#if 1774488673 
offs = new ListSet();
//#endif 


//#if -532550337 
offs.add(dd);
//#endif 

} 

//#endif 


//#if -1720327979 
offs.add(fc);
//#endif 

} 
else

//#if 658011989 
if(fc.getEnclosingFig() != null
                       && (((Model.getFacade()
                             .getDeploymentLocations(fc.getOwner()) == null)
                            || (((Model.getFacade()
                                  .getDeploymentLocations(fc.getOwner()).size())
                                 == 0)))))//1
{ 

//#if 1230742984 
if(offs == null)//1
{ 

//#if 1960538663 
offs = new ListSet();
//#endif 


//#if -1447558215 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 687416554 
offs.add(fc);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2002974947 
return offs;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

