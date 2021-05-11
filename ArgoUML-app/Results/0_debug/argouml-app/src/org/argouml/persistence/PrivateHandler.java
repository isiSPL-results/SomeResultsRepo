
//#if 103575254 
// Compilation Unit of /PrivateHandler.java 
 

//#if -1448538771 
package org.argouml.persistence;
//#endif 


//#if -144879956 
import java.util.StringTokenizer;
//#endif 


//#if -2124824961 
import org.argouml.uml.diagram.ui.PathItemPlacement;
//#endif 


//#if -902713009 
import org.argouml.util.IItemUID;
//#endif 


//#if -528300938 
import org.argouml.util.ItemUID;
//#endif 


//#if -1458784113 
import org.tigris.gef.base.PathItemPlacementStrategy;
//#endif 


//#if -1516905542 
import org.tigris.gef.persistence.pgml.Container;
//#endif 


//#if 168797522 
import org.tigris.gef.persistence.pgml.FigEdgeHandler;
//#endif 


//#if -754681844 
import org.tigris.gef.persistence.pgml.FigGroupHandler;
//#endif 


//#if 1131347431 
import org.tigris.gef.persistence.pgml.PGMLHandler;
//#endif 


//#if -190959134 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 894066725 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 1309029672 
import org.xml.sax.Attributes;
//#endif 


//#if -1414538310 
import org.xml.sax.SAXException;
//#endif 


//#if 319874936 
import org.apache.log4j.Logger;
//#endif 


