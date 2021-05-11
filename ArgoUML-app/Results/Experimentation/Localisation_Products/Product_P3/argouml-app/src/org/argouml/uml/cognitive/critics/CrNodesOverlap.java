package org.argouml.uml.cognitive.critics;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.diagram.deployment.ui.FigObject;
import org.argouml.uml.diagram.deployment.ui.UMLDeploymentDiagram;
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.argouml.uml.diagram.static_structure.ui.FigInterface;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.presentation.FigNode;
public class CrNodesOverlap extends CrUML
  { 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 
ListSet offs = i.getOffenders();
Diagram d = (Diagram) offs.get(0);
ListSet newOffs = computeOffenders(d);
boolean res = offs.equals(newOffs);
return res;
} 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
Diagram d = (Diagram) dm;
ListSet offs = computeOffenders(d);
return new ToDoItem(this, offs, dsgr);
} 
public CrNodesOverlap()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.CLASS_SELECTION);
addSupportedDecision(UMLDecision.EXPECTED_USAGE);
addSupportedDecision(UMLDecision.STATE_MACHINES);
setKnowledgeTypes(Critic.KT_PRESENTATION);
} 
public ListSet computeOffenders(Diagram d)
    { 
List figs = d.getLayer().getContents();
int numFigs = figs.size();
ListSet offs = null;
for (int i = 0; i < numFigs - 1; i++) //1
{ 
Object oi = figs.get(i);
if(!(oi instanceof FigNode))//1
{ 
continue;
} 
FigNode fni = (FigNode) oi;
Rectangle boundsi = fni.getBounds();
for (int j = i + 1; j < numFigs; j++) //1
{ 
Object oj = figs.get(j);
if(!(oj instanceof FigNode))//1
{ 
continue;
} 
FigNode fnj = (FigNode) oj;
if(fnj.intersects(boundsi))//1
{ 
if(!(d instanceof UMLDeploymentDiagram))//1
{ 
if(fni instanceof FigNodeModelElement)//1
{ 
if(((FigNodeModelElement) fni).getEnclosingFig()
                                    == fnj)//1
{ 
continue;
} 
} 
if(fnj instanceof FigNodeModelElement)//1
{ 
if(((FigNodeModelElement) fnj).getEnclosingFig()
                                    == fni)//1
{ 
continue;
} 
} 
} 
else
{ 
if((!((fni instanceof  FigClass)
                                || (fni instanceof FigInterface)




                                || (fni instanceof FigObject)

                              ))

                                || (!((fnj instanceof  FigClass)
                                      || (fnj instanceof FigInterface)




                                      || (fnj instanceof FigObject)

                                     )))//1
{ 
continue;
} 
} 
if(offs == null)//1
{ 
offs = new ListSet();
offs.add(d);
} 
offs.add(fni);
offs.add(fnj);
break;

} 
} 
} 
return offs;
} 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(dm instanceof Diagram))//1
{ 
return NO_PROBLEM;
} 
Diagram d = (Diagram) dm;
if(dm instanceof UMLSequenceDiagram)//1
{ 
return NO_PROBLEM;
} 
ListSet offs = computeOffenders(d);
if(offs == null)//1
{ 
return NO_PROBLEM;
} 
return PROBLEM_FOUND;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
return ret;
} 

 } 
