package org.argouml.persistence;
import java.awt.Rectangle;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.AttributesCompartmentContainer;
import org.argouml.uml.diagram.DiagramSettings;
import org.argouml.uml.diagram.ExtensionsCompartmentContainer;
import org.argouml.uml.diagram.OperationsCompartmentContainer;
import org.argouml.uml.diagram.PathContainer;
import org.argouml.uml.diagram.StereotypeContainer;
import org.argouml.uml.diagram.VisibilityContainer;
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
import org.argouml.uml.diagram.ui.FigEdgePort;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.persistence.pgml.Container;
import org.tigris.gef.persistence.pgml.FigEdgeHandler;
import org.tigris.gef.persistence.pgml.FigGroupHandler;
import org.tigris.gef.persistence.pgml.HandlerStack;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigEdge;
import org.tigris.gef.presentation.FigGroup;
import org.tigris.gef.presentation.FigNode;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
class PGMLStackParser extends org.tigris.gef.persistence.pgml.PGMLStackParser
  { 
private List<EdgeData> figEdges = new ArrayList<EdgeData>(50);
private LinkedHashMap<FigEdge, Object> modelElementsByFigEdge =
        new LinkedHashMap<FigEdge, Object>(50);
private DiagramSettings diagramSettings;
public ArgoDiagram readArgoDiagram(InputStream is, boolean closeStream)
    throws SAXException
    { 
return (ArgoDiagram) readDiagram(is, closeStream);
} 
public DiagramSettings getDiagramSettings()
    { 
return diagramSettings;
} 
private FigNode getFigNode(String figId) throws IllegalStateException
    { 
if(figId.contains("."))//1
{ 
figId = figId.substring(0, figId.indexOf('.'));
FigEdgeModelElement edge = (FigEdgeModelElement) findFig(figId);
if(edge == null)//1
{ 
throw new IllegalStateException(
                    "Can't find a FigNode with id " + figId);
} 
edge.makeEdgePort();
return edge.getEdgePort();
} 
else
{ 
Fig f = findFig(figId);
if(f instanceof FigNode)//1
{ 
return (FigNode) f;
} 
else
{ 
return null;
} 
} 
} 
private void setStyleAttributes(Fig fig, Map<String, String> attributeMap)
    { 
for (Map.Entry<String, String> entry : attributeMap.entrySet()) //1
{ 
final String name = entry.getKey();
final String value = entry.getValue();
if("operationsVisible".equals(name))//1
{ 
((OperationsCompartmentContainer) fig)
                .setOperationsVisible(value.equalsIgnoreCase("true"));
} 
else
if("attributesVisible".equals(name))//1
{ 
((AttributesCompartmentContainer) fig)
                .setAttributesVisible(value.equalsIgnoreCase("true"));
} 
else
if("stereotypeVisible".equals(name))//1
{ 
((StereotypeContainer) fig)
                .setStereotypeVisible(value.equalsIgnoreCase("true"));
} 
else
if("visibilityVisible".equals(name))//1
{ 
((VisibilityContainer) fig)
                .setVisibilityVisible(value.equalsIgnoreCase("true"));
} 
else
if("pathVisible".equals(name))//1
{ 
((PathContainer) fig)
                .setPathVisible(value.equalsIgnoreCase("true"));
} 
else
if("extensionPointVisible".equals(name))//1
{ 
((ExtensionsCompartmentContainer) fig)
                .setExtensionPointVisible(value.equalsIgnoreCase("true"));
} 
} 
} 
public PGMLStackParser(Map<String, Object> modelElementsByUuid,
                           DiagramSettings defaultSettings)
    { 
super(modelElementsByUuid);
addTranslations();
diagramSettings = new DiagramSettings(defaultSettings);
} 
private void addTranslations()
    { 
addTranslation("org.argouml.uml.diagram.ui.FigNote",
                       "org.argouml.uml.diagram.static_structure.ui.FigComment");
addTranslation("org.argouml.uml.diagram.static_structure.ui.FigNote",
                       "org.argouml.uml.diagram.static_structure.ui.FigComment");
addTranslation("org.argouml.uml.diagram.state.ui.FigState",
                       "org.argouml.uml.diagram.state.ui.FigSimpleState");
addTranslation("org.argouml.uml.diagram.ui.FigCommentPort",
                       "org.argouml.uml.diagram.ui.FigEdgePort");
addTranslation("org.tigris.gef.presentation.FigText",
                       "org.argouml.uml.diagram.ui.ArgoFigText");
addTranslation("org.tigris.gef.presentation.FigLine",
                       "org.argouml.gefext.ArgoFigLine");
addTranslation("org.tigris.gef.presentation.FigPoly",
                       "org.argouml.gefext.ArgoFigPoly");
addTranslation("org.tigris.gef.presentation.FigCircle",
                       "org.argouml.gefext.ArgoFigCircle");
addTranslation("org.tigris.gef.presentation.FigRect",
                       "org.argouml.gefext.ArgoFigRect");
addTranslation("org.tigris.gef.presentation.FigRRect",
                       "org.argouml.gefext.ArgoFigRRect");
addTranslation(
            "org.argouml.uml.diagram.deployment.ui.FigMNodeInstance",
            "org.argouml.uml.diagram.deployment.ui.FigNodeInstance");
addTranslation("org.argouml.uml.diagram.ui.FigRealization",
                       "org.argouml.uml.diagram.ui.FigAbstraction");
} 
@Override
    public DefaultHandler getHandler(HandlerStack stack,
                                     Object container,
                                     String uri,
                                     String localname,
                                     String qname,
                                     Attributes attributes)
    throws SAXException
    { 
String href = attributes.getValue("href");
Object owner = null;
if(href != null)//1
{ 
owner = findOwner(href);
if(owner == null)//1
{ 
return null;
} 
} 
if(container instanceof FigGroupHandler)//1
{ 
FigGroup group = ((FigGroupHandler) container).getFigGroup();
if(group instanceof FigNode && !qname.equals("private"))//1
{ 
return null;
} 
} 
if(qname.equals("private") && (container instanceof Container))//1
{ 
return new PrivateHandler(this, (Container) container);
} 
DefaultHandler handler =
            super.getHandler(stack, container, uri, localname, qname,
                             attributes);
if(handler instanceof FigEdgeHandler)//1
{ 
return new org.argouml.persistence.FigEdgeHandler(
                       this, ((FigEdgeHandler) handler).getFigEdge());
} 
return handler;
} 
private Map<String, String> interpretStyle(StringTokenizer st)
    { 
Map<String, String> map = new HashMap<String, String>();
String name;
String value;
while (st.hasMoreElements()) //1
{ 
String namevaluepair = st.nextToken();
int equalsPos = namevaluepair.indexOf('=');
if(equalsPos < 0)//1
{ 
name = namevaluepair;
value = "true";
} 
else
{ 
name = namevaluepair.substring(0, equalsPos);
value = namevaluepair.substring(equalsPos + 1);
} 
map.put(name, value);
} 
return map;
} 
public void addFigEdge(
        final FigEdge figEdge,
        final String sourcePortFigId,
        final String destPortFigId,
        final String sourceFigNodeId,
        final String destFigNodeId)
    { 
figEdges.add(new EdgeData(figEdge, sourcePortFigId, destPortFigId,
                                  sourceFigNodeId, destFigNodeId));
} 
@Override
    protected Fig constructFig(String className, String href, Rectangle bounds)
    throws SAXException
    { 
Fig f = null;
try//1
{ 
Class figClass = Class.forName(className);
for (Constructor constructor : figClass.getConstructors()) //1
{ 
Class[] parameterTypes = constructor.getParameterTypes();
if(parameterTypes.length == 3
                        && parameterTypes[0].equals(Object.class)
                        && parameterTypes[1].equals(Rectangle.class)
                        && parameterTypes[2].equals(DiagramSettings.class))//1
{ 
Object parameters[] = new Object[3];
Object owner = null;
if(href != null)//1
{ 
owner = findOwner(href);
} 
parameters[0] = owner;
parameters[1] = bounds;
parameters[2] =
                        ((ArgoDiagram) getDiagram()).getDiagramSettings();
f =  (Fig) constructor.newInstance(parameters);
} 
if(parameterTypes.length == 2
                        && parameterTypes[0].equals(Object.class)
                        && parameterTypes[1].equals(DiagramSettings.class))//1
{ 
Object parameters[] = new Object[2];
Object owner = null;
if(href != null)//1
{ 
owner = findOwner(href);
} 
parameters[0] = owner;
parameters[1] =
                        ((ArgoDiagram) getDiagram()).getDiagramSettings();
f =  (Fig) constructor.newInstance(parameters);
} 
} 
} 
catch (ClassNotFoundException e) //1
{ 
throw new SAXException(e);
} 
catch (IllegalAccessException e) //1
{ 
throw new SAXException(e);
} 
catch (InstantiationException e) //1
{ 
throw new SAXException(e);
} 
catch (InvocationTargetException e) //1
{ 
throw new SAXException(e);
} 
if(f == null)//1
{ 
f = super.constructFig(className, href, bounds);
} 
return f;
} 
@Override
    protected final void setAttrs(Fig f, Attributes attrList)
    throws SAXException
    { 
if(f instanceof FigGroup)//1
{ 
FigGroup group = (FigGroup) f;
String clsNameBounds = attrList.getValue("description");
if(clsNameBounds != null)//1
{ 
StringTokenizer st =
                    new StringTokenizer(clsNameBounds, ",;[] ");
if(st.hasMoreElements())//1
{ 
st.nextToken();
} 
if(st.hasMoreElements())//2
{ 
st.nextToken();
} 
if(st.hasMoreElements())//3
{ 
st.nextToken();
} 
if(st.hasMoreElements())//4
{ 
st.nextToken();
} 
if(st.hasMoreElements())//5
{ 
st.nextToken();
} 
Map<String, String> attributeMap = interpretStyle(st);
setStyleAttributes(group, attributeMap);
} 
} 
String name = attrList.getValue("name");
if(name != null && !name.equals(""))//1
{ 
registerFig(f, name);
} 
setCommonAttrs(f, attrList);
final String href = attrList.getValue("href");
if(href != null && !href.equals(""))//1
{ 
Object modelElement = findOwner(href);
if(modelElement == null)//1
{ 
throw new SAXException("Found href of " + href
                                       + " with no matching element in model");
} 
if(f.getOwner() != modelElement)//1
{ 
if(f instanceof FigEdge)//1
{ 
modelElementsByFigEdge.put((FigEdge) f, modelElement);
} 
else
{ 
f.setOwner(modelElement);
} 
} 
} 
} 
@Deprecated
    public PGMLStackParser(Map modelElementsByUuid)
    { 
super(modelElementsByUuid);
addTranslations();
} 
@Override
    public void setDiagram(Diagram diagram)
    { 
((ArgoDiagram) diagram).setDiagramSettings(getDiagramSettings());
super.setDiagram(diagram);
} 
@Override
    public Diagram readDiagram(InputStream is, boolean closeStream)
    throws SAXException
    { 
Diagram d = super.readDiagram(is, closeStream);
attachEdges(d);
return d;
} 
private void attachEdges(Diagram d)
    { 
for (EdgeData edgeData : figEdges) //1
{ 
final FigEdge edge = edgeData.getFigEdge();
Object modelElement = modelElementsByFigEdge.get(edge);
if(modelElement != null)//1
{ 
if(edge.getOwner() == null)//1
{ 
edge.setOwner(modelElement);
} 
} 
} 
for (EdgeData edgeData : figEdges) //2
{ 
final FigEdge edge = edgeData.getFigEdge();
Fig sourcePortFig = findFig(edgeData.getSourcePortFigId());
Fig destPortFig = findFig(edgeData.getDestPortFigId());
final FigNode sourceFigNode =
                getFigNode(edgeData.getSourceFigNodeId());
final FigNode destFigNode =
                getFigNode(edgeData.getDestFigNodeId());
if(sourceFigNode instanceof FigEdgePort)//1
{ 
sourcePortFig = sourceFigNode;
} 
if(destFigNode instanceof FigEdgePort)//1
{ 
destPortFig = destFigNode;
} 
if(sourcePortFig == null && sourceFigNode != null)//1
{ 
sourcePortFig = getPortFig(sourceFigNode);
} 
if(destPortFig == null && destFigNode != null)//1
{ 
destPortFig = getPortFig(destFigNode);
} 
if(sourcePortFig == null
                    || destPortFig == null
                    || sourceFigNode == null
                    || destFigNode == null)//1
{ 
edge.removeFromDiagram();
} 
else
{ 
edge.setSourcePortFig(sourcePortFig);
edge.setDestPortFig(destPortFig);
edge.setSourceFigNode(sourceFigNode);
edge.setDestFigNode(destFigNode);
} 
} 
for (Object edge : d.getLayer().getContentsEdgesOnly()) //1
{ 
FigEdge figEdge = (FigEdge) edge;
figEdge.computeRouteImpl();
} 
} 
private Fig getPortFig(FigNode figNode)
    { 
if(figNode instanceof FigEdgePort)//1
{ 
return figNode;
} 
else
{ 
return (Fig) figNode.getPortFigs().get(0);
} 
} 
private class EdgeData  { 
private final FigEdge figEdge;
private final String sourcePortFigId;
private final String destPortFigId;
private final String sourceFigNodeId;
private final String destFigNodeId;
public EdgeData(FigEdge edge, String sourcePortId,
                        String destPortId, String sourceNodeId, String destNodeId)
        { 
if(sourcePortId == null || destPortId == null)//1
{ 
throw new IllegalArgumentException(
                    "source port and dest port must not be null"
                    + " source = " + sourcePortId
                    + " dest = " + destPortId
                    + " figEdge = " + edge);
} 
this.figEdge = edge;
this.sourcePortFigId = sourcePortId;
this.destPortFigId = destPortId;
this.sourceFigNodeId =
                sourceNodeId != null ? sourceNodeId : sourcePortId;
this.destFigNodeId =
                destNodeId != null ? destNodeId : destPortId;
} 
public FigEdge getFigEdge()
        { 
return figEdge;
} 
public String getSourceFigNodeId()
        { 
return sourceFigNodeId;
} 
public String getDestFigNodeId()
        { 
return destFigNodeId;
} 
public String getSourcePortFigId()
        { 
return sourcePortFigId;
} 
public String getDestPortFigId()
        { 
return destPortFigId;
} 

 } 

 } 
