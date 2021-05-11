package org.argouml.persistence;
import java.util.StringTokenizer;
import org.argouml.uml.diagram.ui.PathItemPlacement;
import org.argouml.util.IItemUID;
import org.argouml.util.ItemUID;
import org.tigris.gef.base.PathItemPlacementStrategy;
import org.tigris.gef.persistence.pgml.Container;
import org.tigris.gef.persistence.pgml.FigEdgeHandler;
import org.tigris.gef.persistence.pgml.FigGroupHandler;
import org.tigris.gef.persistence.pgml.PGMLHandler;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
class PrivateHandler extends org.tigris.gef.persistence.pgml.PrivateHandler
  { 
private Container container;
public void gotElement(String contents)
    throws SAXException
    { 
if(container instanceof PGMLHandler)//1
{ 
Object o = getPGMLStackParser().getDiagram();
if(o instanceof IItemUID)//1
{ 
ItemUID uid = getItemUID(contents);
if(uid != null)//1
{ 
((IItemUID) o).setItemUID(uid);
} 
} 
return;
} 
if(container instanceof FigGroupHandler)//1
{ 
Object o = ((FigGroupHandler) container).getFigGroup();
if(o instanceof IItemUID)//1
{ 
ItemUID uid = getItemUID(contents);
if(uid != null)//1
{ 
((IItemUID) o).setItemUID(uid);
} 
} 
} 
if(container instanceof FigEdgeHandler)//1
{ 
Object o = ((FigEdgeHandler) container).getFigEdge();
if(o instanceof IItemUID)//1
{ 
ItemUID uid = getItemUID(contents);
if(uid != null)//1
{ 
((IItemUID) o).setItemUID(uid);
} 
} 
} 
super.gotElement(contents);
} 
public PrivateHandler(PGMLStackParser parser, Container cont)
    { 
super(parser, cont);
container = cont;
} 
private ItemUID getItemUID(String privateContents)
    { 
StringTokenizer st = new StringTokenizer(privateContents, "\n");
while (st.hasMoreElements()) //1
{ 
String str = st.nextToken();
NameVal nval = splitNameVal(str);
if(nval != null)//1
{ 
if("ItemUID".equals(nval.getName())
                        && nval.getValue().length() > 0)//1
{ 
return new ItemUID(nval.getValue());
} 
} 
} 
return null;
} 
public void startElement(String uri, String localname, String qname,
                             Attributes attributes) throws SAXException
    { 
if("argouml:pathitem".equals(qname)
                && container instanceof FigEdgeHandler)//1
{ 
String classname = attributes.getValue("classname");
String figclassname =
                attributes.getValue("figclassname");
String ownerhref = attributes.getValue("ownerhref");
String angle = attributes.getValue("angle");
String offset = attributes.getValue("offset");
if(classname != null
                    && figclassname != null
                    && ownerhref != null
                    && angle != null
                    && offset != null)//1
{ 
if("org.argouml.uml.diagram.ui.PathItemPlacement".equals(
                            classname))//1
{ 
PathItemPlacementStrategy pips
                        = getPips(figclassname, ownerhref);
if(pips != null
                            && classname.equals(pips.getClass().getName()))//1
{ 
if(pips instanceof PathItemPlacement)//1
{ 
PathItemPlacement pip =
                                (PathItemPlacement) pips;
pip.setDisplacementVector(
                                Double.parseDouble(angle),
                                Integer.parseInt(offset));
} 
} 
} 
} 
} 
super.startElement(uri, localname, qname, attributes);
} 
protected NameVal splitNameVal(String str)
    { 
NameVal rv = null;
int lqpos, rqpos;
int eqpos = str.indexOf('=');
if(eqpos < 0)//1
{ 
return null;
} 
lqpos = str.indexOf('"', eqpos);
rqpos = str.lastIndexOf('"');
if(lqpos < 0 || rqpos <= lqpos)//1
{ 
return null;
} 
rv =
            new NameVal(str.substring(0, eqpos),
                        str.substring(lqpos + 1, rqpos));
return rv;
} 
private PathItemPlacementStrategy getPips(String figclassname,
            String ownerhref)
    { 
if(container instanceof FigEdgeHandler)//1
{ 
FigEdge fe = ((FigEdgeHandler) container).getFigEdge();
Object owner = getPGMLStackParser().findOwner(ownerhref);
for (Object o : fe.getPathItemFigs()) //1
{ 
Fig f = (Fig) o;
if(owner.equals(f.getOwner())
                        && figclassname.equals(f.getClass().getName()))//1
{ 
return fe.getPathItemPlacementStrategy(f);
} 
} 
} 
return null;
} 
static class NameVal  { 
private String name;
private String value;
String getValue()
        { 
return value;
} 
String getName()
        { 
return name;
} 
NameVal(String n, String v)
        { 
name = n.trim();
value = v.trim();
} 

 } 

 } 
