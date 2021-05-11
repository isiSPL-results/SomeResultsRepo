
//#if -1234520092 
// Compilation Unit of /CrNodeInstanceInsideElement.java 
 

//#if 1156495816 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -708363757 
import java.util.Collection;
//#endif 


//#if 143218901 
import org.argouml.cognitive.Designer;
//#endif 


//#if -365933806 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1376766745 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 87757824 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -128013597 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -898799315 
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
//#endif 


//#if 1535202132 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 635167792 
public class CrNodeInstanceInsideElement extends 
//#if 343761615 
CrUML
//#endif 

  { 

//#if 1408005476 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -961070328 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 1497293986 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -49778624 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1122319018 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -262758330 
if(offs == null)//1
{ 

//#if 1279104690 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 311640385 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 1250723997 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 2110171066 
if(!isActive())//1
{ 

//#if -665076783 
return false;
//#endif 

} 

//#endif 


//#if 1507199697 
ListSet offs = i.getOffenders();
//#endif 


//#if -30995163 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if 1784532069 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -79850723 
boolean res = offs.equals(newOffs);
//#endif 


//#if 235915350 
return res;
//#endif 

} 

//#endif 


//#if 1354015127 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 36573980 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1050786638 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 165881181 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -1551674788 
public CrNodeInstanceInsideElement()
    { 

//#if 1340022968 
setupHeadAndDesc();
//#endif 


//#if 811269595 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if 209873903 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 734444379 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if 351680092 
ListSet offs = null;
//#endif 


//#if 307466907 
for (Object obj : figs) //1
{ 

//#if 1313076293 
if(!(obj instanceof FigNodeInstance))//1
{ 

//#if -54043840 
continue;
//#endif 

} 

//#endif 


//#if 438840162 
FigNodeInstance fn = (FigNodeInstance) obj;
//#endif 


//#if -1472767199 
if(fn.getEnclosingFig() != null)//1
{ 

//#if -1575792762 
if(offs == null)//1
{ 

//#if -107828609 
offs = new ListSet();
//#endif 


//#if -968559519 
offs.add(dd);
//#endif 

} 

//#endif 


//#if -1592293645 
offs.add(fn);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1897456732 
return offs;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

