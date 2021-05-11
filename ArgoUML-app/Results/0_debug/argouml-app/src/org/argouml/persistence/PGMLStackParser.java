
//#if 1608093675 
// Compilation Unit of /PGMLStackParser.java 
 

//#if 1600693288 
package org.argouml.persistence;
//#endif 


//#if 1381680108 
import java.awt.Rectangle;
//#endif 


//#if -1408482999 
import java.io.InputStream;
//#endif 


//#if -819467518 
import java.lang.reflect.Constructor;
//#endif 


//#if 894251182 
import java.lang.reflect.InvocationTargetException;
//#endif 


//#if -1661452832 
import java.util.ArrayList;
//#endif 


//#if -31237911 
import java.util.HashMap;
//#endif 


//#if -2107931358 
import java.util.LinkedHashMap;
//#endif 


//#if -1638019967 
import java.util.List;
//#endif 


//#if 1748297915 
import java.util.Map;
//#endif 


//#if -107966639 
import java.util.StringTokenizer;
//#endif 


//#if -313482609 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1986977497 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if -1024046413 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1623221898 
import org.argouml.uml.diagram.ExtensionsCompartmentContainer;
//#endif 


//#if 337465778 
import org.argouml.uml.diagram.OperationsCompartmentContainer;
//#endif 


//#if -240973011 
import org.argouml.uml.diagram.PathContainer;
//#endif 


//#if 1469428602 
import org.argouml.uml.diagram.StereotypeContainer;
//#endif 


//#if 735466330 
import org.argouml.uml.diagram.VisibilityContainer;
//#endif 


//#if 108090995 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -2138734011 
import org.argouml.uml.diagram.ui.FigEdgePort;
//#endif 


//#if 1970856449 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1455764063 
import org.tigris.gef.persistence.pgml.Container;
//#endif 


//#if -1735021107 
import org.tigris.gef.persistence.pgml.FigEdgeHandler;
//#endif 


//#if 356482801 
import org.tigris.gef.persistence.pgml.FigGroupHandler;
//#endif 


//#if -88180232 
import org.tigris.gef.persistence.pgml.HandlerStack;
//#endif 


//#if -339369273 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2010437258 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -2030511440 
import org.tigris.gef.presentation.FigGroup;
//#endif 


//#if 2019073765 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1163772253 
import org.xml.sax.Attributes;
//#endif 


//#if 1634693749 
import org.xml.sax.SAXException;
//#endif 


//#if -990684024 
import org.xml.sax.helpers.DefaultHandler;
//#endif 


//#if 972426589 
import org.apache.log4j.Logger;
//#endif 


