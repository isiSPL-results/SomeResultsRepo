
//#if -665136344 
// Compilation Unit of /CrNodeInsideElement.java 
 

//#if -2024200026 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -777525903 
import java.util.Collection;
//#endif 


//#if 466216627 
import org.argouml.cognitive.Designer;
//#endif 


//#if 198674804 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1053769019 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -453586846 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -669358267 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -1445316287 
import org.argouml.uml.diagram.deployment.ui.FigMNode;
//#endif 


//#if -488339406 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if 191026087 
public class CrNodeInsideElement extends 
//#if 631169985 
CrUML
//#endif 

  { 

//#if 253897445 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1098504087 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if -1581060045 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -572170302 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 1421312225 
public ListSet computeOffenders(UMLDeploymentDiagram dd)
    { 

//#if 56320636 
Collection figs = dd.getLayer().getContents();
//#endif 


//#if -1344731971 
ListSet offs = null;
//#endif 


//#if 545757402 
for (Object obj : figs) //1
{ 

//#if 1209125142 
if(!(obj instanceof FigMNode))//1
{ 

//#if -595833211 
continue;
//#endif 

} 

//#endif 


//#if 529391301 
FigMNode fn = (FigMNode) obj;
//#endif 


//#if -2614016 
if(fn.getEnclosingFig() != null)//1
{ 

//#if -999963251 
if(offs == null)//1
{ 

//#if -2044651684 
offs = new ListSet();
//#endif 


//#if 993210724 
offs.add(dd);
//#endif 

} 

//#endif 


//#if -1431562118 
offs.add(fn);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 102270661 
return offs;
//#endif 

} 

//#endif 


//#if 1664095702 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 515081864 
if(!(dm instanceof UMLDeploymentDiagram))//1
{ 

//#if -1333898580 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1316887488 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) dm;
//#endif 


//#if 1832779562 
ListSet offs = computeOffenders(dd);
//#endif 


//#if -1178049338 
if(offs == null)//1
{ 

//#if 381642029 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1624583361 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if 599586411 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 328545717 
if(!isActive())//1
{ 

//#if -1660871167 
return false;
//#endif 

} 

//#endif 


//#if 445284854 
ListSet offs = i.getOffenders();
//#endif 


//#if -2069951798 
UMLDeploymentDiagram dd = (UMLDeploymentDiagram) offs.get(0);
//#endif 


//#if -426708576 
ListSet newOffs = computeOffenders(dd);
//#endif 


//#if 1144163800 
boolean res = offs.equals(newOffs);
//#endif 


//#if 1375568209 
return res;
//#endif 

} 

//#endif 


//#if 1783118627 
public CrNodeInsideElement()
    { 

//#if -1252559971 
setupHeadAndDesc();
//#endif 


//#if 1706176960 
addSupportedDecision(UMLDecision.PATTERNS);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

