
//#if -751920267 
// Compilation Unit of /CrCompInstanceWithoutNode.java 
 

//#if 44684843 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -133271626 
import java.util.Collection;
//#endif 


//#if -568061402 
import java.util.Iterator;
//#endif 


//#if 1689263800 
import org.argouml.cognitive.Designer;
//#endif 


//#if 653769935 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 169278154 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1428978565 
import org.argouml.model.Model;
//#endif 


//#if 914847933 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 699076512 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -84955133 
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
//#endif 


//#if -874859542 
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
//#endif 


//#if -1084868937 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 1912461130 
public class CrCompInstanceWithoutNode extends 
//#if -1913096899 
CrUML
//#endif 

  { 

//#if -1507963289 
public ListSet computeOffenders(UMLDeploymentDiagram deploymentDiagram)
    { 

//#if 1021563120 
Collection figs = deploymentDiagram.getLayer().getContents();
//#endif 


//#if 951120891 
ListSet offs = null;
//#endif 


//#if -588530011 
boolean isNode = false;
//#endif 


//#if -1433130323 
Iterator it = figs.iterator();
//#endif 


//#if -1382482293 
Object obj = null;
//#endif 


//#if -1279672018 
while (it.hasNext()) //1
{ 

//#if -225868694 
obj = it.next();
//#endif 


//#if 2105489195 
if(obj instanceof FigNodeInstance)//1
{ 

//#if -625050111 
isNode = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1638348293 
it = figs.iterator();
//#endif 


//#if -579292477 
while (it.hasNext()) //2
{ 

//#if -1901145436 
obj = it.next();
//#endif 


//#if -494955688 
if(!(obj instanceof FigComponentInstance))//1
{ 

//#if -741435606 
continue;
//#endif 

} 

//#endif 


//#if -84844945 
FigComponentInstance fc = (FigComponentInstance) obj;
//#endif 


//#if -1150122047 
if((fc.getEnclosingFig() == null) && isNode)//1
{ 

//#if 1620737910 
if(offs == null)//1
{ 

//#if 462556341 
offs = new ListSet();
//#endif 


//#if -690077657 
offs.add(deploymentDiagram);
//#endif 

} 

//#endif 


//#if 2132018584 
offs.add(fc);
//#endif 

} 
else

//#if -216403878 
if(fc.getEnclosingFig() != null
                       && ((Model.getFacade().getNodeInstance(fc.getOwner()))
                           == null))//1
{ 

//#if -72722661 
if(offs == null)//1
{ 

//#if 1686294753 
offs = new ListSet();
//#endif 


//#if 1677245779 
offs.add(deploymentDiagram);
//#endif 

} 

//#endif 


//#if 1898149821 
offs.add(fc);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1315716227 
return offs;
//#endif 

} 

//#endif 


//#if -1296495349 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 370151042 
if(!isActive())//1
{ 

//#if 110685683 
return false;
//#endif 

} 

//#endif 


//#if -1264969975 
ListSet offs = i.getOffenders();
//#endif 


//#if 320542045 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if 1920340269 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if 2139585509 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1385138402 
return res;
//#endif 

} 

//#endif 


//#if -1277919065 
public CrCompInstanceWithoutNode()
    { 

//#if -1820544190 
setupHeadAndDesc();
//#endif 


//#if 2062291557 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if -311203451 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1298629075 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1906993801 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 1247527686 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 1325837110 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -75073273 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 1882323645 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1475677441 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1067151819 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -2055653017 
if(offs == null)//1
{ 

//#if -1627047481 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 399313024 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

