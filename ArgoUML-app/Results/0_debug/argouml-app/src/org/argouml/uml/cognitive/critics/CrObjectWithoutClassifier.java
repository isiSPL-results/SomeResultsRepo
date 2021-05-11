
//#if 1335754475 
// Compilation Unit of /CrObjectWithoutClassifier.java 
 

//#if 982271437 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -703986984 
import java.util.Collection;
//#endif 


//#if 1575989082 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1897041901 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 56003436 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 165316121 
import org.argouml.model.Model;
//#endif 


//#if -1910223397 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -2125994818 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -43906432 
import org.argouml.uml.diagram.deployment.ui.FigObject;
//#endif 


//#if -1993580455 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 1030508140 
public class CrObjectWithoutClassifier extends 
//#if -2000654023 
CrUML
//#endif 

  { 

//#if -926573145 
public CrObjectWithoutClassifier()
    { 

//#if -43861456 
setupHeadAndDesc();
//#endif 


//#if 428322643 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 


//#if -1853184525 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 59657767 
if(!isActive())//1
{ 

//#if 968186622 
return false;
//#endif 

} 

//#endif 


//#if -1181872572 
ListSet offs = i.getOffenders();
//#endif 


//#if -1737476584 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -1185705582 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if -501811510 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1564005437 
return res;
//#endif 

} 

//#endif 


//#if 606813785 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if -2054209959 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -1658488102 
ListSet offs = null;
//#endif 


//#if 806448349 
for (Object obj : figs) //1
{ 

//#if 1004918075 
if(!(obj instanceof FigObject))//1
{ 

//#if -1801531381 
continue;
//#endif 

} 

//#endif 


//#if -829766427 
FigObject fo = (FigObject) obj;
//#endif 


//#if -1519547805 
if(fo != null)//1
{ 

//#if -1870439318 
Object mobj = fo.getOwner();
//#endif 


//#if -1440695842 
if(mobj != null)//1
{ 

//#if 1412253407 
Collection col = Model.getFacade().getClassifiers(mobj);
//#endif 


//#if 532152905 
if(col.size() > 0)//1
{ 

//#if 1238080049 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 505040956 
if(offs == null)//1
{ 

//#if 360522257 
offs = new ListSet();
//#endif 


//#if 1083083151 
offs.add(dd);
//#endif 

} 

//#endif 


//#if 1844926058 
offs.add(fo);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1425336670 
return offs;
//#endif 

} 

//#endif 


//#if 615142734 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -383660102 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if -1139714518 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 172570482 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 231290296 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -696354988 
if(offs == null)//1
{ 

//#if 8652667 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1999739021 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 774249581 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 533357291 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 2057283423 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -33906450 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

