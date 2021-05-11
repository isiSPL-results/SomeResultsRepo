
//#if 465413379 
// Compilation Unit of /CrNodesOverlap.java 
 

//#if -1225980069 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 105654929 
import java.awt.Rectangle;
//#endif 


//#if 1590350686 
import java.util.HashSet;
//#endif 


//#if -1100067418 
import java.util.List;
//#endif 


//#if 657455280 
import java.util.Set;
//#endif 


//#if -1403574913 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1058760680 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1167684193 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -461224966 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1916765811 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 453558194 
import org.argouml.uml.diagram.deployment.ui.FigObject;
//#endif 


//#if -1570449433 
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
//#endif 


//#if -788703065 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if -867926032 
import org.argouml.uml.diagram.static_structure.ui.FigClass;
//#endif 


//#if -916826673 
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
//#endif 


//#if 1175919475 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1460675836 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -693717280 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 164468802 
public class CrNodesOverlap extends 
//#if 1304133554 
CrUML
//#endif 

  { 

//#if 746704602 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -272611930 
if(!isActive())//1
{ 

//#if -35494339 
return false;
//#endif 

} 

//#endif 


//#if 745324901 
ListSet offs = i.getOffenders();
//#endif 


//#if -501840465 
Diagram d = (Diagram) offs.get(0);
//#endif 


//#if -1554811113 
ListSet newOffs = computeOffenders(d);
//#endif 


//#if 1810261001 
boolean res = offs.equals(newOffs);
//#endif 


//#if 1229722178 
return res;
//#endif 

} 

//#endif 


//#if 1255166740 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -256961291 
Diagram d = (Diagram) dm;
//#endif 


//#if 1915859889 
ListSet offs = computeOffenders(d);
//#endif 


//#if 226096592 
return new ToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if -1998028702 
public CrNodesOverlap()
    { 

//#if 1330424236 
setupHeadAndDesc();
//#endif 


//#if -2025320835 
addSupportedDecision(UMLDecision.CLASS_SELECTION);
//#endif 


//#if -140416026 
addSupportedDecision(UMLDecision.EXPECTED_USAGE);
//#endif 


//#if -505034810 
addSupportedDecision(UMLDecision.STATE_MACHINES);
//#endif 


//#if 1033876630 
setKnowledgeTypes(Critic.KT_PRESENTATION);
//#endif 

} 

//#endif 


//#if -1103960357 
public ListSet computeOffenders(Diagram d)
    { 

//#if -293304660 
List figs = d.getLayer().getContents();
//#endif 


//#if -357341337 
int numFigs = figs.size();
//#endif 


//#if -1774552171 
ListSet offs = null;
//#endif 


//#if -244867017 
for (int i = 0; i < numFigs - 1; i++) //1
{ 

//#if 837993224 
Object oi = figs.get(i);
//#endif 


//#if -2096084707 
if(!(oi instanceof FigNode))//1
{ 

//#if 223390434 
continue;
//#endif 

} 

//#endif 


//#if 1257206418 
FigNode fni = (FigNode) oi;
//#endif 


//#if 764309070 
Rectangle boundsi = fni.getBounds();
//#endif 


//#if -1963143727 
for (int j = i + 1; j < numFigs; j++) //1
{ 

//#if -2039007175 
Object oj = figs.get(j);
//#endif 


//#if -365942481 
if(!(oj instanceof FigNode))//1
{ 

//#if -1305427173 
continue;
//#endif 

} 

//#endif 


//#if -1872153631 
FigNode fnj = (FigNode) oj;
//#endif 


//#if 779461103 
if(fnj.intersects(boundsi))//1
{ 

//#if -856595279 
if(!(d instanceof UMLDeploymentDiagram))//1
{ 

//#if 628212036 
if(fni instanceof FigNodeModelElement)//1
{ 

//#if -889108132 
if(((FigNodeModelElement) fni).getEnclosingFig()
                                    == fnj)//1
{ 

//#if 1566321703 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1653704035 
if(fnj instanceof FigNodeModelElement)//1
{ 

//#if 1229469515 
if(((FigNodeModelElement) fnj).getEnclosingFig()
                                    == fni)//1
{ 

//#if -790303086 
continue;
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if 727526165 
if((!((fni instanceof  FigClass)
                                || (fni instanceof FigInterface)




                                || (fni instanceof FigObject)

                              ))

                                || (!((fnj instanceof  FigClass)
                                      || (fnj instanceof FigInterface)




                                      || (fnj instanceof FigObject)

                                     )))//1
{ 

//#if 698088087 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -515660490 
if(offs == null)//1
{ 

//#if 1916023598 
offs = new ListSet();
//#endif 


//#if 616456182 
offs.add(d);
//#endif 

} 

//#endif 


//#if 655445514 
offs.add(fni);
//#endif 


//#if 655446475 
offs.add(fnj);
//#endif 


//#if -1185688732 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -718143587 
return offs;
//#endif 

} 

//#endif 


//#if -1656294521 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 69705543 
if(!(dm instanceof Diagram))//1
{ 

//#if 1424810649 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1563338818 
Diagram d = (Diagram) dm;
//#endif 


//#if 1908648328 
if(dm instanceof UMLSequenceDiagram)//1
{ 

//#if 186740266 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -491323836 
ListSet offs = computeOffenders(d);
//#endif 


//#if 1509457760 
if(offs == null)//1
{ 

//#if -206728475 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1631792153 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -714370402 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1499420487 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -169087487 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

