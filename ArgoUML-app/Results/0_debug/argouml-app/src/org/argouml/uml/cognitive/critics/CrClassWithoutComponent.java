
//#if -563058673 
// Compilation Unit of /CrClassWithoutComponent.java 
 

//#if 1173687305 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 2007155716 
import java.util.Iterator;
//#endif 


//#if 240710996 
import java.util.List;
//#endif 


//#if 508359574 
import org.argouml.cognitive.Designer;
//#endif 


//#if -769797071 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1011626072 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -726708899 
import org.argouml.model.Model;
//#endif 


//#if 1138298399 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 922526978 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 863318677 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 480376094 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if -42959021 
public class CrClassWithoutComponent extends 
//#if -1956924408 
CrUML
//#endif 

  { 

//#if 353321241 
public CrClassWithoutComponent()
    { 

//#if 1910037063 
setupHeadAndDesc();
//#endif 


//#if -168510870 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if 2126382888 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 599783271 
List figs = dd.getLayer().getContents();
//#endif 


//#if -382359384 
ListSet offs = null;
//#endif 


//#if -1416200685 
Iterator figIter = figs.iterator();
//#endif 


//#if 1398268246 
while (figIter.hasNext()) //1
{ 

//#if 1481902760 
Object obj = figIter.next();
//#endif 


//#if 988655428 
if(!(obj instanceof FigClass))//1
{ 

//#if 2125403318 
continue;
//#endif 

} 

//#endif 


//#if 1691589461 
FigClass fc = (FigClass) obj;
//#endif 


//#if -512076164 
if(fc.getEnclosingFig() == null
                    || (!(Model.getFacade().isAComponent(fc.getEnclosingFig()
                            .getOwner()))))//1
{ 

//#if -1299012510 
if(offs == null)//1
{ 

//#if -91333108 
offs = new ListSet();
//#endif 


//#if -1897890636 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 140214404 
offs.add(fc);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1693632784 
return offs;
//#endif 

} 

//#endif 


//#if -649936560 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 17738863 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1328154203 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -1207623190 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -401498602 
public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -2115238163 
if(!isActive())//1
{ 

//#if -1023711131 
return false;
//#endif 

} 

//#endif 


//#if 827538878 
ListSet offs = i.getOffenders();
//#endif 


//#if -1044657518 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -1032133416 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -1379476208 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1728771447 
return res;
//#endif 

} 

//#endif 


//#if -584954677 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1856461574 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 242758069 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1318328766 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1624737004 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 1582935688 
if(offs == null)//1
{ 

//#if 618734749 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1210807231 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

