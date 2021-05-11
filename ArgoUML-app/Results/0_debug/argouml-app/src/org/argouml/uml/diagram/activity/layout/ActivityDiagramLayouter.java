
//#if -682504189 
// Compilation Unit of /ActivityDiagramLayouter.java 
 

//#if 1206222286 
package org.argouml.uml.diagram.activity.layout;
//#endif 


//#if -1915657680 
import java.awt.Dimension;
//#endif 


//#if -2069691194 
import java.awt.Point;
//#endif 


//#if -1226847771 
import java.util.ArrayList;
//#endif 


//#if 2021825548 
import java.util.Iterator;
//#endif 


//#if -88731300 
import java.util.List;
//#endif 


//#if 731724373 
import org.argouml.model.Model;
//#endif 


//#if -772701036 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 2115196770 
import org.argouml.uml.diagram.layout.LayoutedObject;
//#endif 


//#if 849965331 
import org.argouml.uml.diagram.layout.Layouter;
//#endif 


//#if -1286975668 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 875266824 
public class ActivityDiagramLayouter implements 
//#if -545069867 
Layouter
//#endif 

  { 

//#if -934050083 
private ArgoDiagram diagram;
//#endif 


//#if -2143375785 
private List objects = new ArrayList();
//#endif 


//#if -1441949787 
private static final Point STARTING_POINT = new Point(100, 10);
//#endif 


//#if 1601635572 
private static final int OFFSET_Y = 25;
//#endif 


//#if 921299958 
private Object finalState = null;
//#endif 


//#if 1403785600 
public void add(LayoutedObject object)
    { 

//#if -197060732 
objects.add(object);
//#endif 

} 

//#endif 


//#if 877143083 
public ActivityDiagramLayouter(ArgoDiagram d)
    { 

//#if -1032964042 
this.diagram = d;
//#endif 

} 

//#endif 


//#if 684855930 
private int placeNodes(List seen, Object node, int index)
    { 

//#if 166955756 
if(!seen.contains(node))//1
{ 

//#if 1835706294 
seen.add(node);
//#endif 


//#if -1344920092 
if(Model.getFacade().isAFinalState(node))//1
{ 

//#if 78459697 
finalState = node;
//#endif 

} 

//#endif 


//#if -1177392804 
Fig fig = diagram.getContainingFig(node);
//#endif 


//#if -1530581966 
Point location = new Point(STARTING_POINT.x - fig.getWidth() / 2,
                                       STARTING_POINT.y + OFFSET_Y * index++);
//#endif 


//#if -1902003686 
fig.setLocation(location);
//#endif 


//#if 1508222523 
for (Iterator it = Model.getFacade().getOutgoings(node).iterator();
                    it.hasNext();) //1
{ 

//#if -1150502252 
index = placeNodes(seen, Model.getFacade().getTarget(it.next()),
                                   index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 306092656 
return index;
//#endif 

} 

//#endif 


//#if 600019876 
public LayoutedObject getObject(int index)
    { 

//#if 880904845 
return (LayoutedObject) objects.get(index);
//#endif 

} 

//#endif 


//#if 1032009222 
public void layout()
    { 

//#if -175509419 
Object first = null;
//#endif 


//#if -755141455 
for (Iterator it = diagram.getNodes().iterator(); it.hasNext();) //1
{ 

//#if -1559173080 
Object node = it.next();
//#endif 


//#if -1274115766 
if(Model.getFacade().isAPseudostate(node)
                    && Model.getDataTypesHelper().equalsINITIALKind(
                        Model.getFacade().getKind(node)))//1
{ 

//#if -1127703044 
first = node;
//#endif 


//#if 1270895148 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -164437215 
assert first != null;
//#endif 


//#if 933354166 
assert Model.getFacade().getIncomings(first).isEmpty();
//#endif 


//#if 856927155 
int lastIndex = placeNodes(new ArrayList(), first, 0);
//#endif 


//#if 1372971120 
Point location = new Point(STARTING_POINT);
//#endif 


//#if 40741989 
location.y += OFFSET_Y * (lastIndex + 2);
//#endif 


//#if -1254923086 
diagram.getContainingFig(finalState).setLocation(location);
//#endif 

} 

//#endif 


//#if 1920078782 
public Dimension getMinimumDiagramSize()
    { 

//#if -315388851 
return new Dimension(
                   STARTING_POINT.x + 300,
                   STARTING_POINT.y + OFFSET_Y * objects.size()
               );
//#endif 

} 

//#endif 


//#if 1310247161 
public void remove(LayoutedObject object)
    { 

//#if -282013220 
objects.remove(object);
//#endif 

} 

//#endif 


//#if 1313665936 
public LayoutedObject[] getObjects()
    { 

//#if 560950102 
return (LayoutedObject[]) objects.toArray();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

