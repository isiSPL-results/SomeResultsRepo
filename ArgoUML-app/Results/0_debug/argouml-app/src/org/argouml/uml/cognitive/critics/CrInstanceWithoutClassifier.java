
//#if 850401657 
// Compilation Unit of /CrInstanceWithoutClassifier.java 
 

//#if -573325769 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 593632450 
import java.util.Collection;
//#endif 


//#if -933785038 
import java.util.Iterator;
//#endif 


//#if 1271393476 
import org.argouml.cognitive.Designer;
//#endif 


//#if 501742915 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -248592170 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1454756881 
import org.argouml.model.Model;
//#endif 


//#if -2009463503 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 2069732372 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -410273085 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 1664510031 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1367323436 
public class CrInstanceWithoutClassifier extends 
//#if 371988479 
CrUML
//#endif 

  { 

//#if -214064569 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 921704212 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -884521386 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 1664871525 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 77046231 
public CrInstanceWithoutClassifier()
    { 

//#if 1210926804 
setupHeadAndDesc();
//#endif 


//#if 1063227383 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if 42175156 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1934650340 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if -303891071 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1785288108 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 2134154006 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -680765262 
if(offs == null)//1
{ 

//#if 62816861 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1422679723 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -304086753 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 735301786 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -591930277 
ListSet offs = null;
//#endif 


//#if -872018432 
Iterator figIter = figs.iterator();
//#endif 


//#if -136359607 
while (figIter.hasNext()) //1
{ 

//#if -48590895 
Object obj = figIter.next();
//#endif 


//#if 1514141736 
if(!(obj instanceof FigNodeModelElement))//1
{ 

//#if -1239031551 
continue;
//#endif 

} 

//#endif 


//#if -917844482 
FigNodeModelElement figNodeModelElement = (FigNodeModelElement) obj;
//#endif 


//#if 1692692113 
if(figNodeModelElement != null
                    && (Model.getFacade().isAInstance(
                            figNodeModelElement.getOwner())))//1
{ 

//#if -32290337 
Object instance = figNodeModelElement.getOwner();
//#endif 


//#if -1729930005 
if(instance != null)//1
{ 

//#if 1002356652 
Collection col = Model.getFacade().getClassifiers(instance);
//#endif 


//#if 965603755 
if(col.size() > 0)//1
{ 

//#if 2139219574 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -972263586 
if(offs == null)//1
{ 

//#if 341662244 
offs = new ListSet();
//#endif 


//#if 200954268 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 85794586 
offs.add(figNodeModelElement);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1704923933 
return offs;
//#endif 

} 

//#endif 


//#if 1859657037 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 1847820839 
if(!isActive())//1
{ 

//#if -2006664899 
return false;
//#endif 

} 

//#endif 


//#if 1701861956 
ListSet offs = i.getOffenders();
//#endif 


//#if 891847192 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if 612615570 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if 897657546 
boolean res = offs.equals(newOffs);
//#endif 


//#if 1070620611 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

