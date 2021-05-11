
//#if 1653239540 
// Compilation Unit of /CrNodeInstanceWithoutClassifier.java 
 

//#if -804835855 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 970340860 
import java.util.Collection;
//#endif 


//#if -2058598018 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1268244151 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 716383632 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1684059019 
import org.argouml.model.Model;
//#endif 


//#if -1208958153 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1424729574 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -429667740 
import org.argouml.uml.diagram.deployment.ui.FigNodeInstance;
//#endif 


//#if 758783101 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if -1370655024 
public class CrNodeInstanceWithoutClassifier extends 
//#if 1639334593 
CrUML
//#endif 

  { 

//#if 1995759585 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 2114417619 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -1315924780 
ListSet offs = null;
//#endif 


//#if 2051637027 
for (Object obj : figs) //1
{ 

//#if 1834380862 
if(!(obj instanceof FigNodeInstance))//1
{ 

//#if 1423713411 
continue;
//#endif 

} 

//#endif 


//#if -580587383 
FigNodeInstance fn = (FigNodeInstance) obj;
//#endif 


//#if -454534201 
if(fn != null)//1
{ 

//#if -1109711128 
Object noi = fn.getOwner();
//#endif 


//#if -813762747 
if(noi != null)//1
{ 

//#if 127908942 
Collection col = Model.getFacade().getClassifiers(noi);
//#endif 


//#if -709124622 
if(col.size() > 0)//1
{ 

//#if 1819799642 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -514663775 
if(offs == null)//1
{ 

//#if -1483740629 
offs = new ListSet();
//#endif 


//#if 1146198325 
offs.add(dd);
//#endif 

} 

//#endif 


//#if -134817906 
offs.add(fn);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -865618916 
return offs;
//#endif 

} 

//#endif 


//#if 63366071 
public CrNodeInstanceWithoutClassifier()
    { 

//#if 2095803124 
setupHeadAndDesc();
//#endif 


//#if -352627689 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if 881896421 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 756697292 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 711383966 
ListSet offs = computeOffenders(dd);
//#endif 


//#if 1384095149 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -342772522 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1694787097 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if -1377360326 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 748415967 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1997788395 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -2091131769 
if(offs == null)//1
{ 

//#if -1966656963 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 13767008 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1483786389 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 800967354 
if(!isActive())//1
{ 

//#if 1576820572 
return false;
//#endif 

} 

//#endif 


//#if -518322223 
ListSet offs = i.getOffenders();
//#endif 


//#if -1405187547 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if 2012360549 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if 1887139357 
boolean res = offs.equals(newOffs);
//#endif 


//#if -824579242 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

