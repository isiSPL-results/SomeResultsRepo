
//#if -213874961 
// Compilation Unit of /CrWrongLinkEnds.java 
 

//#if 2084486663 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1883113618 
import java.util.Collection;
//#endif 


//#if 1825264788 
import org.argouml.cognitive.Designer;
//#endif 


//#if -34579597 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 305279142 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -708776417 
import org.argouml.model.Model;
//#endif 


//#if -841403551 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1057174972 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -337098093 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if -468397432 
import org.argouml.uml.diagram.static_structure.ui.FigLink;
//#endif 


//#if 702626631 
public class CrWrongLinkEnds extends 
//#if -271644142 
CrUML
//#endif 

  { 

//#if 1346917556 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -1043318898 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1757249820 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -1846848469 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -1275074438 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -226729407 
if(!isActive())//1
{ 

//#if -1285505351 
return false;
//#endif 

} 

//#endif 


//#if 1926645226 
ListSet offs = i.getOffenders();
//#endif 


//#if 161355966 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if 1001558828 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if 1562039652 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1720714787 
return res;
//#endif 

} 

//#endif 


//#if -688397483 
public CrWrongLinkEnds()
    { 

//#if 1336176686 
setupHeadAndDesc();
//#endif 


//#if 1193724753 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if 1187980775 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1635905625 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if -487656392 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -329313889 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1872881451 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -1529450809 
if(offs == null)//1
{ 

//#if 2987668 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -141338848 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1635945742 
public ListSet computeOffenders(UMLDeploymentDiagram deploymentDiagram)
    { 

//#if 520213046 
Collection figs = deploymentDiagram.getLayer().getContents();
//#endif 


//#if -951340043 
ListSet offs = null;
//#endif 


//#if -537285470 
for (Object obj : figs) //1
{ 

//#if 250497180 
if(!(obj instanceof FigLink))//1
{ 

//#if -1895202958 
continue;
//#endif 

} 

//#endif 


//#if 1008297874 
FigLink figLink = (FigLink) obj;
//#endif 


//#if 540135049 
if(!(Model.getFacade().isALink(figLink.getOwner())))//1
{ 

//#if 1173020386 
continue;
//#endif 

} 

//#endif 


//#if 674676993 
Object link = figLink.getOwner();
//#endif 


//#if -1112913916 
Collection ends = Model.getFacade().getConnections(link);
//#endif 


//#if 2123945569 
if(ends != null && (ends.size() > 0))//1
{ 

//#if 540999808 
int count = 0;
//#endif 


//#if -522293019 
for (Object end : ends) //1
{ 

//#if 2097702954 
Object instance = Model.getFacade().getInstance(end);
//#endif 


//#if -456109039 
if(Model.getFacade().isAComponentInstance(instance)
                            || Model.getFacade().isANodeInstance(instance))//1
{ 

//#if 9245444 
Collection residencies =
                            Model.getFacade().getResidents(instance);
//#endif 


//#if -416060504 
if(residencies != null
                                && (residencies.size() > 0))//1
{ 

//#if 298413215 
count = count + 2;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 703804237 
Object component =
                        Model.getFacade().getComponentInstance(instance);
//#endif 


//#if 1496267362 
if(component != null)//1
{ 

//#if 635882031 
count = count + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 667427535 
if(count == 3)//1
{ 

//#if -650230423 
if(offs == null)//1
{ 

//#if 236768738 
offs = new ListSet();
//#endif 


//#if 1004481812 
offs.add(deploymentDiagram);
//#endif 

} 

//#endif 


//#if 1457764084 
offs.add(figLink);
//#endif 


//#if -1227502447 
offs.add(figLink.getSourcePortFig());
//#endif 


//#if 732107050 
offs.add(figLink.getDestPortFig());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1741881347 
return offs;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