//#if -871859632 
class PGMLStackParser extends 
//#if -19130774 
org.tigris.gef.persistence.pgml.PGMLStackParser
//#endif 

  { 

//#if 124458550 
private List<EdgeData> figEdges = new ArrayList<EdgeData>(50);
//#endif 


//#if -629820259 
private LinkedHashMap<FigEdge, Object> modelElementsByFigEdge =
        new LinkedHashMap<FigEdge, Object>(50);
//#endif 


//#if 314071862 
private DiagramSettings diagramSettings;
//#endif 


//#if 1343639705 
private static final Logger LOG = Logger.getLogger(PGMLStackParser.class);
//#endif 


//#if 308265052 
public ArgoDiagram readArgoDiagram(InputStream is, boolean closeStream)
    throws SAXException
    { 

//#if 176047655 
return (ArgoDiagram) readDiagram(is, closeStream);
//#endif 

} 

//#endif 


//#if -1913645616 
public DiagramSettings getDiagramSettings()
    { 

//#if -1226153837 
return diagramSettings;
//#endif 

} 

//#endif 


//#if 88879445 
private FigNode getFigNode(String figId) throws IllegalStateException
    { 

//#if 1326934169 
if(figId.contains("."))//1
{ 

//#if -375764134 
figId = figId.substring(0, figId.indexOf('.'));
//#endif 


//#if -555555724 
FigEdgeModelElement edge = (FigEdgeModelElement) findFig(figId);
//#endif 


//#if -223629946 
if(edge == null)//1
{ 

//#if -1148539502 
throw new IllegalStateException(
                    "Can't find a FigNode with id " + figId);
//#endif 

} 

//#endif 


//#if -1095823890 
edge.makeEdgePort();
//#endif 


//#if -1538689770 
return edge.getEdgePort();
//#endif 

} 
else
{ 

//#if -1109193027 
Fig f = findFig(figId);
//#endif 


//#if -588140125 
if(f instanceof FigNode)//1
{ 

//#if -1169820636 
return (FigNode) f;
//#endif 

} 
else
{ 

//#if 1105144635 
LOG.error("FigID " + figId + " is not a node, edge ignored");
//#endif 


//#if -1630426764 
return null;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -729677740 
private void setStyleAttributes(Fig fig, Map<String, String> attributeMap)
    { 

//#if 360702437 
for (Map.Entry<String, String> entry : attributeMap.entrySet()) //1
{ 

//#if -1180380552 
final String name = entry.getKey();
//#endif 


//#if 1417388034 
final String value = entry.getValue();
//#endif 


//#if 594545638 
if("operationsVisible".equals(name))//1
{ 

//#if -1666897263 
((OperationsCompartmentContainer) fig)
                .setOperationsVisible(value.equalsIgnoreCase("true"));
//#endif 

} 
else

//#if 1009056824 
if("attributesVisible".equals(name))//1
{ 

//#if 162457831 
((AttributesCompartmentContainer) fig)
                .setAttributesVisible(value.equalsIgnoreCase("true"));
//#endif 

} 
else

//#if -1016677695 
if("stereotypeVisible".equals(name))//1
{ 

//#if 1397675709 
((StereotypeContainer) fig)
                .setStereotypeVisible(value.equalsIgnoreCase("true"));
//#endif 

} 
else

//#if -821062683 
if("visibilityVisible".equals(name))//1
{ 

//#if -1868749463 
((VisibilityContainer) fig)
                .setVisibilityVisible(value.equalsIgnoreCase("true"));
//#endif 

} 
else

//#if -79624080 
if("pathVisible".equals(name))//1
{ 

//#if 73003213 
((PathContainer) fig)
                .setPathVisible(value.equalsIgnoreCase("true"));
//#endif 

} 
else

//#if -658663372 
if("extensionPointVisible".equals(name))//1
{ 

//#if -1702387235 
((ExtensionsCompartmentContainer) fig)
                .setExtensionPointVisible(value.equalsIgnoreCase("true"));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 28591903 
public PGMLStackParser(Map<String, Object> modelElementsByUuid,
                           DiagramSettings defaultSettings)
    { 

//#if 264664860 
super(modelElementsByUuid);
//#endif 


//#if -340317326 
addTranslations();
//#endif 


//#if -2094054874 
diagramSettings = new DiagramSettings(defaultSettings);
//#endif 

} 

//#endif 


//#if -439039381 
private void addTranslations()
    { 

//#if -1764331585 
addTranslation("org.argouml.uml.diagram.ui.FigNote",
                       "org.argouml.uml.diagram.static_structure.ui.FigComment");
//#endif 


//#if -1489566201 
addTranslation("org.argouml.uml.diagram.static_structure.ui.FigNote",
                       "org.argouml.uml.diagram.static_structure.ui.FigComment");
//#endif 


//#if -1073531458 
addTranslation("org.argouml.uml.diagram.state.ui.FigState",
                       "org.argouml.uml.diagram.state.ui.FigSimpleState");
//#endif 


//#if 1035384438 
addTranslation("org.argouml.uml.diagram.ui.FigCommentPort",
                       "org.argouml.uml.diagram.ui.FigEdgePort");
//#endif 


//#if -657873511 
addTranslation("org.tigris.gef.presentation.FigText",
                       "org.argouml.uml.diagram.ui.ArgoFigText");
//#endif 


//#if -586060855 
addTranslation("org.tigris.gef.presentation.FigLine",
                       "org.argouml.gefext.ArgoFigLine");
//#endif 


//#if -1815531319 
addTranslation("org.tigris.gef.presentation.FigPoly",
                       "org.argouml.gefext.ArgoFigPoly");
//#endif 


//#if -1428204791 
addTranslation("org.tigris.gef.presentation.FigCircle",
                       "org.argouml.gefext.ArgoFigCircle");
//#endif 


//#if -234377783 
addTranslation("org.tigris.gef.presentation.FigRect",
                       "org.argouml.gefext.ArgoFigRect");
//#endif 


//#if -72802285 
addTranslation("org.tigris.gef.presentation.FigRRect",
                       "org.argouml.gefext.ArgoFigRRect");
//#endif 


//#if 1395187905 
addTranslation(
            "org.argouml.uml.diagram.deployment.ui.FigMNodeInstance",
            "org.argouml.uml.diagram.deployment.ui.FigNodeInstance");
//#endif 


//#if -835449368 
addTranslation("org.argouml.uml.diagram.ui.FigRealization",
                       "org.argouml.uml.diagram.ui.FigAbstraction");
//#endif 

} 

//#endif 


//#if -88237676 
@Override
    public DefaultHandler getHandler(HandlerStack stack,
                                     Object container,
                                     String uri,
                                     String localname,
                                     String qname,
                                     Attributes attributes)
    throws SAXException
    { 

//#if 1499079213 
String href = attributes.getValue("href");
//#endif 


//#if 1086014938 
Object owner = null;
//#endif 


//#if -514732720 
if(href != null)//1
{ 

//#if -1030299929 
owner = findOwner(href);
//#endif 


//#if 644857353 
if(owner == null)//1
{ 

//#if 1089616095 
LOG.warn("Found href of "
                         + href
                         + " with no matching element in model");
//#endif 


//#if -1759138840 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 438135908 
if(container instanceof FigGroupHandler)//1
{ 

//#if -232854873 
FigGroup group = ((FigGroupHandler) container).getFigGroup();
//#endif 


//#if 1152088311 
if(group instanceof FigNode && !qname.equals("private"))//1
{ 

//#if -794044078 
return null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1437482854 
if(qname.equals("private") && (container instanceof Container))//1
{ 

//#if -2130661524 
return new PrivateHandler(this, (Container) container);
//#endif 

} 

//#endif 


//#if -1072743918 
DefaultHandler handler =
            super.getHandler(stack, container, uri, localname, qname,
                             attributes);
//#endif 


//#if -365738003 
if(handler instanceof FigEdgeHandler)//1
{ 

//#if 267632454 
return new org.argouml.persistence.FigEdgeHandler(
                       this, ((FigEdgeHandler) handler).getFigEdge());
//#endif 

} 

//#endif 


//#if -1686370030 
return handler;
//#endif 

} 

//#endif 


//#if -1302996433 
private Map<String, String> interpretStyle(StringTokenizer st)
    { 

//#if -927577715 
Map<String, String> map = new HashMap<String, String>();
//#endif 


//#if 2015245023 
String name;
//#endif 


//#if -1722893573 
String value;
//#endif 


//#if 750669209 
while (st.hasMoreElements()) //1
{ 

//#if -1935092758 
String namevaluepair = st.nextToken();
//#endif 


//#if -413256696 
int equalsPos = namevaluepair.indexOf('=');
//#endif 


//#if -118115089 
if(equalsPos < 0)//1
{ 

//#if 388203366 
name = namevaluepair;
//#endif 


//#if 1288622742 
value = "true";
//#endif 

} 
else
{ 

//#if 1017527916 
name = namevaluepair.substring(0, equalsPos);
//#endif 


//#if 237564100 
value = namevaluepair.substring(equalsPos + 1);
//#endif 

} 

//#endif 


//#if -1132292234 
map.put(name, value);
//#endif 

} 

//#endif 


//#if -1234973137 
return map;
//#endif 

} 

//#endif 


//#if -639051218 
public void addFigEdge(
        final FigEdge figEdge,
        final String sourcePortFigId,
        final String destPortFigId,
        final String sourceFigNodeId,
        final String destFigNodeId)
    { 

//#if -257877440 
figEdges.add(new EdgeData(figEdge, sourcePortFigId, destPortFigId,
                                  sourceFigNodeId, destFigNodeId));
//#endif 

} 

//#endif 


//#if 1081358390 
@Override
    protected Fig constructFig(String className, String href, Rectangle bounds)
    throws SAXException
    { 

//#if 888250940 
Fig f = null;
//#endif 


//#if 44525945 
try //1
{ 

//#if -1694394042 
Class figClass = Class.forName(className);
//#endif 


//#if -1139604219 
for (Constructor constructor : figClass.getConstructors()) //1
{ 

//#if 1429034270 
Class[] parameterTypes = constructor.getParameterTypes();
//#endif 


//#if -113634428 
if(parameterTypes.length == 3
                        && parameterTypes[0].equals(Object.class)
                        && parameterTypes[1].equals(Rectangle.class)
                        && parameterTypes[2].equals(DiagramSettings.class))//1
{ 

//#if -1269469911 
Object parameters[] = new Object[3];
//#endif 


//#if 1086627397 
Object owner = null;
//#endif 


//#if -514120261 
if(href != null)//1
{ 

//#if -1889954075 
owner = findOwner(href);
//#endif 

} 

//#endif 


//#if -1753962579 
parameters[0] = owner;
//#endif 


//#if -1904703968 
parameters[1] = bounds;
//#endif 


//#if -629855743 
parameters[2] =
                        ((ArgoDiagram) getDiagram()).getDiagramSettings();
//#endif 


//#if 1899894867 
f =  (Fig) constructor.newInstance(parameters);
//#endif 

} 

//#endif 


//#if 1403901024 
if(parameterTypes.length == 2
                        && parameterTypes[0].equals(Object.class)
                        && parameterTypes[1].equals(DiagramSettings.class))//1
{ 

//#if -1381599183 
Object parameters[] = new Object[2];
//#endif 


//#if -276105572 
Object owner = null;
//#endif 


//#if -1876853230 
if(href != null)//1
{ 

//#if 309558716 
owner = findOwner(href);
//#endif 

} 

//#endif 


//#if 1394007030 
parameters[0] = owner;
//#endif 


//#if 1519118265 
parameters[1] =
                        ((ArgoDiagram) getDiagram()).getDiagramSettings();
//#endif 


//#if -321707542 
f =  (Fig) constructor.newInstance(parameters);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if -1196296490 
catch (ClassNotFoundException e) //1
{ 

//#if 826863410 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#if -474736631 
catch (IllegalAccessException e) //1
{ 

//#if -2091835121 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#if 1676964764 
catch (InstantiationException e) //1
{ 

//#if 1321871244 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#if 79870734 
catch (InvocationTargetException e) //1
{ 

//#if -765073339 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#endif 


//#if 441214029 
if(f == null)//1
{ 

//#if 882945976 
LOG.debug("No ArgoUML constructor found for " + className
                      + " falling back to GEF's default constructors");
//#endif 


//#if -1249388838 
f = super.constructFig(className, href, bounds);
//#endif 

} 

//#endif 


//#if 1920019400 
return f;
//#endif 

} 

//#endif 


//#if 602572169 
@Override
    protected final void setAttrs(Fig f, Attributes attrList)
    throws SAXException
    { 

//#if -1175766368 
if(f instanceof FigGroup)//1
{ 

//#if 870187901 
FigGroup group = (FigGroup) f;
//#endif 


//#if -975342561 
String clsNameBounds = attrList.getValue("description");
//#endif 


//#if -447808941 
if(clsNameBounds != null)//1
{ 

//#if -1317939535 
StringTokenizer st =
                    new StringTokenizer(clsNameBounds, ",;[] ");
//#endif 


//#if 277394063 
if(st.hasMoreElements())//1
{ 

//#if 1487936539 
st.nextToken();
//#endif 

} 

//#endif 


//#if 329529794 
if(st.hasMoreElements())//2
{ 

//#if 400784197 
st.nextToken();
//#endif 

} 

//#endif 


//#if 329559586 
if(st.hasMoreElements())//3
{ 

//#if -2076169071 
st.nextToken();
//#endif 

} 

//#endif 


//#if 329589378 
if(st.hasMoreElements())//4
{ 

//#if -856277461 
st.nextToken();
//#endif 

} 

//#endif 


//#if 329619170 
if(st.hasMoreElements())//5
{ 

//#if -1790678083 
st.nextToken();
//#endif 

} 

//#endif 


//#if -244169974 
Map<String, String> attributeMap = interpretStyle(st);
//#endif 


//#if 1685838051 
setStyleAttributes(group, attributeMap);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 431898560 
String name = attrList.getValue("name");
//#endif 


//#if -138503507 
if(name != null && !name.equals(""))//1
{ 

//#if 69113893 
registerFig(f, name);
//#endif 

} 

//#endif 


//#if -1237182364 
setCommonAttrs(f, attrList);
//#endif 


//#if -1631197258 
final String href = attrList.getValue("href");
//#endif 


//#if -437152083 
if(href != null && !href.equals(""))//1
{ 

//#if 1871882616 
Object modelElement = findOwner(href);
//#endif 


//#if -327449265 
if(modelElement == null)//1
{ 

//#if -1904844185 
LOG.error("Can't find href of " + href);
//#endif 


//#if -534059821 
throw new SAXException("Found href of " + href
                                       + " with no matching element in model");
//#endif 

} 

//#endif 


//#if 1323093226 
if(f.getOwner() != modelElement)//1
{ 

//#if -1367433892 
if(f instanceof FigEdge)//1
{ 

//#if -1685642822 
modelElementsByFigEdge.put((FigEdge) f, modelElement);
//#endif 

} 
else
{ 

//#if -1916630159 
f.setOwner(modelElement);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1810273113 
LOG.debug("Ignoring href on " + f.getClass().getName()
                          + " as it's already set");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -466385026 
@Deprecated
    public PGMLStackParser(Map modelElementsByUuid)
    { 

//#if -1402222800 
super(modelElementsByUuid);
//#endif 


//#if 127382750 
addTranslations();
//#endif 

} 

//#endif 


//#if -312779331 
@Override
    public void setDiagram(Diagram diagram)
    { 

//#if 1346366188 
((ArgoDiagram) diagram).setDiagramSettings(getDiagramSettings());
//#endif 


//#if -1682542097 
super.setDiagram(diagram);
//#endif 

} 

//#endif 


//#if -837017044 
@Override
    public Diagram readDiagram(InputStream is, boolean closeStream)
    throws SAXException
    { 

//#if -35382192 
Diagram d = super.readDiagram(is, closeStream);
//#endif 


//#if 2088672061 
attachEdges(d);
//#endif 


//#if -163957239 
return d;
//#endif 

} 

//#endif 


//#if -996020632 
private void attachEdges(Diagram d)
    { 

//#if -702689919 
for (EdgeData edgeData : figEdges) //1
{ 

//#if 960047634 
final FigEdge edge = edgeData.getFigEdge();
//#endif 


//#if -1210917819 
Object modelElement = modelElementsByFigEdge.get(edge);
//#endif 


//#if -1903096834 
if(modelElement != null)//1
{ 

//#if 2132935530 
if(edge.getOwner() == null)//1
{ 

//#if -199138905 
edge.setOwner(modelElement);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -164699760 
for (EdgeData edgeData : figEdges) //2
{ 

//#if 382851945 
final FigEdge edge = edgeData.getFigEdge();
//#endif 


//#if -1668685659 
Fig sourcePortFig = findFig(edgeData.getSourcePortFigId());
//#endif 


//#if 199819799 
Fig destPortFig = findFig(edgeData.getDestPortFigId());
//#endif 


//#if 575246248 
final FigNode sourceFigNode =
                getFigNode(edgeData.getSourceFigNodeId());
//#endif 


//#if -1163568696 
final FigNode destFigNode =
                getFigNode(edgeData.getDestFigNodeId());
//#endif 


//#if -923204470 
if(sourceFigNode instanceof FigEdgePort)//1
{ 

//#if -765085381 
sourcePortFig = sourceFigNode;
//#endif 

} 

//#endif 


//#if -2044505903 
if(destFigNode instanceof FigEdgePort)//1
{ 

//#if -1543406207 
destPortFig = destFigNode;
//#endif 

} 

//#endif 


//#if -1004059618 
if(sourcePortFig == null && sourceFigNode != null)//1
{ 

//#if 1721068804 
sourcePortFig = getPortFig(sourceFigNode);
//#endif 

} 

//#endif 


//#if -114458818 
if(destPortFig == null && destFigNode != null)//1
{ 

//#if 859538836 
destPortFig = getPortFig(destFigNode);
//#endif 

} 

//#endif 


//#if 116149649 
if(sourcePortFig == null
                    || destPortFig == null
                    || sourceFigNode == null
                    || destFigNode == null)//1
{ 

//#if 1082612876 
LOG.error("Can't find nodes for FigEdge: "
                          + edge.getId() + ":"
                          + edge.toString());
//#endif 


//#if -1157632777 
edge.removeFromDiagram();
//#endif 

} 
else
{ 

//#if 967403266 
edge.setSourcePortFig(sourcePortFig);
//#endif 


//#if 1652023348 
edge.setDestPortFig(destPortFig);
//#endif 


//#if -106263288 
edge.setSourceFigNode(sourceFigNode);
//#endif 


//#if -2081602822 
edge.setDestFigNode(destFigNode);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1062419914 
for (Object edge : d.getLayer().getContentsEdgesOnly()) //1
{ 

//#if 958357588 
FigEdge figEdge = (FigEdge) edge;
//#endif 


//#if -1331227228 
figEdge.computeRouteImpl();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1436276435 
private Fig getPortFig(FigNode figNode)
    { 

//#if -920384558 
if(figNode instanceof FigEdgePort)//1
{ 

//#if 230756930 
return figNode;
//#endif 

} 
else
{ 

//#if 771426630 
return (Fig) figNode.getPortFigs().get(0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1278426554 
private class EdgeData  { 

//#if 1054949866 
private final FigEdge figEdge;
//#endif 


//#if -288384294 
private final String sourcePortFigId;
//#endif 


//#if 647935265 
private final String destPortFigId;
//#endif 


//#if -550752361 
private final String sourceFigNodeId;
//#endif 


//#if 385567198 
private final String destFigNodeId;
//#endif 


//#if 1725661815 
public EdgeData(FigEdge edge, String sourcePortId,
                        String destPortId, String sourceNodeId, String destNodeId)
        { 

//#if 528059305 
if(sourcePortId == null || destPortId == null)//1
{ 

//#if 454404877 
throw new IllegalArgumentException(
                    "source port and dest port must not be null"
                    + " source = " + sourcePortId
                    + " dest = " + destPortId
                    + " figEdge = " + edge);
//#endif 

} 

//#endif 


//#if -1589942465 
this.figEdge = edge;
//#endif 


//#if -1684363321 
this.sourcePortFigId = sourcePortId;
//#endif 


//#if -1485869255 
this.destPortFigId = destPortId;
//#endif 


//#if 572664588 
this.sourceFigNodeId =
                sourceNodeId != null ? sourceNodeId : sourcePortId;
//#endif 


//#if -1362083042 
this.destFigNodeId =
                destNodeId != null ? destNodeId : destPortId;
//#endif 

} 

//#endif 


//#if 789723270 
public FigEdge getFigEdge()
        { 

//#if -787422642 
return figEdge;
//#endif 

} 

//#endif 


//#if 499363849 
public String getSourceFigNodeId()
        { 

//#if -1941348297 
return sourceFigNodeId;
//#endif 

} 

//#endif 


//#if -426883166 
public String getDestFigNodeId()
        { 

//#if 1735543257 
return destFigNodeId;
//#endif 

} 

//#endif 


//#if 42839334 
public String getSourcePortFigId()
        { 

//#if 1439763959 
return sourcePortFigId;
//#endif 

} 

//#endif 


//#if -883407681 
public String getDestPortFigId()
        { 

//#if -1512670623 
return destPortFigId;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

