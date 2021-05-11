
//#if 1487608066 
// Compilation Unit of /CrObjectWithoutComponent.java 
 

//#if 161509945 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1200808892 
import java.util.Collection;
//#endif 


//#if 109244870 
import org.argouml.cognitive.Designer;
//#endif 


//#if -921219071 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1410740776 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -198843091 
import org.argouml.model.Model;
//#endif 


//#if -1967015441 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 2112180434 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -1224315500 
import org.argouml.uml.diagram.deployment.ui.FigObject;
//#endif 


//#if 1843202245 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if -12148188 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1587044162 
public class CrObjectWithoutComponent extends 
//#if 2079767064 
CrUML
//#endif 

  { 

//#if -1796372371 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 306189490 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if 1523715124 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -877796758 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -676136512 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 859917148 
if(offs == null)//1
{ 

//#if -1212835237 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1026471531 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -544297672 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if -2319796 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -2042077043 
ListSet offs = null;
//#endif 


//#if -1553391862 
for (Object obj : figs) //1
{ 

//#if 1494445955 
if(!(obj instanceof FigObject))//1
{ 

//#if -1296909584 
continue;
//#endif 

} 

//#endif 


//#if -574104163 
FigObject fo = (FigObject) obj;
//#endif 


//#if 1630424128 
Fig enclosing = fo.getEnclosingFig();
//#endif 


//#if 2142704722 
if(enclosing == null
                    || (!(Model.getFacade().isAComponent(enclosing.getOwner())
                          || Model.getFacade().isAComponentInstance(
                              enclosing.getOwner()))))//1
{ 

//#if -1030787334 
if(offs == null)//1
{ 

//#if -549348497 
offs = new ListSet();
//#endif 


//#if -2141246095 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 752190504 
offs.add(fo);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -890437995 
return offs;
//#endif 

} 

//#endif 


//#if -550467218 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 895130212 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1531933434 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 1145199381 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -34239718 
public CrObjectWithoutComponent()
    { 

//#if 1029835677 
setupHeadAndDesc();
//#endif 


//#if -1653290560 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if 699258548 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -1450715578 
if(!isActive())//1
{ 

//#if 1414273651 
return false;
//#endif 

} 

//#endif 


//#if 475172037 
ListSet offs = i.getOffenders();
//#endif 


//#if 284023065 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -1633882127 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -1839965015 
boolean res = offs.equals(newOffs);
//#endif 


//#if -713145630 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

