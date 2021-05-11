// Compilation Unit of /PgmlUtility.java 
 
package org.argouml.persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.ui.FigEdgeAssociationClass;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Layer;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigGroup;
public final class PgmlUtility  { 
public static String getVisibility(Fig f)
    { 
if(f.isVisible())//1
{ 
return null;
} 

return "0";
} 

public static List getContents(Diagram diagram)
    { 
Layer lay = diagram.getLayer();
List contents = lay.getContents();
int size = contents.size();
List list = new ArrayList(size);
for (int i = 0; i < size; i++) //1
{ 
Object o = contents.get(i);
if(!(o instanceof FigEdge))//1
{ 
list.add(o);
} 

} 

getEdges(diagram, lay.getContentsEdgesOnly(), list);
return list;
} 

private static void getEdges(Diagram diagram,
                                 Collection edges, List returnEdges)
    { 
Iterator it = edges.iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
if(!(o instanceof FigEdgeNote)
                    && !(o instanceof FigEdgeAssociationClass))//1
{ 
returnEdges.add(o);
} 

} 

it = edges.iterator();
while (it.hasNext()) //2
{ 
Object o = it.next();
if(o instanceof FigEdgeAssociationClass)//1
{ 
returnEdges.add(o);
} 

} 

it = edges.iterator();
while (it.hasNext()) //3
{ 
Object o = it.next();
if(o instanceof FigEdgeNote)//1
{ 
returnEdges.add(o);
} 

} 

} 

private PgmlUtility()
    { 
} 

public static String getEnclosingId(Fig f)
    { 
Fig encloser = f.getEnclosingFig();
if(encloser == null)//1
{ 
return null;
} 

return getId(encloser);
} 

public static List getEdges(Diagram diagram)
    { 
Layer lay = diagram.getLayer();
Collection edges = lay.getContentsEdgesOnly();
List returnEdges = new ArrayList(edges.size());
getEdges(diagram, edges, returnEdges);
return returnEdges;
} 

public static String getId(Fig f)
    { 
if(f == null)//1
{ 
throw new IllegalArgumentException("A fig must be supplied");
} 

if(f.getGroup() != null)//1
{ 
String groupId = f.getGroup().getId();
if(f.getGroup() instanceof FigGroup)//1
{ 
FigGroup group = (FigGroup) f.getGroup();
return groupId + "." + (group.getFigs()).indexOf(f);
} 
else
if(f.getGroup() instanceof FigEdge)//1
{ 
FigEdge edge = (FigEdge) f.getGroup();
return groupId + "."
                       + (((List) edge.getPathItemFigs()).indexOf(f) + 1);
} 
else
{ 
return groupId + ".0";
} 


} 

Layer layer = f.getLayer();
if(layer == null)//1
{ 
return "LAYER_NULL";
} 

List c = layer.getContents();
int index = c.indexOf(f);
return "Fig" + index;
} 

 } 


