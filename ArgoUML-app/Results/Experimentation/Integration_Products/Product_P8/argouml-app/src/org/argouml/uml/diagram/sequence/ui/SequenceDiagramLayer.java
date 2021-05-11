package org.argouml.uml.diagram.sequence.ui;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.apache.log4j.Logger;
import org.tigris.gef.base.LayerPerspectiveMutable;
import org.tigris.gef.graph.GraphEvent;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
public class SequenceDiagramLayer extends LayerPerspectiveMutable
  { 
private static final Logger LOG =
        Logger.getLogger(SequenceDiagramLayer.class);
public static final int OBJECT_DISTANCE = 30;
public static final int DIAGRAM_LEFT_MARGIN = 50;
public static final int DIAGRAM_TOP_MARGIN = 50;
public static final int LINK_DISTANCE = 32;
private List figObjectsX = new LinkedList();
private static final long serialVersionUID = 4291295642883664670L;
public void updateActivations()
    { 
makeUniformNodeCount();
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 
Object fig = it.next();
if(fig instanceof FigClassifierRole)//1
{ 
((FigClassifierRole) fig).updateActivations();
((FigClassifierRole) fig).damage();
} 
} 
} 
private void updateNodeStates(FigMessagePort fmp, FigLifeLine lifeLine)
    { 
if(lifeLine != null)//1
{ 
((FigClassifierRole) lifeLine.getGroup()).updateNodeStates();
} 
} 
private void reshuffleFigClassifierRolesX(Fig f)
    { 
figObjectsX.remove(f);
int x = f.getX();
int i;
for (i = 0; i < figObjectsX.size(); i++) //1
{ 
Fig fig = (Fig) figObjectsX.get(i);
if(fig.getX() > x)//1
{ 
break;

} 
} 
figObjectsX.add(i, f);
} 
public List getFigMessages(int y)
    { 
if(getContents().isEmpty()
                || getContentsEdgesOnly().isEmpty())//1
{ 
return Collections.EMPTY_LIST;
} 
List retList = new ArrayList();
Iterator it = getContentsEdgesOnly().iterator();
while (it.hasNext()) //1
{ 
FigEdge fig = (FigEdge) it.next();
if(fig instanceof FigMessage
                    && fig.hit(new Rectangle(fig.getX(), y, 8, 8)))//1
{ 
retList.add(fig);
} 
} 
return retList;
} 
private void removeFigMessagePort(FigMessagePort fmp)
    { 
Fig parent = fmp.getGroup();
if(parent instanceof FigLifeLine)//1
{ 
((FigClassifierRole) parent.getGroup()).removeFigMessagePort(fmp);
} 
} 
int makeUniformNodeCount()
    { 
int maxNodes = -1;
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 
Object o = it.next();
if(o instanceof FigClassifierRole)//1
{ 
int nodeCount = ((FigClassifierRole) o).getNodeCount();
if(nodeCount > maxNodes)//1
{ 
maxNodes = nodeCount;
} 
} 
} 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //2
{ 
Object o = it.next();
if(o instanceof FigClassifierRole)//1
{ 
((FigClassifierRole) o).growToSize(maxNodes);
} 
} 
return maxNodes;
} 
public void nodeAdded(GraphEvent ge)
    { 
super.nodeAdded(ge);
Fig fig = presentationFor(ge.getArg());
if(fig instanceof FigClassifierRole)//1
{ 
((FigClassifierRole) fig).renderingChanged();
} 
} 
public void add(Fig f)
    { 
super.add(f);
if(f instanceof FigClassifierRole)//1
{ 
if(!figObjectsX.isEmpty())//1
{ 
ListIterator it = figObjectsX.listIterator(0);
while (it.hasNext()) //1
{ 
Fig fig = (Fig) it.next();
if(fig.getX() >= f.getX())//1
{ 
it.previous();
it.add(f);
break;

} 
} 
if(!it.hasNext())//1
{ 
it.add(f);
} 
} 
else
{ 
figObjectsX.add(f);
} 
distributeFigClassifierRoles((FigClassifierRole) f);
} 
} 
public void remove(Fig f)
    { 
if(f instanceof FigMessage)//1
{ 
LOG.info("Removing a FigMessage");
FigMessage fm = (FigMessage) f;
FigMessagePort source = (FigMessagePort) fm.getSourcePortFig();
FigMessagePort dest = (FigMessagePort) fm.getDestPortFig();
if(source != null)//1
{ 
removeFigMessagePort(source);
} 
if(dest != null)//1
{ 
removeFigMessagePort(dest);
} 
if(source != null)//2
{ 
FigLifeLine sourceLifeLine = (FigLifeLine) source.getGroup();
updateNodeStates(source, sourceLifeLine);
} 
if(dest != null && fm.getSourceFigNode() != fm.getDestFigNode())//1
{ 
FigLifeLine destLifeLine = (FigLifeLine) dest.getGroup();
updateNodeStates(dest, destLifeLine);
} 
} 
super.remove(f);
LOG.info("A Fig has been removed, updating activations");
updateActivations();
} 
public void contractDiagram(int startNodeIndex, int numberOfNodes)
    { 
if(makeUniformNodeCount() <= startNodeIndex)//1
{ 
return;
} 
boolean[] emptyArray = new boolean[numberOfNodes];
java.util.Arrays.fill(emptyArray, true);
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 
((FigClassifierRole) it.next())
            .updateEmptyNodeArray(startNodeIndex, emptyArray);
} 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //2
{ 
((FigClassifierRole) it.next())
            .contractNodes(startNodeIndex, emptyArray);
} 
updateActivations();
} 
public void expandDiagram(int startNodeIndex, int numberOfNodes)
    { 
if(makeUniformNodeCount() <= startNodeIndex)//1
{ 
return;
} 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 
((FigClassifierRole) it.next())
            .grow(startNodeIndex, numberOfNodes);
} 
updateActivations();
} 
public void deleted(Fig f)
    { 
super.deleted(f);
figObjectsX.remove(f);
if(!figObjectsX.isEmpty())//1
{ 
putInPosition((Fig) figObjectsX.get(0));
} 
} 
public SequenceDiagramLayer(String name, MutableGraphModel gm)
    { 
super(name, gm);
} 
public void putInPosition(Fig f)
    { 
if(f instanceof FigClassifierRole)//1
{ 
distributeFigClassifierRoles((FigClassifierRole) f);
} 
else
{ 
super.putInPosition(f);
} 
} 
public int getNodeIndex(int y)
    { 
FigClassifierRole figClassifierRole = null;
for (Object fig : getContentsNoEdges()) //1
{ 
if(fig instanceof FigClassifierRole)//1
{ 
figClassifierRole = (FigClassifierRole) fig;
} 
} 
if(figClassifierRole == null)//1
{ 
return 0;
} 
y -= figClassifierRole.getY()
             + figClassifierRole.getHeadFig().getHeight();
y += LINK_DISTANCE / 2;
if(y < 0)//1
{ 
y = 0;
} 
return y / LINK_DISTANCE;
} 
private void distributeFigClassifierRoles(FigClassifierRole f)
    { 
reshuffleFigClassifierRolesX(f);
int listPosition = figObjectsX.indexOf(f);
Iterator it =
            figObjectsX.subList(listPosition, figObjectsX.size()).iterator();
int positionX =
            listPosition == 0
            ? DIAGRAM_LEFT_MARGIN
            : (((Fig) figObjectsX.get(listPosition - 1)).getX()
               + ((Fig) figObjectsX.get(listPosition - 1)).getWidth()
               + OBJECT_DISTANCE);
while (it.hasNext()) //1
{ 
FigClassifierRole fig = (FigClassifierRole) it.next();
Rectangle r = fig.getBounds();
if(r.x < positionX)//1
{ 
r.x = positionX;
} 
r.y = DIAGRAM_TOP_MARGIN;
fig.setBounds(r);
fig.updateEdges();
positionX = (fig.getX() + fig.getWidth() + OBJECT_DISTANCE);
} 
} 

 } 
