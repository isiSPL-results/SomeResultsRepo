
//#if -2084598611 
// Compilation Unit of /FigClassifierRole.java 
 

//#if -567749943 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 1995863686 
import java.awt.Color;
//#endif 


//#if 1600021242 
import java.awt.Rectangle;
//#endif 


//#if 495042180 
import java.awt.event.MouseEvent;
//#endif 


//#if 1929571716 
import java.awt.event.MouseListener;
//#endif 


//#if 1629220303 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 812155026 
import java.util.ArrayList;
//#endif 


//#if -439653931 
import java.util.HashSet;
//#endif 


//#if 1256315839 
import java.util.Iterator;
//#endif 


//#if 53944975 
import java.util.List;
//#endif 


//#if 1525965479 
import java.util.Set;
//#endif 


//#if 1549567107 
import java.util.StringTokenizer;
//#endif 


//#if 1094821647 
import org.apache.log4j.Logger;
//#endif 


//#if -1352609150 
import org.argouml.model.Model;
//#endif 


//#if 1336003711 
import org.argouml.uml.diagram.sequence.MessageNode;
//#endif 


//#if 368302622 
import org.argouml.uml.diagram.sequence.ui.FigLifeLine.FigLifeLineHandler;
//#endif 


//#if -1679160228 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 1124621814 
import org.tigris.gef.base.Globals;
//#endif 


//#if 684178613 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1927338586 
import org.tigris.gef.base.Selection;
//#endif 


//#if 372540305 
import org.tigris.gef.persistence.pgml.Container;
//#endif 


//#if 1931846307 
import org.tigris.gef.persistence.pgml.FigGroupHandler;
//#endif 


//#if 833338500 
import org.tigris.gef.persistence.pgml.HandlerFactory;
//#endif 


//#if 1977107334 
import org.tigris.gef.persistence.pgml.HandlerStack;
//#endif 


//#if 59998113 
import org.tigris.gef.persistence.pgml.PGMLStackParser;
//#endif 


//#if 1979542137 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 218266085 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 1334027953 
import org.xml.sax.Attributes;
//#endif 


//#if 1133973251 
import org.xml.sax.SAXException;
//#endif 


//#if 1445142422 
import org.xml.sax.helpers.DefaultHandler;
//#endif 


//#if -1129440427 
public class FigClassifierRole extends 
//#if 774705852 
FigNodeModelElement
//#endif 

 implements 
//#if -1316387172 
MouseListener
//#endif 

