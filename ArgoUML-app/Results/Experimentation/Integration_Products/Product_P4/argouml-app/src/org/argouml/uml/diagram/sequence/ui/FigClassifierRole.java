package org.argouml.uml.diagram.sequence.ui;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
import org.argouml.uml.diagram.sequence.MessageNode;
import org.argouml.uml.diagram.sequence.ui.FigLifeLine.FigLifeLineHandler;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.Selection;
import org.tigris.gef.persistence.pgml.Container;
import org.tigris.gef.persistence.pgml.FigGroupHandler;
import org.tigris.gef.persistence.pgml.HandlerFactory;
import org.tigris.gef.persistence.pgml.HandlerStack;
import org.tigris.gef.persistence.pgml.PGMLStackParser;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class FigClassifierRole extends FigNodeModelElement
 implements MouseListener
,HandlerFactory
  { 
private static final Logger LOG =
        Logger.getLogger(FigClassifierRole.class);
public static final int ROLE_WIDTH = 20;
public static final int MARGIN = 10;
public static final int ROWDISTANCE = 2;
public static final int MIN_HEAD_HEIGHT =
        (3 * ROWHEIGHT + 3 * ROWDISTANCE + STEREOHEIGHT);
public static final int MIN_HEAD_WIDTH = 3 * MIN_HEAD_HEIGHT / 2;
private FigHead headFig;
private FigLifeLine lifeLineFig;
private List<MessageNode> linkPositions = new ArrayList<MessageNode>();
private String baseNames = "";
private String classifierRoleName = "";
private static final long serialVersionUID = 7763573563940441408L;
private void setMatchingFig(MessageNode messageNode)
    { 
if(messageNode.getFigMessagePort() == null)//1
{ 
int y = getYCoordinate(messageNode);
for (Iterator it = lifeLineFig.getFigs().iterator();
                    it.hasNext();) //1
{ 
Fig fig = (Fig) it.next();
if(fig instanceof FigMessagePort)//1
{ 
FigMessagePort messagePortFig = (FigMessagePort) fig;
if(messagePortFig.getY1() == y)//1
{ 
messageNode.setFigMessagePort(messagePortFig);
messagePortFig.setNode(messageNode);
updateNodeStates();
} 
} 
} 
} 
} 
@Override
    protected void updateNameText()
    { 
String nameText =
            (classifierRoleName + ":" + baseNames).trim();
getNameFig().setText(nameText);
calcBounds();
damage();
} 
public FigClassifierRole(Object node, int x, int y, int w, int h)
    { 
this();
setBounds(x, y, w, h);
setOwner(node);
} 
private void setPreviousState(int start, int newState)
    { 
for (int i = start - 1; i >= 0; --i) //1
{ 
MessageNode node = linkPositions.get(i);
if(node.getFigMessagePort() != null)//1
{ 
break;

} 
node.setState(newState);
} 
} 
public static boolean isCallMessage(Object message)
    { 
return Model.getFacade()
               .isACallAction(Model.getFacade().getAction(message));
} 
void addFigMessagePort(FigMessagePort messagePortFig)
    { 
lifeLineFig.addFig(messagePortFig);
} 
@Override
    public Color getLineColor()
    { 
return headFig.getLineColor();
} 
@Override
    public Object deepHitPort(int x, int y)
    { 
Rectangle rect = new Rectangle(getX(), y - 16, getWidth(), 32);
MessageNode foundNode = null;
if(lifeLineFig.intersects(rect))//1
{ 
for (int i = 0; i < linkPositions.size(); i++) //1
{ 
MessageNode node = linkPositions.get(i);
int position = lifeLineFig.getYCoordinate(i);
if(i < linkPositions.size() - 1)//1
{ 
int nextPosition =
                        lifeLineFig.getYCoordinate(i + 1);
if(nextPosition >= y && position <= y)//1
{ 
if((y - position) <= (nextPosition - y))//1
{ 
foundNode = node;
} 
else
{ 
foundNode = linkPositions.get(i + 1);
} 
break;

} 
} 
else
{ 
foundNode =
                        linkPositions.get(linkPositions.size() - 1);
MessageNode nextNode;
nextNode = new MessageNode(this);
linkPositions.add(nextNode);
int nextPosition = lifeLineFig.getYCoordinate(i + 1);
if((y - position) >= (nextPosition - y))//1
{ 
foundNode = nextNode;
} 
break;

} 
} 
} 
else
if(headFig.intersects(rect))//1
{ 
foundNode = getClassifierRoleNode();
} 
else
{ 
return null;
} 
setMatchingFig(foundNode);
return foundNode;
} 
public int getNodeCount()
    { 
return linkPositions.size();
} 
public static boolean isDestroyMessage(Object message)
    { 
return Model.getFacade()
               .isADestroyAction(Model.getFacade().getAction(message));
} 
void contractNodes(int start, boolean[] emptyNodes)
    { 
int contracted = 0;
for (int i = 0; i < emptyNodes.length; ++i) //1
{ 
if(emptyNodes[i])//1
{ 
if(linkPositions.get(i + start - contracted)
                        .getFigMessagePort()
                        != null)//1
{ 
throw new IllegalArgumentException(
                        "Trying to contract non-empty MessageNode");
} 
linkPositions.remove(i + start - contracted);
++contracted;
} 
} 
if(contracted > 0)//1
{ 
updateNodeStates();
Rectangle r = getBounds();
r.height -= contracted * SequenceDiagramLayer.LINK_DISTANCE;
updateEdges();
setBounds(r);
} 
} 
Fig createFigMessagePort(Object message, TempFig tempFig)
    { 
Fig fmp = lifeLineFig.createFigMessagePort(message, tempFig);
updateNodeStates();
return fmp;
} 
@Override
    public void superTranslate(int dx, int dy)
    { 
setBounds(getX() + dx, getY(), getWidth(), getHeight());
} 
public void setLineWidth(int w)
    { 
if(headFig.getLineWidth() != w && w != 0)//1
{ 
headFig.setLineWidth(w);
lifeLineFig.setLineWidth(w);
damage();
} 
} 
private FigClassifierRole()
    { 
super();
headFig = new FigHead(getStereotypeFig(), getNameFig());
getStereotypeFig().setBounds(MIN_HEAD_WIDTH / 2,
                                     ROWHEIGHT + ROWDISTANCE,
                                     0,
                                     0);
getStereotypeFig().setFilled(false);
getStereotypeFig().setLineWidth(0);
getNameFig().setEditable(false);
getNameFig().setFilled(false);
getNameFig().setLineWidth(0);
lifeLineFig =
            new FigLifeLine(MIN_HEAD_WIDTH / 2 - ROLE_WIDTH / 2, MIN_HEAD_HEIGHT);
linkPositions.add(new MessageNode(this));
for (int i = 0;
                i <= lifeLineFig.getHeight()
                / SequenceDiagramLayer.LINK_DISTANCE;
                i++) //1
{ 
linkPositions.add(new MessageNode(this));
} 
addFig(lifeLineFig);
addFig(headFig);
} 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
Set<Object[]> l = new HashSet<Object[]>();
if(newOwner != null)//1
{ 
l.add(new Object[] {newOwner, null});
Iterator it = Model.getFacade().getBases(newOwner).iterator();
while (it.hasNext()) //1
{ 
Object base = it.next();
l.add(new Object[] {base, "name"});
} 
it = Model.getFacade().getStereotypes(newOwner).iterator();
while (it.hasNext()) //2
{ 
Object stereo = it.next();
l.add(new Object[] {stereo, "name"});
} 
} 
updateElementListeners(l);
} 
private int setFromActionNode(int lastState, int offset)
    { 
if(lastState == MessageNode.INITIAL)//1
{ 
lastState = MessageNode.DONE_SOMETHING_NO_CALL;
setPreviousState(offset, lastState);
} 
else
if(lastState == MessageNode.IMPLICIT_RETURNED)//1
{ 
lastState = MessageNode.CALLED;
setPreviousState(offset, lastState);
} 
else
if(lastState == MessageNode.IMPLICIT_CREATED)//1
{ 
lastState = MessageNode.CREATED;
setPreviousState(offset, lastState);
} 
return lastState;
} 
void removeFigMessagePort(FigMessagePort fmp)
    { 
fmp.getNode().setFigMessagePort(null);
fmp.setNode(null);
lifeLineFig.removeFig(fmp);
} 
public static boolean isCreateMessage(Object message)
    { 
return Model.getFacade()
               .isACreateAction(Model.getFacade().getAction(message));
} 
@Override
    public void mouseReleased(MouseEvent me)
    { 
super.mouseReleased(me);
Layer lay = Globals.curEditor().getLayerManager().getActiveLayer();
if(lay instanceof SequenceDiagramLayer)//1
{ 
((SequenceDiagramLayer) lay).putInPosition(this);
} 
} 
@Override
    public int getLineWidth()
    { 
return headFig.getLineWidth();
} 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 
if(mee.getPropertyName().equals("name"))//1
{ 
if(mee.getSource() == getOwner())//1
{ 
updateClassifierRoleName();
} 
else
if(Model.getFacade().isAStereotype(mee.getSource()))//1
{ 
updateStereotypeText();
} 
else
{ 
updateBaseNames();
} 
renderingChanged();
} 
else
if(mee.getPropertyName().equals("stereotype"))//1
{ 
updateStereotypeText();
updateListeners(getOwner(), getOwner());
renderingChanged();
} 
else
if(mee.getPropertyName().equals("base"))//1
{ 
updateBaseNames();
updateListeners(getOwner(), getOwner());
renderingChanged();
} 
} 
@Override
    protected void updateBounds()
    { 
Rectangle bounds = getBounds();
bounds.width =
            Math.max(
                getNameFig().getWidth() + 2 * MARGIN,
                getStereotypeFig().getWidth() + 2 * MARGIN);
setBounds(bounds);
} 
public FigClassifierRole(Object node)
    { 
this();
setOwner(node);
} 
@Override
    public boolean isFilled()
    { 
return headFig.isFilled();
} 
private String getBeautifiedName(Object o)
    { 
String name = Model.getFacade().getName(o);
if(name == null || name.equals(""))//1
{ 
name = "(anon " + Model.getFacade().getUMLClassName(o) + ")";
} 
return name;
} 
public MessageNode previousNode(MessageNode node)
    { 
if(getIndexOf(node) > 0)//1
{ 
return linkPositions.get(getIndexOf(node) - 1);
} 
return null;
} 
@Override
    public Selection makeSelection()
    { 
return new SelectionClassifierRole(this);
} 
public DefaultHandler getHandler(HandlerStack stack,
                                     Object container,
                                     String uri,
                                     String localname,
                                     String qname,
                                     Attributes attributes)
    throws SAXException
    { 
PGMLStackParser parser = (PGMLStackParser) stack;
StringTokenizer st =
            new StringTokenizer(attributes.getValue("description"), ",;[] ");
if(st.hasMoreElements())//1
{ 
st.nextToken();
} 
String xStr = null;
String yStr = null;
String wStr = null;
String hStr = null;
if(st.hasMoreElements())//2
{ 
xStr = st.nextToken();
yStr = st.nextToken();
wStr = st.nextToken();
hStr = st.nextToken();
} 
if(xStr != null && !xStr.equals(""))//1
{ 
int x = Integer.parseInt(xStr);
int y = Integer.parseInt(yStr);
int w = Integer.parseInt(wStr);
int h = Integer.parseInt(hStr);
setBounds(x, y, w, h);
} 
PGMLStackParser.setCommonAttrs(this, attributes);
parser.registerFig(this, attributes.getValue("name"));
((Container) container).addObject(this);
return new FigClassifierRoleHandler(parser, this);
} 
FigHead getHeadFig()
    { 
return headFig;
} 
void updateNodeStates()
    { 
int lastState = MessageNode.INITIAL;
ArrayList callers = null;
int nodeCount = linkPositions.size();
for (int i = 0; i < nodeCount; ++i) //1
{ 
MessageNode node = linkPositions.get(i);
FigMessagePort figMessagePort = node.getFigMessagePort();
if(figMessagePort != null)//1
{ 
int fmpY = lifeLineFig.getYCoordinate(i);
if(figMessagePort.getY() != fmpY)//1
{ 
figMessagePort.setBounds(lifeLineFig.getX(),
                                             fmpY, ROLE_WIDTH, 1);
} 
Object message = figMessagePort.getOwner();
boolean selfMessage =
                    (Model.getFacade().isAMessage(message)
                     && (Model.getFacade().getSender(message)
                         == Model.getFacade().getReceiver(message)));
boolean selfReceiving = false;
if(selfMessage)//1
{ 
for (int j = i - 1; j >= 0; --j) //1
{ 
MessageNode prev = linkPositions.get(j);
FigMessagePort prevmp = prev.getFigMessagePort();
if(prevmp != null && prevmp.getOwner() == message)//1
{ 
selfReceiving = true;
} 
} 
} 
if(isCallMessage(message))//1
{ 
if(Model.getFacade().getSender(message) == getOwner()
                            && !selfReceiving)//1
{ 
lastState = setFromActionNode(lastState, i);
node.setState(lastState);
node.setCallers(callers);
} 
else
{ 
if(lastState == MessageNode.INITIAL
                                || lastState == MessageNode.CREATED
                                || lastState == MessageNode.IMPLICIT_CREATED
                                || lastState == MessageNode.IMPLICIT_RETURNED
                                || lastState == MessageNode.RETURNED)//1
{ 
lastState = MessageNode.CALLED;
} 
if(callers == null)//1
{ 
callers = new ArrayList();
} 
else
{ 
callers = new ArrayList(callers);
} 
callers.add(Model.getFacade().getSender(message));
node.setState(lastState);
node.setCallers(callers);
} 
} 
else
if(isReturnMessage(message))//1
{ 
if(lastState == MessageNode.IMPLICIT_RETURNED)//1
{ 
setPreviousState(i, MessageNode.CALLED);
lastState = MessageNode.CALLED;
} 
if(Model.getFacade().getSender(message) == getOwner()
                            && !selfReceiving)//1
{ 
if(callers == null)//1
{ 
callers = new ArrayList();
} 
Object caller = Model.getFacade().getReceiver(message);
int callerIndex = callers.lastIndexOf(caller);
if(callerIndex != -1)//1
{ 
for (int backNodeIndex = i - 1;
                                    backNodeIndex > 0
                                    && linkPositions
                                    .get(backNodeIndex)
                                    .matchingCallerList(caller,
                                                        callerIndex);
                                    --backNodeIndex) //1
{ 
} 
if(callerIndex == 0)//1
{ 
callers = null;
if(lastState == MessageNode.CALLED)//1
{ 
lastState = MessageNode.RETURNED;
} 
} 
else
{ 
callers =
                                    new ArrayList(callers.subList(0,
                                                                  callerIndex));
} 
} 
} 
node.setState(lastState);
node.setCallers(callers);
} 
else
if(isCreateMessage(message))//1
{ 
if(Model.getFacade().getSender(message) == getOwner())//1
{ 
lastState = setFromActionNode(lastState, i);
node.setState(lastState);
node.setCallers(callers);
} 
else
{ 
lastState = MessageNode.CREATED;
setPreviousState(i, MessageNode.PRECREATED);
node.setState(lastState);
node.setCallers(callers);
} 
} 
else
if(isDestroyMessage(message))//1
{ 
if(Model.getFacade().getSender(message) == getOwner()
                            && !selfReceiving)//1
{ 
lastState = setFromActionNode(lastState, i);
node.setState(lastState);
node.setCallers(callers);
} 
else
{ 
lastState = MessageNode.DESTROYED;
callers = null;
node.setState(lastState);
node.setCallers(callers);
} 
} 
} 
else
{ 
if(lastState == MessageNode.CALLED)//1
{ 
lastState = MessageNode.IMPLICIT_RETURNED;
} 
if(lastState == MessageNode.CREATED)//1
{ 
lastState = MessageNode.IMPLICIT_CREATED;
} 
node.setState(lastState);
node.setCallers(callers);
} 
} 
} 
void updateEmptyNodeArray(int start, boolean[] emptyNodes)
    { 
for (int i = 0; i < emptyNodes.length; ++i) //1
{ 
if(linkPositions.get(i + start).getFigMessagePort()
                    != null)//1
{ 
emptyNodes[i] = false;
} 
} 
} 
public static boolean isReturnMessage(Object message)
    { 
return Model.getFacade()
               .isAReturnAction(Model.getFacade().getAction(message));
} 
@Override
    public void setOwner(Object own)
    { 
super.setOwner(own);
bindPort(own, headFig);
} 
void setMatchingNode(FigMessagePort fmp)
    { 
while (lifeLineFig.getYCoordinate(getNodeCount() - 1) < fmp.getY1()) //1
{ 
growToSize(getNodeCount() + 10);
} 
int i = 0;
for (Iterator it = linkPositions.iterator(); it.hasNext(); ++i) //1
{ 
MessageNode node = (MessageNode) it.next();
if(lifeLineFig.getYCoordinate(i) == fmp.getY1())//1
{ 
node.setFigMessagePort(fmp);
fmp.setNode(node);
updateNodeStates();
break;

} 
} 
} 
public MessageNode getNode(int position)
    { 
if(position < linkPositions.size())//1
{ 
return linkPositions.get(position);
} 
MessageNode node = null;
for (int cnt = position - linkPositions.size(); cnt >= 0; cnt--) //1
{ 
node = new MessageNode(this);
linkPositions.add(node);
} 
calcBounds();
return node;
} 
@Override
    protected void updateStereotypeText()
    { 
Rectangle rect = headFig.getBounds();
getStereotypeFig().setOwner(getOwner());
int minWidth = headFig.getMinimumSize().width;
if(minWidth > rect.width)//1
{ 
rect.width = minWidth;
} 
int headHeight = headFig.getMinimumSize().height;
headFig.setBounds(
            rect.x,
            rect.y,
            rect.width,
            headHeight);
if(getLayer() == null)//1
{ 
return;
} 
int h = MIN_HEAD_HEIGHT;
List figs = getLayer().getContents();
for (Iterator i = figs.iterator(); i.hasNext();) //1
{ 
Object o = i.next();
if(o instanceof FigClassifierRole)//1
{ 
FigClassifierRole other = (FigClassifierRole) o;
int otherHeight = other.headFig.getMinimumHeight();
if(otherHeight > h)//1
{ 
h = otherHeight;
} 
} 
} 
int height = headFig.getHeight() + lifeLineFig.getHeight();
setBounds(
            headFig.getX(),
            headFig.getY(),
            headFig.getWidth(),
            height);
calcBounds();
Layer layer = getLayer();
List layerFigs = layer.getContents();
for (Iterator i = layerFigs.iterator(); i.hasNext();) //1
{ 
Object o = i.next();
if(o instanceof FigClassifierRole && o != this)//1
{ 
FigClassifierRole other = (FigClassifierRole) o;
other.setHeight(height);
} 
} 
} 
private FigLifeLine getLifeLineFig()
    { 
return lifeLineFig;
} 
public MessageNode nextNode(MessageNode node)
    { 
if(getIndexOf(node) < linkPositions.size())//1
{ 
return linkPositions.get(getIndexOf(node) + 1);
} 
return null;
} 
private void addActivations()
    { 
MessageNode startActivationNode = null;
MessageNode endActivationNode = null;
int lastState = MessageNode.INITIAL;
boolean startFull = false;
boolean endFull = false;
int nodeCount = linkPositions.size();
int x = lifeLineFig.getX();
for (int i = 0; i < nodeCount; ++i) //1
{ 
MessageNode node = linkPositions.get(i);
int nextState = node.getState();
if(lastState != nextState && nextState == MessageNode.CREATED)//1
{ 
lifeLineFig.addActivationFig(
                    new FigBirthActivation(
                        lifeLineFig.getX(),
                        lifeLineFig.getYCoordinate(i)
                        - SequenceDiagramLayer.LINK_DISTANCE / 4));
} 
if(lastState != nextState
                    && nextState == MessageNode.DESTROYED)//1
{ 
int y =
                    lifeLineFig.getYCoordinate(i)
                    - SequenceDiagramLayer.LINK_DISTANCE / 2;
lifeLineFig.addActivationFig(
                    new FigLine(x,
                                y + SequenceDiagramLayer.LINK_DISTANCE / 2,
                                x + ROLE_WIDTH,
                                y + SequenceDiagramLayer.LINK_DISTANCE, LINE_COLOR)
                );
lifeLineFig.addActivationFig(
                    new FigLine(x,
                                y + SequenceDiagramLayer.LINK_DISTANCE,
                                x + ROLE_WIDTH,
                                y
                                + SequenceDiagramLayer.LINK_DISTANCE / 2, LINE_COLOR)
                );
} 
if(startActivationNode == null)//1
{ 
switch (nextState) //1
{ 
case MessageNode.DONE_SOMETHING_NO_CALL://1

startActivationNode = node;
startFull = true;
break;


case MessageNode.CALLED://1

case MessageNode.CREATED://1

startActivationNode = node;
startFull = false;
break;


default://1

} 
} 
else
{ 
switch (nextState) //1
{ 
case MessageNode.DESTROYED ://1

case MessageNode.RETURNED ://1

endActivationNode = node;
endFull = false;
break;


case MessageNode.IMPLICIT_RETURNED ://1

case MessageNode.IMPLICIT_CREATED ://1

endActivationNode = linkPositions.get(i - 1);
endFull = true;
break;


case MessageNode.CALLED ://1

if(lastState == MessageNode.CREATED)//1
{ 
endActivationNode =
                            linkPositions.get(i - 1);
endFull = false;
--i;
nextState = lastState;
} 
break;


default://1

} 
} 
lastState = nextState;
if(startActivationNode != null && endActivationNode != null)//1
{ 
if(startActivationNode != endActivationNode
                        || startFull || endFull)//1
{ 
int y1 = getYCoordinate(startActivationNode);
if(startFull)//1
{ 
y1 -= SequenceDiagramLayer.LINK_DISTANCE / 2;
} 
int y2 = getYCoordinate(endActivationNode);
if(endFull)//1
{ 
y2 += SequenceDiagramLayer.LINK_DISTANCE / 2;
} 
lifeLineFig.addActivationFig(
                        new FigActivation(x, y1, ROLE_WIDTH, y2 - y1));
} 
startActivationNode = null;
endActivationNode = null;
startFull = false;
endFull = false;
} 
} 
if(startActivationNode != null)//1
{ 
endActivationNode = linkPositions.get(nodeCount - 1);
endFull = true;
int y1 = getYCoordinate(startActivationNode);
if(startFull)//1
{ 
y1 -= SequenceDiagramLayer.LINK_DISTANCE / 2;
} 
int y2 = getYCoordinate(endActivationNode);
if(endFull)//1
{ 
y2 += SequenceDiagramLayer.LINK_DISTANCE / 2;
} 
lifeLineFig.addActivationFig(
                new FigActivation(x, y1, ROLE_WIDTH, y2 - y1));
startActivationNode = null;
endActivationNode = null;
startFull = false;
endFull = false;
} 
} 
void grow(int nodePosition, int count)
    { 
for (int i = 0; i < count; ++i) //1
{ 
linkPositions.add(nodePosition, new MessageNode(this));
} 
if(count > 0)//1
{ 
updateNodeStates();
Rectangle r = getBounds();
r.height += count * SequenceDiagramLayer.LINK_DISTANCE;
setBounds(r);
updateEdges();
} 
} 
public void addNode(int position, MessageNode node)
    { 
linkPositions.add(position, node);
Iterator it =
            linkPositions
            .subList(position + 1, linkPositions.size())
            .iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
if(o instanceof MessageNode)//1
{ 
FigMessagePort figMessagePort =
                    ((MessageNode) o).getFigMessagePort();
if(figMessagePort != null)//1
{ 
figMessagePort.setY(
                        figMessagePort.getY()
                        + SequenceDiagramLayer.LINK_DISTANCE);
} 
} 
} 
calcBounds();
} 
public int getIndexOf(MessageNode node)
    { 
return linkPositions.indexOf(node);
} 
public int getYCoordinate(MessageNode node)
    { 
return lifeLineFig.getYCoordinate(linkPositions.indexOf(node));
} 
private void updateBaseNames()
    { 
StringBuffer b = new StringBuffer();
Iterator it = Model.getFacade().getBases(getOwner()).iterator();
while (it.hasNext()) //1
{ 
b.append(getBeautifiedName(it.next()));
if(it.hasNext())//1
{ 
b.append(',');
} 
} 
baseNames = b.toString();
} 
@Override
    public void setStandardBounds(int x, int y, int w, int h)
    { 
y = 50;
Rectangle oldBounds = getBounds();
w = headFig.getMinimumSize().width;
headFig.setBounds(x, y, w, headFig.getMinimumSize().height);
lifeLineFig.setBounds(
            (x + w / 2) - ROLE_WIDTH / 2,
            y + headFig.getHeight(),
            ROLE_WIDTH,
            h - headFig.getHeight());
this.updateEdges();
growToSize(
            lifeLineFig.getHeight() / SequenceDiagramLayer.LINK_DISTANCE
            + 2);
calcBounds();
firePropChange("bounds", oldBounds, getBounds());
} 
@Override
    public Fig getPortFig(Object messageNode)
    { 
if(Model.getFacade().isAClassifierRole(messageNode))//1
{ 
LOG.debug("Got a ClassifierRole - only legal on load");
return null;
} 
if(!(messageNode instanceof MessageNode))//1
{ 
throw new IllegalArgumentException(
                "Expecting a MessageNode but got a "
                + messageNode.getClass().getName());
} 
setMatchingFig((MessageNode) messageNode);
if(((MessageNode) messageNode).getFigMessagePort() != null)//1
{ 
return ((MessageNode) messageNode).getFigMessagePort();
} 
return new TempFig(
                   messageNode, lifeLineFig.getX(),
                   getYCoordinate((MessageNode) messageNode),
                   lifeLineFig.getX() + ROLE_WIDTH);
} 
public void updateActivations()
    { 
LOG.debug("Updating activations");
lifeLineFig.removeActivations();
addActivations();
} 
private MessageNode getClassifierRoleNode()
    { 
return linkPositions.get(0);
} 
void growToSize(int nodeCount)
    { 
grow(linkPositions.size(), nodeCount - linkPositions.size());
} 
@Override
    public void setFilled(boolean filled)
    { 
if(headFig.isFilled() != filled)//1
{ 
headFig.setFilled(filled);
damage();
} 
} 
@Override
    public void setFillColor(Color col)
    { 
if(col != null && col != headFig.getFillColor())//1
{ 
headFig.setFillColor(col);
damage();
} 
} 
@Override
    public void renderingChanged()
    { 
super.renderingChanged();
updateBaseNames();
updateClassifierRoleName();
} 
@Override
    public Color getFillColor()
    { 
return headFig.getFillColor();
} 
private void updateClassifierRoleName()
    { 
classifierRoleName = getBeautifiedName(getOwner());
} 
static class FigClassifierRoleHandler extends FigGroupHandler
  { 
@Override
        protected DefaultHandler getElementHandler(
            HandlerStack stack,
            Object container,
            String uri,
            String localname,
            String qname,
            Attributes attributes) throws SAXException
        { 
DefaultHandler result = null;
String description = attributes.getValue("description");
if(qname.equals("group")
                    && description != null
                    && description.startsWith(FigLifeLine.class.getName()))//1
{ 
FigClassifierRole fcr = (FigClassifierRole)
                                        ((FigGroupHandler) container).getFigGroup();
result = new FigLifeLineHandler(
                    (PGMLStackParser) stack, fcr.getLifeLineFig());
} 
else
if(qname.equals("group")
                       && description != null
                       && description.startsWith(
                           FigMessagePort.class.getName()))//1
{ 
PGMLStackParser parser = (PGMLStackParser) stack;
String ownerRef = attributes.getValue("href");
Object owner = parser.findOwner(ownerRef);
FigMessagePort fmp = new FigMessagePort(owner);
FigClassifierRole fcr =
                    (FigClassifierRole)
                    ((FigGroupHandler) container).getFigGroup();
fcr.getLifeLineFig().addFig(fmp);
result = new FigGroupHandler((PGMLStackParser) stack, fmp);
PGMLStackParser.setCommonAttrs(fmp, attributes);
parser.registerFig(fmp, attributes.getValue("name"));
} 
else
{ 
result =
                    ((PGMLStackParser) stack).getHandler(stack,
                            container,
                            uri,
                            localname,
                            qname,
                            attributes);
} 
return result;
} 
FigClassifierRoleHandler(PGMLStackParser parser,
                                 FigClassifierRole classifierRole)
        { 
super(parser, classifierRole);
} 

 } 
static class TempFig extends FigLine
  { 
private static final long serialVersionUID = 1478952234873792638L;
TempFig(Object owner, int x, int y, int x2)
        { 
super(x, y, x2, y);
setVisible(false);
setOwner(owner);
} 

 } 

 } 