//#if -1748504563 
class PrivateHandler extends 
//#if -1674790560 
org.tigris.gef.persistence.pgml.PrivateHandler
//#endif 

  { 

//#if -1960456632 
private Container container;
//#endif 


//#if 1665185445 
private static final Logger LOG = Logger.getLogger(PrivateHandler.class);
//#endif 


//#if -1123312251 
public void gotElement(String contents)
    throws SAXException
    { 

//#if -633034148 
if(container instanceof PGMLHandler)//1
{ 

//#if -2111019547 
Object o = getPGMLStackParser().getDiagram();
//#endif 


//#if 132729849 
if(o instanceof IItemUID)//1
{ 

//#if -1009054787 
ItemUID uid = getItemUID(contents);
//#endif 


//#if 458307274 
if(uid != null)//1
{ 

//#if -316975042 
((IItemUID) o).setItemUID(uid);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -405147458 
return;
//#endif 

} 

//#endif 


//#if 675725847 
if(container instanceof FigGroupHandler)//1
{ 

//#if -771759771 
Object o = ((FigGroupHandler) container).getFigGroup();
//#endif 


//#if -1189710481 
if(o instanceof IItemUID)//1
{ 

//#if -14973899 
ItemUID uid = getItemUID(contents);
//#endif 


//#if 1690410818 
if(uid != null)//1
{ 

//#if -1584025970 
((IItemUID) o).setItemUID(uid);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1754264815 
if(container instanceof FigEdgeHandler)//1
{ 

//#if -1224896565 
Object o = ((FigEdgeHandler) container).getFigEdge();
//#endif 


//#if 643356957 
if(o instanceof IItemUID)//1
{ 

//#if -538633595 
ItemUID uid = getItemUID(contents);
//#endif 


//#if -73280110 
if(uid != null)//1
{ 

//#if -1383127877 
((IItemUID) o).setItemUID(uid);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1318285357 
super.gotElement(contents);
//#endif 

} 

//#endif 


//#if 216426394 
public PrivateHandler(PGMLStackParser parser, Container cont)
    { 

//#if 959419234 
super(parser, cont);
//#endif 


//#if -1885204437 
container = cont;
//#endif 

} 

//#endif 


//#if 1283820756 
private ItemUID getItemUID(String privateContents)
    { 

//#if -1895655520 
StringTokenizer st = new StringTokenizer(privateContents, "\n");
//#endif 


//#if 2080484020 
while (st.hasMoreElements()) //1
{ 

//#if 1092334661 
String str = st.nextToken();
//#endif 


//#if 1072212522 
NameVal nval = splitNameVal(str);
//#endif 


//#if 841301226 
if(nval != null)//1
{ 

//#if -1647284788 
if(LOG.isDebugEnabled())//1
{ 

//#if 1008447659 
LOG.debug("Private Element: \"" + nval.getName()
                              + "\" \"" + nval.getValue() + "\"");
//#endif 

} 

//#endif 


//#if 915422393 
if("ItemUID".equals(nval.getName())
                        && nval.getValue().length() > 0)//1
{ 

//#if 484307350 
return new ItemUID(nval.getValue());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 827422857 
return null;
//#endif 

} 

//#endif 


//#if 217973235 
public void startElement(String uri, String localname, String qname,
                             Attributes attributes) throws SAXException
    { 

//#if 480559056 
if("argouml:pathitem".equals(qname)
                && container instanceof FigEdgeHandler)//1
{ 

//#if -479366118 
String classname = attributes.getValue("classname");
//#endif 


//#if -1585288834 
String figclassname =
                attributes.getValue("figclassname");
//#endif 


//#if -606471302 
String ownerhref = attributes.getValue("ownerhref");
//#endif 


//#if -1244342758 
String angle = attributes.getValue("angle");
//#endif 


//#if -1319629226 
String offset = attributes.getValue("offset");
//#endif 


//#if 63285704 
if(classname != null
                    && figclassname != null
                    && ownerhref != null
                    && angle != null
                    && offset != null)//1
{ 

//#if 367338905 
if("org.argouml.uml.diagram.ui.PathItemPlacement".equals(
                            classname))//1
{ 

//#if -1310509593 
PathItemPlacementStrategy pips
                        = getPips(figclassname, ownerhref);
//#endif 


//#if -272657751 
if(pips != null
                            && classname.equals(pips.getClass().getName()))//1
{ 

//#if -1292673525 
if(pips instanceof PathItemPlacement)//1
{ 

//#if 1390020273 
PathItemPlacement pip =
                                (PathItemPlacement) pips;
//#endif 


//#if 503091009 
pip.setDisplacementVector(
                                Double.parseDouble(angle),
                                Integer.parseInt(offset));
//#endif 

} 

//#endif 

} 
else
{ 

//#if 816022476 
LOG.warn("PGML stored pathitem class name does "
                                 + "not match the class name on the "
                                 + "diagram. Label position will revert "
                                 + "to defaults.");
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -2145793213 
LOG.warn("Could not find all attributes for <"
                         + qname + "> tag, ignoring.");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 604841468 
super.startElement(uri, localname, qname, attributes);
//#endif 

} 

//#endif 


//#if 277968541 
protected NameVal splitNameVal(String str)
    { 

//#if 467427978 
NameVal rv = null;
//#endif 


//#if 47923595 
int lqpos, rqpos;
//#endif 


//#if 2134325770 
int eqpos = str.indexOf('=');
//#endif 


//#if 662890784 
if(eqpos < 0)//1
{ 

//#if -2085981243 
return null;
//#endif 

} 

//#endif 


//#if -1857492183 
lqpos = str.indexOf('"', eqpos);
//#endif 


//#if 2003541885 
rqpos = str.lastIndexOf('"');
//#endif 


//#if 40948640 
if(lqpos < 0 || rqpos <= lqpos)//1
{ 

//#if 1839021942 
return null;
//#endif 

} 

//#endif 


//#if 432800332 
rv =
            new NameVal(str.substring(0, eqpos),
                        str.substring(lqpos + 1, rqpos));
//#endif 


//#if -459346592 
return rv;
//#endif 

} 

//#endif 


//#if 474233461 
private PathItemPlacementStrategy getPips(String figclassname,
            String ownerhref)
    { 

//#if 1295416156 
if(container instanceof FigEdgeHandler)//1
{ 

//#if -219082638 
FigEdge fe = ((FigEdgeHandler) container).getFigEdge();
//#endif 


//#if 1683108499 
Object owner = getPGMLStackParser().findOwner(ownerhref);
//#endif 


//#if 385387930 
for (Object o : fe.getPathItemFigs()) //1
{ 

//#if -737931355 
Fig f = (Fig) o;
//#endif 


//#if 1087494783 
if(owner.equals(f.getOwner())
                        && figclassname.equals(f.getClass().getName()))//1
{ 

//#if 890795513 
return fe.getPathItemPlacementStrategy(f);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1771234847 
LOG.warn("Could not load path item for fig '" + figclassname
                 + "', using default placement.");
//#endif 


//#if 450315547 
return null;
//#endif 

} 

//#endif 


//#if 592370460 
static class NameVal  { 

//#if 149466060 
private String name;
//#endif 


//#if 567500718 
private String value;
//#endif 


//#if 155826333 
String getValue()
        { 

//#if -1372156066 
return value;
//#endif 

} 

//#endif 


//#if 1300026625 
String getName()
        { 

//#if 2050770038 
return name;
//#endif 

} 

//#endif 


//#if 910860021 
NameVal(String n, String v)
        { 

//#if 740983091 
name = n.trim();
//#endif 


//#if -83783897 
value = v.trim();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

