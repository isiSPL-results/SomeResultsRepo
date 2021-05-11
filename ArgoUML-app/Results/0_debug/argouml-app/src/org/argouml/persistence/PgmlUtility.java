
//#if 203825745 
// Compilation Unit of /PgmlUtility.java 
 

//#if 846837613 
package org.argouml.persistence;
//#endif 


//#if 1402958715 
import java.util.ArrayList;
//#endif 


//#if 1881645382 
import java.util.Collection;
//#endif 


//#if 721184694 
import java.util.Iterator;
//#endif 


//#if -898874874 
import java.util.List;
//#endif 


//#if -173166305 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if -1379876204 
import org.argouml.uml.diagram.ui.FigEdgeAssociationClass;
//#endif 


//#if -2054533988 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1426922718 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1771718626 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 38499877 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1263939189 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if -1419571975 
public final class PgmlUtility  { 

//#if -1004116129 
public static String getVisibility(Fig f)
    { 

//#if 1796334464 
if(f.isVisible())//1
{ 

//#if 755557156 
return null;
//#endif 

} 

//#endif 


//#if 1942733113 
return "0";
//#endif 

} 

//#endif 


//#if -611689860 
public static List getContents(Diagram diagram)
    { 

//#if -456956067 
Layer lay = diagram.getLayer();
//#endif 


//#if -1762465930 
List contents = lay.getContents();
//#endif 


//#if -2066402219 
int size = contents.size();
//#endif 


//#if 1098301830 
List list = new ArrayList(size);
//#endif 


//#if 1038894838 
for (int i = 0; i < size; i++) //1
{ 

//#if 909589990 
Object o = contents.get(i);
//#endif 


//#if 1032486141 
if(!(o instanceof FigEdge))//1
{ 

//#if 50852539 
list.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1668524833 
getEdges(diagram, lay.getContentsEdgesOnly(), list);
//#endif 


//#if -1412247638 
return list;
//#endif 

} 

//#endif 


//#if 1674995006 
private static void getEdges(Diagram diagram,
                                 Collection edges, List returnEdges)
    { 

//#if -812079188 
Iterator it = edges.iterator();
//#endif 


//#if 1276464966 
while (it.hasNext()) //1
{ 

//#if -1399258409 
Object o = it.next();
//#endif 


//#if -1638446200 
if(!(o instanceof FigEdgeNote)
                    && !(o instanceof FigEdgeAssociationClass))//1
{ 

//#if 1743493714 
returnEdges.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1619949026 
it = edges.iterator();
//#endif 


//#if -472560213 
while (it.hasNext()) //2
{ 

//#if -1228784113 
Object o = it.next();
//#endif 


//#if 1671544466 
if(o instanceof FigEdgeAssociationClass)//1
{ 

//#if 837337 
returnEdges.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1648849036 
it = edges.iterator();
//#endif 


//#if -472530421 
while (it.hasNext()) //3
{ 

//#if -721617957 
Object o = it.next();
//#endif 


//#if 1956373185 
if(o instanceof FigEdgeNote)//1
{ 

//#if -2110080716 
returnEdges.add(o);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -207660716 
private PgmlUtility()
    { 
} 

//#endif 


//#if 1956244824 
public static String getEnclosingId(Fig f)
    { 

//#if -1701266767 
Fig encloser = f.getEnclosingFig();
//#endif 


//#if 54349686 
if(encloser == null)//1
{ 

//#if -666774563 
return null;
//#endif 

} 

//#endif 


//#if 1616924643 
return getId(encloser);
//#endif 

} 

//#endif 


//#if -1521296618 
public static List getEdges(Diagram diagram)
    { 

//#if 1107648384 
Layer lay = diagram.getLayer();
//#endif 


//#if -1152463789 
Collection edges = lay.getContentsEdgesOnly();
//#endif 


//#if -69025630 
List returnEdges = new ArrayList(edges.size());
//#endif 


//#if 1474761543 
getEdges(diagram, edges, returnEdges);
//#endif 


//#if -978235157 
return returnEdges;
//#endif 

} 

//#endif 


//#if 957486248 
public static String getId(Fig f)
    { 

//#if -1695952223 
if(f == null)//1
{ 

//#if 165928375 
throw new IllegalArgumentException("A fig must be supplied");
//#endif 

} 

//#endif 


//#if -166120111 
if(f.getGroup() != null)//1
{ 

//#if -1417351416 
String groupId = f.getGroup().getId();
//#endif 


//#if 813835555 
if(f.getGroup() instanceof FigGroup)//1
{ 

//#if -1780563987 
FigGroup group = (FigGroup) f.getGroup();
//#endif 


//#if 918359410 
return groupId + "." + (group.getFigs()).indexOf(f);
//#endif 

} 
else

//#if 1576378645 
if(f.getGroup() instanceof FigEdge)//1
{ 

//#if 157484250 
FigEdge edge = (FigEdge) f.getGroup();
//#endif 


//#if -1143470521 
return groupId + "."
                       + (((List) edge.getPathItemFigs()).indexOf(f) + 1);
//#endif 

} 
else
{ 

//#if 541727657 
return groupId + ".0";
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 121070417 
Layer layer = f.getLayer();
//#endif 


//#if 665753548 
if(layer == null)//1
{ 

//#if -2111089698 
return "LAYER_NULL";
//#endif 

} 

//#endif 


//#if -1242595306 
List c = layer.getContents();
//#endif 


//#if -1560316245 
int index = c.indexOf(f);
//#endif 


//#if 788717947 
return "Fig" + index;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

