
//#if -1447509993 
// Compilation Unit of /CrComponentInstanceWithoutClassifier.java 
 

//#if -1281873307 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 2133807472 
import java.util.Collection;
//#endif 


//#if 1034295904 
import java.util.Iterator;
//#endif 


//#if -1290428430 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1382011819 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1484553220 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1236299647 
import org.argouml.model.Model;
//#endif 


//#if -584908221 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -800679642 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 236156477 
import org.argouml.uml.diagram.deployment.ui.FigComponentInstance;
//#endif 


//#if -763757327 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if -307523347 
public class CrComponentInstanceWithoutClassifier extends 
//#if 271553656 
CrUML
//#endif 

  { 

//#if 407173555 
private static final long serialVersionUID = -2178052428128671983L;
//#endif 


//#if -1730464820 
public ListSet computeOffenders(UMLDeploymentDiagram deploymentDiagram)
    { 

//#if -580524512 
Collection figs = deploymentDiagram.getLayer().getContents();
//#endif 


//#if -1577023285 
ListSet offs = null;
//#endif 


//#if 2124477328 
Iterator figIter = figs.iterator();
//#endif 


//#if -1890635335 
while (figIter.hasNext()) //1
{ 

//#if 1689008049 
Object obj = figIter.next();
//#endif 


//#if 1393748115 
if(!(obj instanceof FigComponentInstance))//1
{ 

//#if 169856095 
continue;
//#endif 

} 

//#endif 


//#if -1742980679 
FigComponentInstance figComponentInstance =
                (FigComponentInstance) obj;
//#endif 


//#if 1735493445 
if(figComponentInstance != null)//1
{ 

//#if -942716779 
Object coi =
                    figComponentInstance.getOwner();
//#endif 


//#if 1190650742 
if(coi != null)//1
{ 

//#if 767817943 
Collection col = Model.getFacade().getClassifiers(coi);
//#endif 


//#if -1497179042 
if(col.size() > 0)//1
{ 

//#if -1528616720 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 226434661 
if(offs == null)//1
{ 

//#if 1274642025 
offs = new ListSet();
//#endif 


//#if -1774575397 
offs.add(deploymentDiagram);
//#endif 

} 

//#endif 


//#if 363099672 
offs.add(figComponentInstance);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2097130835 
return offs;
//#endif 

} 

//#endif 


//#if 2060022208 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -457519177 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1594573805 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 361642914 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 1118696070 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 1356405378 
if(!isActive())//1
{ 

//#if -176298457 
return false;
//#endif 

} 

//#endif 


//#if 1710328585 
ListSet offs = i.getOffenders();
//#endif 


//#if 528255325 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -376169171 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -276068379 
boolean res = offs.equals(newOffs);
//#endif 


//#if 403014430 
return res;
//#endif 

} 

//#endif 


//#if 1819388507 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -394728680 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 1121806402 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1591094192 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -347457382 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 282426934 
if(offs == null)//1
{ 

//#if 854100933 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1640473263 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1410848643 
public CrComponentInstanceWithoutClassifier()
    { 

//#if 808883597 
setupHeadAndDesc();
//#endif 


//#if 449217456 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

