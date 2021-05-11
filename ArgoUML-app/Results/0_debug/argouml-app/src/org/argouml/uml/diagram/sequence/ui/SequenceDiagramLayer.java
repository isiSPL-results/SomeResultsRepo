
//#if -1656254852 
// Compilation Unit of /SequenceDiagramLayer.java 
 

//#if 1633833627 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if -533687476 
import java.awt.Rectangle;
//#endif 


//#if -908305792 
import java.util.ArrayList;
//#endif 


//#if 1869334594 
import java.util.Collections;
//#endif 


//#if -877392879 
import java.util.Iterator;
//#endif 


//#if 67250760 
import java.util.LinkedList;
//#endif 


//#if 994200545 
import java.util.List;
//#endif 


//#if 178154259 
import java.util.ListIterator;
//#endif 


//#if -398796291 
import org.apache.log4j.Logger;
//#endif 


//#if -380134919 
import org.tigris.gef.base.LayerPerspectiveMutable;
//#endif 


//#if 1944535883 
import org.tigris.gef.graph.GraphEvent;
//#endif 


//#if 2103654174 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 1229180775 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1529590570 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -1790304457 
public class SequenceDiagramLayer extends 
//#if 1595012946 
LayerPerspectiveMutable
//#endif 

  { 

//#if 1425782372 
private static final Logger LOG =
        Logger.getLogger(SequenceDiagramLayer.class);
//#endif 


//#if -948293699 
public static final int OBJECT_DISTANCE = 30;
//#endif 


//#if -1242709084 
public static final int DIAGRAM_LEFT_MARGIN = 50;
//#endif 


//#if 1093726752 
public static final int DIAGRAM_TOP_MARGIN = 50;
//#endif 


//#if 1964737760 
public static final int LINK_DISTANCE = 32;
//#endif 


//#if 1929376624 
private List figObjectsX = new LinkedList();
//#endif 


//#if -1682769126 
private static final long serialVersionUID = 4291295642883664670L;
//#endif 


//#if -1635454801 
public void updateActivations()
    { 

//#if -1337898638 
makeUniformNodeCount();
//#endif 


//#if 2101526006 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 

//#if -994370386 
Object fig = it.next();
//#endif 


//#if 1010587372 
if(fig instanceof FigClassifierRole)//1
{ 

//#if 73695929 
((FigClassifierRole) fig).updateActivations();
//#endif 


//#if 392422904 
((FigClassifierRole) fig).damage();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 666604761 
private void updateNodeStates(FigMessagePort fmp, FigLifeLine lifeLine)
    { 

//#if 943357108 
if(lifeLine != null)//1
{ 

//#if -1399912835 
((FigClassifierRole) lifeLine.getGroup()).updateNodeStates();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -427043865 
private void reshuffleFigClassifierRolesX(Fig f)
    { 

//#if -1562992705 
figObjectsX.remove(f);
//#endif 


//#if 571563489 
int x = f.getX();
//#endif 


//#if 1200198652 
int i;
//#endif 


//#if 564958836 
for (i = 0; i < figObjectsX.size(); i++) //1
{ 

//#if -1883880061 
Fig fig = (Fig) figObjectsX.get(i);
//#endif 


//#if -1119327158 
if(fig.getX() > x)//1
{ 

//#if 1322214280 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1051168413 
figObjectsX.add(i, f);
//#endif 

} 

//#endif 


//#if -1651833119 
public List getFigMessages(int y)
    { 

//#if -1706226292 
if(getContents().isEmpty()
                || getContentsEdgesOnly().isEmpty())//1
{ 

//#if 1586827281 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 976718568 
List retList = new ArrayList();
//#endif 


//#if 1742670550 
Iterator it = getContentsEdgesOnly().iterator();
//#endif 


//#if 199960745 
while (it.hasNext()) //1
{ 

//#if 453105471 
FigEdge fig = (FigEdge) it.next();
//#endif 


//#if 1554820359 
if(fig instanceof FigMessage
                    && fig.hit(new Rectangle(fig.getX(), y, 8, 8)))//1
{ 

//#if -1802103661 
retList.add(fig);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 732567947 
return retList;
//#endif 

} 

//#endif 


//#if -1358224490 
private void removeFigMessagePort(FigMessagePort fmp)
    { 

//#if -1780305587 
Fig parent = fmp.getGroup();
//#endif 


//#if 2045245675 
if(parent instanceof FigLifeLine)//1
{ 

//#if -551843417 
((FigClassifierRole) parent.getGroup()).removeFigMessagePort(fmp);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1147075086 
int makeUniformNodeCount()
    { 

//#if -163668904 
int maxNodes = -1;
//#endif 


//#if -366277223 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 

//#if 2022382417 
Object o = it.next();
//#endif 


//#if 1228905843 
if(o instanceof FigClassifierRole)//1
{ 

//#if -897539682 
int nodeCount = ((FigClassifierRole) o).getNodeCount();
//#endif 


//#if -848192557 
if(nodeCount > maxNodes)//1
{ 

//#if -775723812 
maxNodes = nodeCount;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1747225208 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //2
{ 

//#if 2047572469 
Object o = it.next();
//#endif 


//#if -163849393 
if(o instanceof FigClassifierRole)//1
{ 

//#if -1239100082 
((FigClassifierRole) o).growToSize(maxNodes);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 77086464 
return maxNodes;
//#endif 

} 

//#endif 


//#if -699619313 
public void nodeAdded(GraphEvent ge)
    { 

//#if 2112303611 
super.nodeAdded(ge);
//#endif 


//#if 117950043 
Fig fig = presentationFor(ge.getArg());
//#endif 


//#if -1435627280 
if(fig instanceof FigClassifierRole)//1
{ 

//#if 1170443119 
((FigClassifierRole) fig).renderingChanged();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1031431238 
public void add(Fig f)
    { 

//#if 215873366 
super.add(f);
//#endif 


//#if 1574449364 
if(f instanceof FigClassifierRole)//1
{ 

//#if -178267196 
if(!figObjectsX.isEmpty())//1
{ 

//#if 1810659302 
ListIterator it = figObjectsX.listIterator(0);
//#endif 


//#if 1279961974 
while (it.hasNext()) //1
{ 

//#if 1710218331 
Fig fig = (Fig) it.next();
//#endif 


//#if 1900412579 
if(fig.getX() >= f.getX())//1
{ 

//#if 1268547237 
it.previous();
//#endif 


//#if -706238029 
it.add(f);
//#endif 


//#if -1869171199 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1193032757 
if(!it.hasNext())//1
{ 

//#if -190583751 
it.add(f);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1153390849 
figObjectsX.add(f);
//#endif 

} 

//#endif 


//#if -2082217467 
distributeFigClassifierRoles((FigClassifierRole) f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1059100695 
public void remove(Fig f)
    { 

//#if 1753799978 
if(f instanceof FigMessage)//1
{ 

//#if 1463917004 
LOG.info("Removing a FigMessage");
//#endif 


//#if 1266169661 
FigMessage fm = (FigMessage) f;
//#endif 


//#if 280865683 
FigMessagePort source = (FigMessagePort) fm.getSourcePortFig();
//#endif 


//#if 1800559667 
FigMessagePort dest = (FigMessagePort) fm.getDestPortFig();
//#endif 


//#if -2061763736 
if(source != null)//1
{ 

//#if -2086732036 
removeFigMessagePort(source);
//#endif 

} 

//#endif 


//#if -1119896145 
if(dest != null)//1
{ 

//#if -374761332 
removeFigMessagePort(dest);
//#endif 

} 

//#endif 


//#if 323917385 
if(source != null)//2
{ 

//#if -1289983857 
FigLifeLine sourceLifeLine = (FigLifeLine) source.getGroup();
//#endif 


//#if -28671711 
updateNodeStates(source, sourceLifeLine);
//#endif 

} 

//#endif 


//#if 2054282604 
if(dest != null && fm.getSourceFigNode() != fm.getDestFigNode())//1
{ 

//#if -573026022 
FigLifeLine destLifeLine = (FigLifeLine) dest.getGroup();
//#endif 


//#if 2081286180 
updateNodeStates(dest, destLifeLine);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1121583391 
super.remove(f);
//#endif 


//#if 932963330 
LOG.info("A Fig has been removed, updating activations");
//#endif 


//#if -145334114 
updateActivations();
//#endif 

} 

//#endif 


//#if -174350165 
public void contractDiagram(int startNodeIndex, int numberOfNodes)
    { 

//#if -885199199 
if(makeUniformNodeCount() <= startNodeIndex)//1
{ 

//#if -537270386 
return;
//#endif 

} 

//#endif 


//#if 2089554572 
boolean[] emptyArray = new boolean[numberOfNodes];
//#endif 


//#if 1269036102 
java.util.Arrays.fill(emptyArray, true);
//#endif 


//#if 590164206 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 

//#if -421956104 
((FigClassifierRole) it.next())
            .updateEmptyNodeArray(startNodeIndex, emptyArray);
//#endif 

} 

//#endif 


//#if -2014172413 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //2
{ 

//#if -233833686 
((FigClassifierRole) it.next())
            .contractNodes(startNodeIndex, emptyArray);
//#endif 

} 

//#endif 


//#if -2091602097 
updateActivations();
//#endif 

} 

//#endif 


//#if 890678435 
public void expandDiagram(int startNodeIndex, int numberOfNodes)
    { 

//#if 1253948864 
if(makeUniformNodeCount() <= startNodeIndex)//1
{ 

//#if 1513857323 
return;
//#endif 

} 

//#endif 


//#if 921232717 
for (Iterator it = figObjectsX.iterator(); it.hasNext();) //1
{ 

//#if 721028386 
((FigClassifierRole) it.next())
            .grow(startNodeIndex, numberOfNodes);
//#endif 

} 

//#endif 


//#if -1298549936 
updateActivations();
//#endif 

} 

//#endif 


//#if 946830386 
public void deleted(Fig f)
    { 

//#if 1932976679 
super.deleted(f);
//#endif 


//#if 1172144713 
figObjectsX.remove(f);
//#endif 


//#if -308899199 
if(!figObjectsX.isEmpty())//1
{ 

//#if -2101362703 
putInPosition((Fig) figObjectsX.get(0));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1680930523 
public SequenceDiagramLayer(String name, MutableGraphModel gm)
    { 

//#if -901244937 
super(name, gm);
//#endif 

} 

//#endif 


//#if -1679725706 
public void putInPosition(Fig f)
    { 

//#if -1069656156 
if(f instanceof FigClassifierRole)//1
{ 

//#if -1377008375 
distributeFigClassifierRoles((FigClassifierRole) f);
//#endif 

} 
else
{ 

//#if -1202178836 
super.putInPosition(f);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1202061202 
public int getNodeIndex(int y)
    { 

//#if -1319340600 
FigClassifierRole figClassifierRole = null;
//#endif 


//#if -171025901 
for (Object fig : getContentsNoEdges()) //1
{ 

//#if -2100598716 
if(fig instanceof FigClassifierRole)//1
{ 

//#if 459035424 
figClassifierRole = (FigClassifierRole) fig;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -472493232 
if(figClassifierRole == null)//1
{ 

//#if 143279396 
return 0;
//#endif 

} 

//#endif 


//#if 264998509 
y -= figClassifierRole.getY()
             + figClassifierRole.getHeadFig().getHeight();
//#endif 


//#if 327196696 
y += LINK_DISTANCE / 2;
//#endif 


//#if 1024298555 
if(y < 0)//1
{ 

//#if 858993670 
y = 0;
//#endif 

} 

//#endif 


//#if -1137130632 
return y / LINK_DISTANCE;
//#endif 

} 

//#endif 


//#if -1247300451 
private void distributeFigClassifierRoles(FigClassifierRole f)
    { 

//#if -938348073 
reshuffleFigClassifierRolesX(f);
//#endif 


//#if -1949672641 
int listPosition = figObjectsX.indexOf(f);
//#endif 


//#if 1785677441 
Iterator it =
            figObjectsX.subList(listPosition, figObjectsX.size()).iterator();
//#endif 


//#if 558562895 
int positionX =
            listPosition == 0
            ? DIAGRAM_LEFT_MARGIN
            : (((Fig) figObjectsX.get(listPosition - 1)).getX()
               + ((Fig) figObjectsX.get(listPosition - 1)).getWidth()
               + OBJECT_DISTANCE);
//#endif 


//#if 1010362135 
while (it.hasNext()) //1
{ 

//#if 204821229 
FigClassifierRole fig = (FigClassifierRole) it.next();
//#endif 


//#if 983126732 
Rectangle r = fig.getBounds();
//#endif 


//#if 1555321779 
if(r.x < positionX)//1
{ 

//#if -1565927900 
r.x = positionX;
//#endif 

} 

//#endif 


//#if -1590078448 
r.y = DIAGRAM_TOP_MARGIN;
//#endif 


//#if 1217047746 
fig.setBounds(r);
//#endif 


//#if 632884350 
fig.updateEdges();
//#endif 


//#if 1127523650 
positionX = (fig.getX() + fig.getWidth() + OBJECT_DISTANCE);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