, 
//#if 2122561693 
HandlerFactory
//#endif 

  { 

//#if 1653448354 
private static final Logger LOG =
        Logger.getLogger(FigClassifierRole.class);
//#endif 


//#if 2120429034 
public static final int ROLE_WIDTH = 20;
//#endif 


//#if 746066234 
public static final int MARGIN = 10;
//#endif 


//#if -1137074012 
public static final int ROWDISTANCE = 2;
//#endif 


//#if 745372188 
public static final int MIN_HEAD_HEIGHT =
        (3 * ROWHEIGHT + 3 * ROWDISTANCE + STEREOHEIGHT);
//#endif 


//#if 577668370 
public static final int MIN_HEAD_WIDTH = 3 * MIN_HEAD_HEIGHT / 2;
//#endif 


//#if 132620245 
private FigHead headFig;
//#endif 


//#if -71729099 
private FigLifeLine lifeLineFig;
//#endif 


//#if -513393094 
private List<MessageNode> linkPositions = new ArrayList<MessageNode>();
//#endif 


//#if 1487781310 
private String baseNames = "";
//#endif 


//#if -964622985 
private String classifierRoleName = "";
//#endif 


//#if 1673380990 
private static final long serialVersionUID = 7763573563940441408L;
//#endif 


//#if -1551440480 
private void setMatchingFig(MessageNode messageNode)
    { 

//#if -339070036 
if(messageNode.getFigMessagePort() == null)//1
{ 

//#if -1220387886 
int y = getYCoordinate(messageNode);
//#endif 


//#if -853015644 
for (Iterator it = lifeLineFig.getFigs().iterator();
                    it.hasNext();) //1
{ 

//#if -182508869 
Fig fig = (Fig) it.next();
//#endif 


//#if -653787048 
if(fig instanceof FigMessagePort)//1
{ 

//#if 1131023018 
FigMessagePort messagePortFig = (FigMessagePort) fig;
//#endif 


//#if -1749976576 
if(messagePortFig.getY1() == y)//1
{ 

//#if -307811682 
messageNode.setFigMessagePort(messagePortFig);
//#endif 


//#if -1755952786 
messagePortFig.setNode(messageNode);
//#endif 


//#if 230800804 
updateNodeStates();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1582104501 
@Override
    protected void updateNameText()
    { 

//#if 835767801 
String nameText =
            (classifierRoleName + ":" + baseNames).trim();
//#endif 


//#if 1117523092 
getNameFig().setText(nameText);
//#endif 


//#if 1898693047 
calcBounds();
//#endif 


//#if 1425989906 
damage();
//#endif 

} 

//#endif 


//#if -450078685 
public FigClassifierRole(Object node, int x, int y, int w, int h)
    { 

//#if -1980582159 
this();
//#endif 


//#if 1218741762 
setBounds(x, y, w, h);
//#endif 


//#if 1146276416 
setOwner(node);
//#endif 

} 

//#endif 


//#if -1099125204 
private void setPreviousState(int start, int newState)
    { 

//#if 1862352006 
for (int i = start - 1; i >= 0; --i) //1
{ 

//#if -1144427256 
MessageNode node = linkPositions.get(i);
//#endif 


//#if 244888628 
if(node.getFigMessagePort() != null)//1
{ 

//#if -1793204967 
break;

//#endif 

} 

//#endif 


//#if 1330711489 
node.setState(newState);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1099318882 
public static boolean isCallMessage(Object message)
    { 

//#if -1439960688 
return Model.getFacade()
               .isACallAction(Model.getFacade().getAction(message));
//#endif 

} 

//#endif 


//#if 145804885 
void addFigMessagePort(FigMessagePort messagePortFig)
    { 

//#if -1683797058 
lifeLineFig.addFig(messagePortFig);
//#endif 

} 

//#endif 


//#if 1694171077 
@Override
    public Color getLineColor()
    { 

//#if -1200735003 
return headFig.getLineColor();
//#endif 

} 

//#endif 


//#if -1096769485 
@Override
    public Object deepHitPort(int x, int y)
    { 

//#if -432344696 
Rectangle rect = new Rectangle(getX(), y - 16, getWidth(), 32);
//#endif 


//#if 2111754215 
MessageNode foundNode = null;
//#endif 


//#if 909456777 
if(lifeLineFig.intersects(rect))//1
{ 

//#if -1757093750 
for (int i = 0; i < linkPositions.size(); i++) //1
{ 

//#if 1535272184 
MessageNode node = linkPositions.get(i);
//#endif 


//#if -1095761842 
int position = lifeLineFig.getYCoordinate(i);
//#endif 


//#if -1627461175 
if(i < linkPositions.size() - 1)//1
{ 

//#if 1785512497 
int nextPosition =
                        lifeLineFig.getYCoordinate(i + 1);
//#endif 


//#if 2022425171 
if(nextPosition >= y && position <= y)//1
{ 

//#if -1565817591 
if((y - position) <= (nextPosition - y))//1
{ 

//#if -1207017236 
foundNode = node;
//#endif 

} 
else
{ 

//#if 822023875 
foundNode = linkPositions.get(i + 1);
//#endif 

} 

//#endif 


//#if -789539196 
break;

//#endif 

} 

//#endif 

} 
else
{ 

//#if -815648136 
foundNode =
                        linkPositions.get(linkPositions.size() - 1);
//#endif 


//#if -714757482 
MessageNode nextNode;
//#endif 


//#if 1823270816 
nextNode = new MessageNode(this);
//#endif 


//#if 1347315013 
linkPositions.add(nextNode);
//#endif 


//#if 798250809 
int nextPosition = lifeLineFig.getYCoordinate(i + 1);
//#endif 


//#if 717137942 
if((y - position) >= (nextPosition - y))//1
{ 

//#if 1049641597 
foundNode = nextNode;
//#endif 

} 

//#endif 


//#if -372562283 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -128351158 
if(headFig.intersects(rect))//1
{ 

//#if 1465156591 
foundNode = getClassifierRoleNode();
//#endif 

} 
else
{ 

//#if 642708243 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if 777776040 
setMatchingFig(foundNode);
//#endif 


//#if -727538180 
return foundNode;
//#endif 

} 

//#endif 


//#if 1566547361 
public int getNodeCount()
    { 

//#if 1861030289 
return linkPositions.size();
//#endif 

} 

//#endif 


//#if 298137470 
public static boolean isDestroyMessage(Object message)
    { 

//#if -1921981636 
return Model.getFacade()
               .isADestroyAction(Model.getFacade().getAction(message));
//#endif 

} 

//#endif 


//#if -1161769350 
void contractNodes(int start, boolean[] emptyNodes)
    { 

//#if 191379705 
int contracted = 0;
//#endif 


//#if 1539531701 
for (int i = 0; i < emptyNodes.length; ++i) //1
{ 

//#if -894330311 
if(emptyNodes[i])//1
{ 

//#if -1097401832 
if(linkPositions.get(i + start - contracted)
                        .getFigMessagePort()
                        != null)//1
{ 

//#if 1434267918 
throw new IllegalArgumentException(
                        "Trying to contract non-empty MessageNode");
//#endif 

} 

//#endif 


//#if -1959802906 
linkPositions.remove(i + start - contracted);
//#endif 


//#if -132280614 
++contracted;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1613651813 
if(contracted > 0)//1
{ 

//#if 289994894 
updateNodeStates();
//#endif 


//#if -1273218422 
Rectangle r = getBounds();
//#endif 


//#if -1798506999 
r.height -= contracted * SequenceDiagramLayer.LINK_DISTANCE;
//#endif 


//#if 958178284 
updateEdges();
//#endif 


//#if -1681952876 
setBounds(r);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1311423940 
Fig createFigMessagePort(Object message, TempFig tempFig)
    { 

//#if 13601401 
Fig fmp = lifeLineFig.createFigMessagePort(message, tempFig);
//#endif 


//#if -1170140161 
updateNodeStates();
//#endif 


//#if 991963568 
return fmp;
//#endif 

} 

//#endif 


//#if 215693239 
@Override
    public void superTranslate(int dx, int dy)
    { 

//#if 1888635881 
setBounds(getX() + dx, getY(), getWidth(), getHeight());
//#endif 

} 

//#endif 


//#if -1165774557 
public void setLineWidth(int w)
    { 

//#if -32369554 
if(headFig.getLineWidth() != w && w != 0)//1
{ 

//#if 442791252 
headFig.setLineWidth(w);
//#endif 


//#if -1891860476 
lifeLineFig.setLineWidth(w);
//#endif 


//#if 998056626 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 840828342 
private FigClassifierRole()
    { 

//#if -977316202 
super();
//#endif 


//#if 1486860017 
headFig = new FigHead(getStereotypeFig(), getNameFig());
//#endif 


//#if 897937109 
getStereotypeFig().setBounds(MIN_HEAD_WIDTH / 2,
                                     ROWHEIGHT + ROWDISTANCE,
                                     0,
                                     0);
//#endif 


//#if 1791753975 
getStereotypeFig().setFilled(false);
//#endif 


//#if 624488772 
getStereotypeFig().setLineWidth(0);
//#endif 


//#if -2121672832 
getNameFig().setEditable(false);
//#endif 


//#if -778561474 
getNameFig().setFilled(false);
//#endif 


//#if -982445283 
getNameFig().setLineWidth(0);
//#endif 


//#if -1569223775 
lifeLineFig =
            new FigLifeLine(MIN_HEAD_WIDTH / 2 - ROLE_WIDTH / 2, MIN_HEAD_HEIGHT);
//#endif 


//#if -525895014 
linkPositions.add(new MessageNode(this));
//#endif 


//#if -1727618338 
for (int i = 0;
                i <= lifeLineFig.getHeight()
                / SequenceDiagramLayer.LINK_DISTANCE;
                i++) //1
{ 

//#if 415507029 
linkPositions.add(new MessageNode(this));
//#endif 

} 

//#endif 


//#if -769421736 
addFig(lifeLineFig);
//#endif 


//#if 1486237832 
addFig(headFig);
//#endif 

} 

//#endif 


//#if -41914373 
@Override
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -290190048 
Set<Object[]> l = new HashSet<Object[]>();
//#endif 


//#if 16349530 
if(newOwner != null)//1
{ 

//#if 61643768 
l.add(new Object[] {newOwner, null});
//#endif 


//#if -414003496 
Iterator it = Model.getFacade().getBases(newOwner).iterator();
//#endif 


//#if 1923820368 
while (it.hasNext()) //1
{ 

//#if 1831468198 
Object base = it.next();
//#endif 


//#if -303767667 
l.add(new Object[] {base, "name"});
//#endif 

} 

//#endif 


//#if 464267429 
it = Model.getFacade().getStereotypes(newOwner).iterator();
//#endif 


//#if 489061729 
while (it.hasNext()) //2
{ 

//#if 532416797 
Object stereo = it.next();
//#endif 


//#if -2358218 
l.add(new Object[] {stereo, "name"});
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1114719951 
updateElementListeners(l);
//#endif 

} 

//#endif 


//#if 1083962042 
private int setFromActionNode(int lastState, int offset)
    { 

//#if -1874999066 
if(lastState == MessageNode.INITIAL)//1
{ 

//#if 108729805 
lastState = MessageNode.DONE_SOMETHING_NO_CALL;
//#endif 


//#if 1533635703 
setPreviousState(offset, lastState);
//#endif 

} 
else

//#if 669969140 
if(lastState == MessageNode.IMPLICIT_RETURNED)//1
{ 

//#if 626097198 
lastState = MessageNode.CALLED;
//#endif 


//#if -1910146245 
setPreviousState(offset, lastState);
//#endif 

} 
else

//#if 1903425941 
if(lastState == MessageNode.IMPLICIT_CREATED)//1
{ 

//#if 1526037453 
lastState = MessageNode.CREATED;
//#endif 


//#if -1853470127 
setPreviousState(offset, lastState);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1834102591 
return lastState;
//#endif 

} 

//#endif 


//#if -171231917 
void removeFigMessagePort(FigMessagePort fmp)
    { 

//#if 1722657621 
fmp.getNode().setFigMessagePort(null);
//#endif 


//#if 471264578 
fmp.setNode(null);
//#endif 


//#if 1725417465 
lifeLineFig.removeFig(fmp);
//#endif 

} 

//#endif 


//#if 1631104572 
public static boolean isCreateMessage(Object message)
    { 

//#if -318469307 
return Model.getFacade()
               .isACreateAction(Model.getFacade().getAction(message));
//#endif 

} 

//#endif 


//#if -1361783158 
@Override
    public void mouseReleased(MouseEvent me)
    { 

//#if -1705705487 
super.mouseReleased(me);
//#endif 


//#if -561308528 
Layer lay = Globals.curEditor().getLayerManager().getActiveLayer();
//#endif 


//#if 1724150842 
if(lay instanceof SequenceDiagramLayer)//1
{ 

//#if -1416176571 
((SequenceDiagramLayer) lay).putInPosition(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1497302804 
@Override
    public int getLineWidth()
    { 

//#if -2107612914 
return headFig.getLineWidth();
//#endif 

} 

//#endif 


//#if -2044743833 
@Override
    protected void modelChanged(PropertyChangeEvent mee)
    { 

//#if 1431745548 
if(mee.getPropertyName().equals("name"))//1
{ 

//#if 2033448022 
if(mee.getSource() == getOwner())//1
{ 

//#if -143038977 
updateClassifierRoleName();
//#endif 

} 
else

//#if 1167925654 
if(Model.getFacade().isAStereotype(mee.getSource()))//1
{ 

//#if -1003111527 
updateStereotypeText();
//#endif 

} 
else
{ 

//#if -1294980394 
updateBaseNames();
//#endif 

} 

//#endif 


//#endif 


//#if -2117447480 
renderingChanged();
//#endif 

} 
else

//#if 1893412603 
if(mee.getPropertyName().equals("stereotype"))//1
{ 

//#if 882677908 
updateStereotypeText();
//#endif 


//#if 683963342 
updateListeners(getOwner(), getOwner());
//#endif 


//#if 2087869364 
renderingChanged();
//#endif 

} 
else

//#if -1037086345 
if(mee.getPropertyName().equals("base"))//1
{ 

//#if 1313365075 
updateBaseNames();
//#endif 


//#if -700029083 
updateListeners(getOwner(), getOwner());
//#endif 


//#if 861585611 
renderingChanged();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1596605394 
@Override
    protected void updateBounds()
    { 

//#if -1381748492 
Rectangle bounds = getBounds();
//#endif 


//#if 468330865 
bounds.width =
            Math.max(
                getNameFig().getWidth() + 2 * MARGIN,
                getStereotypeFig().getWidth() + 2 * MARGIN);
//#endif 


//#if 2109064868 
setBounds(bounds);
//#endif 

} 

//#endif 


//#if -1417582539 
public FigClassifierRole(Object node)
    { 

//#if -693456488 
this();
//#endif 


//#if 1997876711 
setOwner(node);
//#endif 

} 

//#endif 


//#if -248351939 
@Override
    public boolean isFilled()
    { 

//#if 963621898 
return headFig.isFilled();
//#endif 

} 

//#endif 


//#if -1465975415 
private String getBeautifiedName(Object o)
    { 

//#if -257060010 
String name = Model.getFacade().getName(o);
//#endif 


//#if -1664027251 
if(name == null || name.equals(""))//1
{ 

//#if 1290112641 
name = "(anon " + Model.getFacade().getUMLClassName(o) + ")";
//#endif 

} 

//#endif 


//#if -1895535679 
return name;
//#endif 

} 

//#endif 


//#if 479259338 
public MessageNode previousNode(MessageNode node)
    { 

//#if 1285402188 
if(getIndexOf(node) > 0)//1
{ 

//#if -1114310060 
return linkPositions.get(getIndexOf(node) - 1);
//#endif 

} 

//#endif 


//#if 2129774905 
return null;
//#endif 

} 

//#endif 


//#if 327198955 
@Override
    public Selection makeSelection()
    { 

//#if 2089314608 
return new SelectionClassifierRole(this);
//#endif 

} 

//#endif 


//#if -1401577725 
public DefaultHandler getHandler(HandlerStack stack,
                                     Object container,
                                     String uri,
                                     String localname,
                                     String qname,
                                     Attributes attributes)
    throws SAXException
    { 

//#if 374644312 
PGMLStackParser parser = (PGMLStackParser) stack;
//#endif 


//#if 1477742040 
StringTokenizer st =
            new StringTokenizer(attributes.getValue("description"), ",;[] ");
//#endif 


//#if 1289617855 
if(st.hasMoreElements())//1
{ 

//#if -1841283661 
st.nextToken();
//#endif 

} 

//#endif 


//#if 1062669391 
String xStr = null;
//#endif 


//#if 866155886 
String yStr = null;
//#endif 


//#if 1259182896 
String wStr = null;
//#endif 


//#if -88081825 
String hStr = null;
//#endif 


//#if 523132050 
if(st.hasMoreElements())//2
{ 

//#if 119978285 
xStr = st.nextToken();
//#endif 


//#if -288845940 
yStr = st.nextToken();
//#endif 


//#if 528802510 
wStr = st.nextToken();
//#endif 


//#if -1928768707 
hStr = st.nextToken();
//#endif 

} 

//#endif 


//#if 987481589 
if(xStr != null && !xStr.equals(""))//1
{ 

//#if -1801638515 
int x = Integer.parseInt(xStr);
//#endif 


//#if 444748589 
int y = Integer.parseInt(yStr);
//#endif 


//#if 246941677 
int w = Integer.parseInt(wStr);
//#endif 


//#if 910873485 
int h = Integer.parseInt(hStr);
//#endif 


//#if -1656232589 
setBounds(x, y, w, h);
//#endif 

} 

//#endif 


//#if -121329745 
PGMLStackParser.setCommonAttrs(this, attributes);
//#endif 


//#if -1604670550 
parser.registerFig(this, attributes.getValue("name"));
//#endif 


//#if -51907864 
((Container) container).addObject(this);
//#endif 


//#if 807810374 
return new FigClassifierRoleHandler(parser, this);
//#endif 

} 

//#endif 


//#if 548304182 
FigHead getHeadFig()
    { 

//#if -2012454240 
return headFig;
//#endif 

} 

//#endif 


//#if 558136255 
void updateNodeStates()
    { 

//#if -366148650 
int lastState = MessageNode.INITIAL;
//#endif 


//#if -251683201 
ArrayList callers = null;
//#endif 


//#if 1958214451 
int nodeCount = linkPositions.size();
//#endif 


//#if -1168509064 
for (int i = 0; i < nodeCount; ++i) //1
{ 

//#if 156586361 
MessageNode node = linkPositions.get(i);
//#endif 


//#if -145400585 
FigMessagePort figMessagePort = node.getFigMessagePort();
//#endif 


//#if 333755034 
if(figMessagePort != null)//1
{ 

//#if -2093649 
int fmpY = lifeLineFig.getYCoordinate(i);
//#endif 


//#if 553623072 
if(figMessagePort.getY() != fmpY)//1
{ 

//#if -169080758 
figMessagePort.setBounds(lifeLineFig.getX(),
                                             fmpY, ROLE_WIDTH, 1);
//#endif 

} 

//#endif 


//#if 1443316113 
Object message = figMessagePort.getOwner();
//#endif 


//#if -347670820 
boolean selfMessage =
                    (Model.getFacade().isAMessage(message)
                     && (Model.getFacade().getSender(message)
                         == Model.getFacade().getReceiver(message)));
//#endif 


//#if -289872768 
boolean selfReceiving = false;
//#endif 


//#if -1843340959 
if(selfMessage)//1
{ 

//#if 1519767960 
for (int j = i - 1; j >= 0; --j) //1
{ 

//#if 67138110 
MessageNode prev = linkPositions.get(j);
//#endif 


//#if 1820852549 
FigMessagePort prevmp = prev.getFigMessagePort();
//#endif 


//#if 245734992 
if(prevmp != null && prevmp.getOwner() == message)//1
{ 

//#if -1906320996 
selfReceiving = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -522667307 
if(isCallMessage(message))//1
{ 

//#if 812472390 
if(Model.getFacade().getSender(message) == getOwner()
                            && !selfReceiving)//1
{ 

//#if -1092864184 
lastState = setFromActionNode(lastState, i);
//#endif 


//#if -319946140 
node.setState(lastState);
//#endif 


//#if -62138104 
node.setCallers(callers);
//#endif 

} 
else
{ 

//#if -695102765 
if(lastState == MessageNode.INITIAL
                                || lastState == MessageNode.CREATED
                                || lastState == MessageNode.IMPLICIT_CREATED
                                || lastState == MessageNode.IMPLICIT_RETURNED
                                || lastState == MessageNode.RETURNED)//1
{ 

//#if 1084723816 
lastState = MessageNode.CALLED;
//#endif 

} 

//#endif 


//#if 1160113616 
if(callers == null)//1
{ 

//#if -620609880 
callers = new ArrayList();
//#endif 

} 
else
{ 

//#if 634882077 
callers = new ArrayList(callers);
//#endif 

} 

//#endif 


//#if 2121871812 
callers.add(Model.getFacade().getSender(message));
//#endif 


//#if 1795384572 
node.setState(lastState);
//#endif 


//#if 2053192608 
node.setCallers(callers);
//#endif 

} 

//#endif 

} 
else

//#if -690357915 
if(isReturnMessage(message))//1
{ 

//#if 1282159470 
if(lastState == MessageNode.IMPLICIT_RETURNED)//1
{ 

//#if -1332598249 
setPreviousState(i, MessageNode.CALLED);
//#endif 


//#if -1030770777 
lastState = MessageNode.CALLED;
//#endif 

} 

//#endif 


//#if -781627849 
if(Model.getFacade().getSender(message) == getOwner()
                            && !selfReceiving)//1
{ 

//#if 830470618 
if(callers == null)//1
{ 

//#if 1866956144 
callers = new ArrayList();
//#endif 

} 

//#endif 


//#if 1001587375 
Object caller = Model.getFacade().getReceiver(message);
//#endif 


//#if -604633041 
int callerIndex = callers.lastIndexOf(caller);
//#endif 


//#if -542515438 
if(callerIndex != -1)//1
{ 

//#if 1182994213 
for (int backNodeIndex = i - 1;
                                    backNodeIndex > 0
                                    && linkPositions
                                    .get(backNodeIndex)
                                    .matchingCallerList(caller,
                                                        callerIndex);
                                    --backNodeIndex) //1
{ 
} 

//#endif 


//#if -258836715 
if(callerIndex == 0)//1
{ 

//#if 2032735437 
callers = null;
//#endif 


//#if 615448876 
if(lastState == MessageNode.CALLED)//1
{ 

//#if -203646949 
lastState = MessageNode.RETURNED;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1587013694 
callers =
                                    new ArrayList(callers.subList(0,
                                                                  callerIndex));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 595811762 
node.setState(lastState);
//#endif 


//#if 853619798 
node.setCallers(callers);
//#endif 

} 
else

//#if -1111221324 
if(isCreateMessage(message))//1
{ 

//#if 2080156900 
if(Model.getFacade().getSender(message) == getOwner())//1
{ 

//#if 2026725882 
lastState = setFromActionNode(lastState, i);
//#endif 


//#if 1075761430 
node.setState(lastState);
//#endif 


//#if 1333569466 
node.setCallers(callers);
//#endif 

} 
else
{ 

//#if -507269560 
lastState = MessageNode.CREATED;
//#endif 


//#if -1349573055 
setPreviousState(i, MessageNode.PRECREATED);
//#endif 


//#if 1267148882 
node.setState(lastState);
//#endif 


//#if 1524956918 
node.setCallers(callers);
//#endif 

} 

//#endif 

} 
else

//#if 744886305 
if(isDestroyMessage(message))//1
{ 

//#if -82069024 
if(Model.getFacade().getSender(message) == getOwner()
                            && !selfReceiving)//1
{ 

//#if -1570799779 
lastState = setFromActionNode(lastState, i);
//#endif 


//#if 820384889 
node.setState(lastState);
//#endif 


//#if 1078192925 
node.setCallers(callers);
//#endif 

} 
else
{ 

//#if -1431022367 
lastState = MessageNode.DESTROYED;
//#endif 


//#if 778849351 
callers = null;
//#endif 


//#if -1041236312 
node.setState(lastState);
//#endif 


//#if -783428276 
node.setCallers(callers);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if 415488423 
if(lastState == MessageNode.CALLED)//1
{ 

//#if -638856553 
lastState = MessageNode.IMPLICIT_RETURNED;
//#endif 

} 

//#endif 


//#if -793249426 
if(lastState == MessageNode.CREATED)//1
{ 

//#if 1867660336 
lastState = MessageNode.IMPLICIT_CREATED;
//#endif 

} 

//#endif 


//#if -898378605 
node.setState(lastState);
//#endif 


//#if -640570569 
node.setCallers(callers);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1765493552 
void updateEmptyNodeArray(int start, boolean[] emptyNodes)
    { 

//#if -212060150 
for (int i = 0; i < emptyNodes.length; ++i) //1
{ 

//#if 1241903892 
if(linkPositions.get(i + start).getFigMessagePort()
                    != null)//1
{ 

//#if -1023127444 
emptyNodes[i] = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1483248784 
public static boolean isReturnMessage(Object message)
    { 

//#if 462040051 
return Model.getFacade()
               .isAReturnAction(Model.getFacade().getAction(message));
//#endif 

} 

//#endif 


//#if -1420795091 
@Override
    public void setOwner(Object own)
    { 

//#if 293659047 
super.setOwner(own);
//#endif 


//#if -1594903143 
bindPort(own, headFig);
//#endif 

} 

//#endif 


//#if 876248188 
void setMatchingNode(FigMessagePort fmp)
    { 

//#if -1159693998 
while (lifeLineFig.getYCoordinate(getNodeCount() - 1) < fmp.getY1()) //1
{ 

//#if -613395172 
growToSize(getNodeCount() + 10);
//#endif 

} 

//#endif 


//#if -1004735453 
int i = 0;
//#endif 


//#if 2078803445 
for (Iterator it = linkPositions.iterator(); it.hasNext(); ++i) //1
{ 

//#if -862829934 
MessageNode node = (MessageNode) it.next();
//#endif 


//#if -795029150 
if(lifeLineFig.getYCoordinate(i) == fmp.getY1())//1
{ 

//#if 2140578249 
node.setFigMessagePort(fmp);
//#endif 


//#if -1051700167 
fmp.setNode(node);
//#endif 


//#if 759042577 
updateNodeStates();
//#endif 


//#if -728147336 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 363216772 
public MessageNode getNode(int position)
    { 

//#if 1351092929 
if(position < linkPositions.size())//1
{ 

//#if 166838328 
return linkPositions.get(position);
//#endif 

} 

//#endif 


//#if 741889265 
MessageNode node = null;
//#endif 


//#if -492219864 
for (int cnt = position - linkPositions.size(); cnt >= 0; cnt--) //1
{ 

//#if 733117717 
node = new MessageNode(this);
//#endif 


//#if 153923514 
linkPositions.add(node);
//#endif 

} 

//#endif 


//#if -1948888993 
calcBounds();
//#endif 


//#if -521002568 
return node;
//#endif 

} 

//#endif 


//#if -330735076 
@Override
    protected void updateStereotypeText()
    { 

//#if -381297120 
Rectangle rect = headFig.getBounds();
//#endif 


//#if 1267496019 
getStereotypeFig().setOwner(getOwner());
//#endif 


//#if 1974892680 
int minWidth = headFig.getMinimumSize().width;
//#endif 


//#if 51852320 
if(minWidth > rect.width)//1
{ 

//#if -645336333 
rect.width = minWidth;
//#endif 

} 

//#endif 


//#if 1588601678 
int headHeight = headFig.getMinimumSize().height;
//#endif 


//#if -1909108078 
headFig.setBounds(
            rect.x,
            rect.y,
            rect.width,
            headHeight);
//#endif 


//#if 546144921 
if(getLayer() == null)//1
{ 

//#if -370817046 
return;
//#endif 

} 

//#endif 


//#if -152598359 
int h = MIN_HEAD_HEIGHT;
//#endif 


//#if 22869161 
List figs = getLayer().getContents();
//#endif 


//#if -1038071451 
for (Iterator i = figs.iterator(); i.hasNext();) //1
{ 

//#if -190029102 
Object o = i.next();
//#endif 


//#if -1920978128 
if(o instanceof FigClassifierRole)//1
{ 

//#if -197632876 
FigClassifierRole other = (FigClassifierRole) o;
//#endif 


//#if -193959016 
int otherHeight = other.headFig.getMinimumHeight();
//#endif 


//#if -431994536 
if(otherHeight > h)//1
{ 

//#if -1899272934 
h = otherHeight;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -122371438 
int height = headFig.getHeight() + lifeLineFig.getHeight();
//#endif 


//#if 2003082941 
setBounds(
            headFig.getX(),
            headFig.getY(),
            headFig.getWidth(),
            height);
//#endif 


//#if 1700172499 
calcBounds();
//#endif 


//#if -2095633793 
Layer layer = getLayer();
//#endif 


//#if -1266809889 
List layerFigs = layer.getContents();
//#endif 


//#if 276219802 
for (Iterator i = layerFigs.iterator(); i.hasNext();) //1
{ 

//#if -1045656940 
Object o = i.next();
//#endif 


//#if -57227097 
if(o instanceof FigClassifierRole && o != this)//1
{ 

//#if -1386171743 
FigClassifierRole other = (FigClassifierRole) o;
//#endif 


//#if -8604419 
other.setHeight(height);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 248214637 
private FigLifeLine getLifeLineFig()
    { 

//#if -1826364028 
return lifeLineFig;
//#endif 

} 

//#endif 


//#if 1084589774 
public MessageNode nextNode(MessageNode node)
    { 

//#if 832309219 
if(getIndexOf(node) < linkPositions.size())//1
{ 

//#if -1654847376 
return linkPositions.get(getIndexOf(node) + 1);
//#endif 

} 

//#endif 


//#if -1290415992 
return null;
//#endif 

} 

//#endif 


//#if -1322271401 
private void addActivations()
    { 

//#if 482361784 
MessageNode startActivationNode = null;
//#endif 


//#if -613481103 
MessageNode endActivationNode = null;
//#endif 


//#if 2102810397 
int lastState = MessageNode.INITIAL;
//#endif 


//#if 994379772 
boolean startFull = false;
//#endif 


//#if -1060054045 
boolean endFull = false;
//#endif 


//#if 1186533580 
int nodeCount = linkPositions.size();
//#endif 


//#if -1839087942 
int x = lifeLineFig.getX();
//#endif 


//#if -1091583599 
for (int i = 0; i < nodeCount; ++i) //1
{ 

//#if -420741833 
MessageNode node = linkPositions.get(i);
//#endif 


//#if -1721874977 
int nextState = node.getState();
//#endif 


//#if -415752419 
if(lastState != nextState && nextState == MessageNode.CREATED)//1
{ 

//#if -448644985 
lifeLineFig.addActivationFig(
                    new FigBirthActivation(
                        lifeLineFig.getX(),
                        lifeLineFig.getYCoordinate(i)
                        - SequenceDiagramLayer.LINK_DISTANCE / 4));
//#endif 

} 

//#endif 


//#if 942815886 
if(lastState != nextState
                    && nextState == MessageNode.DESTROYED)//1
{ 

//#if -1267226184 
int y =
                    lifeLineFig.getYCoordinate(i)
                    - SequenceDiagramLayer.LINK_DISTANCE / 2;
//#endif 


//#if -1546609281 
lifeLineFig.addActivationFig(
                    new FigLine(x,
                                y + SequenceDiagramLayer.LINK_DISTANCE / 2,
                                x + ROLE_WIDTH,
                                y + SequenceDiagramLayer.LINK_DISTANCE, LINE_COLOR)
                );
//#endif 


//#if -569142017 
lifeLineFig.addActivationFig(
                    new FigLine(x,
                                y + SequenceDiagramLayer.LINK_DISTANCE,
                                x + ROLE_WIDTH,
                                y
                                + SequenceDiagramLayer.LINK_DISTANCE / 2, LINE_COLOR)
                );
//#endif 

} 

//#endif 


//#if 932348672 
if(startActivationNode == null)//1
{ 

//#if -1215368334 
switch (nextState) //1
{ 
case MessageNode.DONE_SOMETHING_NO_CALL://1


//#if 1230202822 
startActivationNode = node;
//#endif 


//#if 655992145 
startFull = true;
//#endif 


//#if 1179328364 
break;

//#endif 


case MessageNode.CALLED://1

case MessageNode.CREATED://1


//#if 28542422 
startActivationNode = node;
//#endif 


//#if 1249283844 
startFull = false;
//#endif 


//#if -439084196 
break;

//#endif 


default://1

} 

//#endif 

} 
else
{ 

//#if -571428847 
switch (nextState) //1
{ 
case MessageNode.DESTROYED ://1

case MessageNode.RETURNED ://1


//#if 367490446 
endActivationNode = node;
//#endif 


//#if -637824948 
endFull = false;
//#endif 


//#if 626333629 
break;

//#endif 


case MessageNode.IMPLICIT_RETURNED ://1

case MessageNode.IMPLICIT_CREATED ://1


//#if 1345013208 
endActivationNode = linkPositions.get(i - 1);
//#endif 


//#if 1159890573 
endFull = true;
//#endif 


//#if 625760457 
break;

//#endif 


case MessageNode.CALLED ://1


//#if 883779963 
if(lastState == MessageNode.CREATED)//1
{ 

//#if 1695490187 
endActivationNode =
                            linkPositions.get(i - 1);
//#endif 


//#if 1977013893 
endFull = false;
//#endif 


//#if 371276012 
--i;
//#endif 


//#if -95410631 
nextState = lastState;
//#endif 

} 

//#endif 


//#if 1707381532 
break;

//#endif 


default://1

} 

//#endif 

} 

//#endif 


//#if -1472998143 
lastState = nextState;
//#endif 


//#if -1419062870 
if(startActivationNode != null && endActivationNode != null)//1
{ 

//#if -644286928 
if(startActivationNode != endActivationNode
                        || startFull || endFull)//1
{ 

//#if -618340141 
int y1 = getYCoordinate(startActivationNode);
//#endif 


//#if 971166060 
if(startFull)//1
{ 

//#if 386350780 
y1 -= SequenceDiagramLayer.LINK_DISTANCE / 2;
//#endif 

} 

//#endif 


//#if -332605077 
int y2 = getYCoordinate(endActivationNode);
//#endif 


//#if -145521243 
if(endFull)//1
{ 

//#if -1024528307 
y2 += SequenceDiagramLayer.LINK_DISTANCE / 2;
//#endif 

} 

//#endif 


//#if -926726711 
lifeLineFig.addActivationFig(
                        new FigActivation(x, y1, ROLE_WIDTH, y2 - y1));
//#endif 

} 

//#endif 


//#if 990232 
startActivationNode = null;
//#endif 


//#if -1217333295 
endActivationNode = null;
//#endif 


//#if -2052580867 
startFull = false;
//#endif 


//#if -652051932 
endFull = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1437643094 
if(startActivationNode != null)//1
{ 

//#if 1850107182 
endActivationNode = linkPositions.get(nodeCount - 1);
//#endif 


//#if -544731617 
endFull = true;
//#endif 


//#if 684502032 
int y1 = getYCoordinate(startActivationNode);
//#endif 


//#if 1518317289 
if(startFull)//1
{ 

//#if -204440636 
y1 -= SequenceDiagramLayer.LINK_DISTANCE / 2;
//#endif 

} 

//#endif 


//#if 920145896 
int y2 = getYCoordinate(endActivationNode);
//#endif 


//#if 663985762 
if(endFull)//1
{ 

//#if -1897205929 
y2 += SequenceDiagramLayer.LINK_DISTANCE / 2;
//#endif 

} 

//#endif 


//#if -668597370 
lifeLineFig.addActivationFig(
                new FigActivation(x, y1, ROLE_WIDTH, y2 - y1));
//#endif 


//#if 1497892086 
startActivationNode = null;
//#endif 


//#if -1997897681 
endActivationNode = null;
//#endif 


//#if -989716641 
startFull = false;
//#endif 


//#if -123572218 
endFull = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1510519661 
void grow(int nodePosition, int count)
    { 

//#if 808004839 
for (int i = 0; i < count; ++i) //1
{ 

//#if -1138159359 
linkPositions.add(nodePosition, new MessageNode(this));
//#endif 

} 

//#endif 


//#if -446646558 
if(count > 0)//1
{ 

//#if -495538957 
updateNodeStates();
//#endif 


//#if 350172271 
Rectangle r = getBounds();
//#endif 


//#if 671965926 
r.height += count * SequenceDiagramLayer.LINK_DISTANCE;
//#endif 


//#if -53374023 
setBounds(r);
//#endif 


//#if -95484825 
updateEdges();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1447316879 
public void addNode(int position, MessageNode node)
    { 

//#if 1697430327 
linkPositions.add(position, node);
//#endif 


//#if 724887451 
Iterator it =
            linkPositions
            .subList(position + 1, linkPositions.size())
            .iterator();
//#endif 


//#if 301784357 
while (it.hasNext()) //1
{ 

//#if -239145188 
Object o = it.next();
//#endif 


//#if -1125371626 
if(o instanceof MessageNode)//1
{ 

//#if 989864347 
FigMessagePort figMessagePort =
                    ((MessageNode) o).getFigMessagePort();
//#endif 


//#if -1116596066 
if(figMessagePort != null)//1
{ 

//#if -1905966319 
figMessagePort.setY(
                        figMessagePort.getY()
                        + SequenceDiagramLayer.LINK_DISTANCE);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1433533621 
calcBounds();
//#endif 

} 

//#endif 


//#if 1585186218 
public int getIndexOf(MessageNode node)
    { 

//#if 303661755 
return linkPositions.indexOf(node);
//#endif 

} 

//#endif 


//#if 10895266 
public int getYCoordinate(MessageNode node)
    { 

//#if -252641600 
return lifeLineFig.getYCoordinate(linkPositions.indexOf(node));
//#endif 

} 

//#endif 


//#if -446114731 
private void updateBaseNames()
    { 

//#if -1388397126 
StringBuffer b = new StringBuffer();
//#endif 


//#if -172612914 
Iterator it = Model.getFacade().getBases(getOwner()).iterator();
//#endif 


//#if -1762674289 
while (it.hasNext()) //1
{ 

//#if -4431088 
b.append(getBeautifiedName(it.next()));
//#endif 


//#if -2113734353 
if(it.hasNext())//1
{ 

//#if -2056049203 
b.append(',');
//#endif 

} 

//#endif 

} 

//#endif 


//#if 389851415 
baseNames = b.toString();
//#endif 

} 

//#endif 


//#if 1581340523 
@Override
    public void setStandardBounds(int x, int y, int w, int h)
    { 

//#if -1616973742 
y = 50;
//#endif 


//#if 1072828821 
Rectangle oldBounds = getBounds();
//#endif 


//#if 597615439 
w = headFig.getMinimumSize().width;
//#endif 


//#if 612590050 
headFig.setBounds(x, y, w, headFig.getMinimumSize().height);
//#endif 


//#if -95683728 
lifeLineFig.setBounds(
            (x + w / 2) - ROLE_WIDTH / 2,
            y + headFig.getHeight(),
            ROLE_WIDTH,
            h - headFig.getHeight());
//#endif 


//#if -639320909 
this.updateEdges();
//#endif 


//#if 1857518750 
growToSize(
            lifeLineFig.getHeight() / SequenceDiagramLayer.LINK_DISTANCE
            + 2);
//#endif 


//#if 205314150 
calcBounds();
//#endif 


//#if 1054664162 
firePropChange("bounds", oldBounds, getBounds());
//#endif 

} 

//#endif 


//#if -1129058642 
@Override
    public Fig getPortFig(Object messageNode)
    { 

//#if 1665401477 
if(Model.getFacade().isAClassifierRole(messageNode))//1
{ 

//#if -484786834 
LOG.debug("Got a ClassifierRole - only legal on load");
//#endif 


//#if -760324554 
return null;
//#endif 

} 

//#endif 


//#if -478423403 
if(!(messageNode instanceof MessageNode))//1
{ 

//#if 108461743 
throw new IllegalArgumentException(
                "Expecting a MessageNode but got a "
                + messageNode.getClass().getName());
//#endif 

} 

//#endif 


//#if 927741932 
setMatchingFig((MessageNode) messageNode);
//#endif 


//#if 1423133529 
if(((MessageNode) messageNode).getFigMessagePort() != null)//1
{ 

//#if 840846999 
return ((MessageNode) messageNode).getFigMessagePort();
//#endif 

} 

//#endif 


//#if 2077117402 
return new TempFig(
                   messageNode, lifeLineFig.getX(),
                   getYCoordinate((MessageNode) messageNode),
                   lifeLineFig.getX() + ROLE_WIDTH);
//#endif 

} 

//#endif 


//#if 141950779 
public void updateActivations()
    { 

//#if -1887702620 
LOG.debug("Updating activations");
//#endif 


//#if 403363959 
lifeLineFig.removeActivations();
//#endif 


//#if 587269314 
addActivations();
//#endif 

} 

//#endif 


//#if -2134526995 
private MessageNode getClassifierRoleNode()
    { 

//#if 1047452327 
return linkPositions.get(0);
//#endif 

} 

//#endif 


//#if -124591773 
void growToSize(int nodeCount)
    { 

//#if 1342241019 
grow(linkPositions.size(), nodeCount - linkPositions.size());
//#endif 

} 

//#endif 


//#if -879977521 
@Override
    public void setFilled(boolean filled)
    { 

//#if -1930479136 
if(headFig.isFilled() != filled)//1
{ 

//#if -1201831185 
headFig.setFilled(filled);
//#endif 


//#if -1672659586 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1379604686 
@Override
    public void setFillColor(Color col)
    { 

//#if 1988858108 
if(col != null && col != headFig.getFillColor())//1
{ 

//#if -1695365591 
headFig.setFillColor(col);
//#endif 


//#if -1706923756 
damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 26810165 
@Override
    public void renderingChanged()
    { 

//#if 1945372703 
super.renderingChanged();
//#endif 


//#if 1538042156 
updateBaseNames();
//#endif 


//#if -2004085585 
updateClassifierRoleName();
//#endif 

} 

//#endif 


//#if -1774310570 
@Override
    public Color getFillColor()
    { 

//#if -1980932705 
return headFig.getFillColor();
//#endif 

} 

//#endif 


//#if 752656486 
private void updateClassifierRoleName()
    { 

//#if -1764192533 
classifierRoleName = getBeautifiedName(getOwner());
//#endif 

} 

//#endif 


//#if 950502236 
static class FigClassifierRoleHandler extends 
//#if 1023804477 
FigGroupHandler
//#endif 

  { 

//#if -1197509049 
@Override
        protected DefaultHandler getElementHandler(
            HandlerStack stack,
            Object container,
            String uri,
            String localname,
            String qname,
            Attributes attributes) throws SAXException
        { 

//#if -349218232 
DefaultHandler result = null;
//#endif 


//#if -266048345 
String description = attributes.getValue("description");
//#endif 


//#if -1278217478 
if(qname.equals("group")
                    && description != null
                    && description.startsWith(FigLifeLine.class.getName()))//1
{ 

//#if -145826149 
FigClassifierRole fcr = (FigClassifierRole)
                                        ((FigGroupHandler) container).getFigGroup();
//#endif 


//#if -1932600317 
result = new FigLifeLineHandler(
                    (PGMLStackParser) stack, fcr.getLifeLineFig());
//#endif 

} 
else

//#if 563148499 
if(qname.equals("group")
                       && description != null
                       && description.startsWith(
                           FigMessagePort.class.getName()))//1
{ 

//#if 147960639 
PGMLStackParser parser = (PGMLStackParser) stack;
//#endif 


//#if 1677800322 
String ownerRef = attributes.getValue("href");
//#endif 


//#if -1423710561 
Object owner = parser.findOwner(ownerRef);
//#endif 


//#if -758992478 
FigMessagePort fmp = new FigMessagePort(owner);
//#endif 


//#if 334820603 
FigClassifierRole fcr =
                    (FigClassifierRole)
                    ((FigGroupHandler) container).getFigGroup();
//#endif 


//#if -1468008859 
fcr.getLifeLineFig().addFig(fmp);
//#endif 


//#if 669454615 
result = new FigGroupHandler((PGMLStackParser) stack, fmp);
//#endif 


//#if 1710980763 
PGMLStackParser.setCommonAttrs(fmp, attributes);
//#endif 


//#if 385693566 
parser.registerFig(fmp, attributes.getValue("name"));
//#endif 

} 
else
{ 

//#if -862740835 
result =
                    ((PGMLStackParser) stack).getHandler(stack,
                            container,
                            uri,
                            localname,
                            qname,
                            attributes);
//#endif 

} 

//#endif 


//#endif 


//#if 306934947 
return result;
//#endif 

} 

//#endif 


//#if -284612070 
FigClassifierRoleHandler(PGMLStackParser parser,
                                 FigClassifierRole classifierRole)
        { 

//#if 773546972 
super(parser, classifierRole);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 777702403 
static class TempFig extends 
//#if 1556972067 
FigLine
//#endif 

  { 

//#if 664962642 
private static final long serialVersionUID = 1478952234873792638L;
//#endif 


//#if -436925564 
TempFig(Object owner, int x, int y, int x2)
        { 

//#if 1664768775 
super(x, y, x2, y);
//#endif 


//#if -670182889 
setVisible(false);
//#endif 


//#if 263268072 
setOwner(owner);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

