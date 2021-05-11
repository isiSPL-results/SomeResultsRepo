
//#if 2073705944 
// Compilation Unit of /FigLifeLine.java 
 

//#if -307099173 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 382589301 
import java.awt.Dimension;
//#endif 


//#if 1299331904 
import java.util.ArrayList;
//#endif 


//#if 767555587 
import java.util.HashSet;
//#endif 


//#if 25105233 
import java.util.Iterator;
//#endif 


//#if 875754273 
import java.util.List;
//#endif 


//#if -2049755179 
import java.util.Set;
//#endif 


//#if 170853553 
import java.util.StringTokenizer;
//#endif 


//#if -126723395 
import org.apache.log4j.Logger;
//#endif 


//#if -422325871 
import org.argouml.uml.diagram.sequence.MessageNode;
//#endif 


//#if -1856695591 
import org.argouml.uml.diagram.sequence.ui.FigClassifierRole.TempFig;
//#endif 


//#if -1456228613 
import org.argouml.uml.diagram.ui.ArgoFigGroup;
//#endif 


//#if 1301079999 
import org.tigris.gef.persistence.pgml.Container;
//#endif 


//#if 956410961 
import org.tigris.gef.persistence.pgml.FigGroupHandler;
//#endif 


//#if -999242474 
import org.tigris.gef.persistence.pgml.HandlerFactory;
//#endif 


//#if 218777752 
import org.tigris.gef.persistence.pgml.HandlerStack;
//#endif 


//#if -915437233 
import org.tigris.gef.persistence.pgml.PGMLStackParser;
//#endif 


//#if -894780458 
import org.tigris.gef.persistence.pgml.UnknownHandler;
//#endif 


//#if -1655795673 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 919410835 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 924822691 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 2125907267 
import org.xml.sax.Attributes;
//#endif 


//#if 1920782613 
import org.xml.sax.SAXException;
//#endif 


//#if -1303186648 
import org.xml.sax.helpers.DefaultHandler;
//#endif 


//#if -2070169805 
class FigLifeLine extends 
//#if -465980735 
ArgoFigGroup
//#endif 

 implements 
//#if -118698739 
HandlerFactory
//#endif 

  { 

//#if -406886283 
private static final long serialVersionUID = -1242239243040698287L;
//#endif 


//#if -1959912405 
private static final Logger LOG = Logger.getLogger(FigLifeLine.class);
//#endif 


//#if -1585100846 
static final int WIDTH = 20;
//#endif 


//#if -1619437254 
static final int HEIGHT = 1000;
//#endif 


//#if -79899003 
private FigRect rect;
//#endif 


//#if 1293956709 
private FigLine line;
//#endif 


//#if 562802506 
private Set activationFigs;
//#endif 


//#if -1594657610 
@Deprecated
    FigLifeLine(int x, int y)
    { 

//#if 336629733 
super();
//#endif 


//#if -1904651134 
rect = new FigRect(x, y, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
//#endif 


//#if -628416851 
rect.setFilled(false);
//#endif 


//#if 1239155406 
rect.setLineWidth(0);
//#endif 


//#if 854359747 
line =
            new FigLine(x + WIDTH / 2, y, x + WIDTH / 2, HEIGHT, LINE_COLOR);
//#endif 


//#if 1698494001 
line.setLineWidth(LINE_WIDTH);
//#endif 


//#if -1319829015 
line.setDashed(true);
//#endif 


//#if 852198677 
addFig(rect);
//#endif 


//#if 684431141 
addFig(line);
//#endif 


//#if 1408013396 
activationFigs = new HashSet();
//#endif 

} 

//#endif 


//#if 1412094985 
final void addActivationFig(Fig f)
    { 

//#if -710113870 
addFig(f);
//#endif 


//#if 43718503 
activationFigs.add(f);
//#endif 

} 

//#endif 


//#if -1819293323 
public void calcBounds()
    { 

//#if -1720022013 
_x = rect.getX();
//#endif 


//#if 2069416449 
_y = rect.getY();
//#endif 


//#if -1417553578 
_w = rect.getWidth();
//#endif 


//#if 1521029442 
_h = rect.getHeight();
//#endif 


//#if 1949984781 
firePropChange("bounds", null, null);
//#endif 

} 

//#endif 


//#if -111296351 
final int getYCoordinate(int nodeIndex)
    { 

//#if 456169665 
return
            nodeIndex * SequenceDiagramLayer.LINK_DISTANCE
            + getY()
            + SequenceDiagramLayer.LINK_DISTANCE / 2;
//#endif 

} 

//#endif 


//#if 626465482 
public Dimension getMinimumSize()
    { 

//#if 759438395 
return new Dimension(20, 100);
//#endif 

} 

//#endif 


//#if -1440546422 
final FigMessagePort createFigMessagePort(Object message, TempFig tempFig)
    { 

//#if -1529575508 
final MessageNode node = (MessageNode) tempFig.getOwner();
//#endif 


//#if -142434004 
final FigMessagePort fmp =
            new FigMessagePort(message, tempFig.getX1(), tempFig.getY1(),
                               tempFig.getX2());
//#endif 


//#if -255611360 
node.setFigMessagePort(fmp);
//#endif 


//#if -1701211824 
fmp.setNode(node);
//#endif 


//#if 749595241 
addFig(fmp);
//#endif 


//#if -807734411 
return fmp;
//#endif 

} 

//#endif 


//#if 667398662 
public void setBoundsImpl(int x, int y, int w, int h)
    { 

//#if 124112325 
rect.setBounds(x, y, WIDTH, h);
//#endif 


//#if -1953024658 
line.setLocation(x + w / 2, y);
//#endif 


//#if -1228934710 
for (Iterator figIt = getFigs().iterator(); figIt.hasNext();) //1
{ 

//#if 94532593 
Fig fig = (Fig) figIt.next();
//#endif 


//#if 738974449 
if(activationFigs.contains(fig))//1
{ 

//#if -394961394 
fig.setLocation(getX(), y - getY() + fig.getY());
//#endif 

} 

//#endif 


//#if -353942280 
if(fig instanceof FigMessagePort)//1
{ 

//#if 1595674823 
fig.setLocation(getX(), y - getY() + fig.getY());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1795818109 
calcBounds();
//#endif 

} 

//#endif 


//#if 2102774731 
public final void removeFig(Fig f)
    { 

//#if -2090508958 
LOG.info("Removing " + f.getClass().getName());
//#endif 


//#if 1131769736 
super.removeFig(f);
//#endif 


//#if -875168632 
activationFigs.remove(f);
//#endif 

} 

//#endif 


//#if 623358835 
public DefaultHandler getHandler(HandlerStack stack,
                                     Object container,
                                     String uri,
                                     String localname,
                                     String qname,
                                     Attributes attributes)
    throws SAXException
    { 

//#if 1259377978 
PGMLStackParser parser = (PGMLStackParser) stack;
//#endif 


//#if 829725622 
StringTokenizer st =
            new StringTokenizer(attributes.getValue("description"), ",;[] ");
//#endif 


//#if 628968737 
if(st.hasMoreElements())//1
{ 

//#if 985197971 
st.nextToken();
//#endif 

} 

//#endif 


//#if -619378131 
String xStr = null;
//#endif 


//#if -815891636 
String yStr = null;
//#endif 


//#if -422864626 
String wStr = null;
//#endif 


//#if -1770129347 
String hStr = null;
//#endif 


//#if -1334592016 
if(st.hasMoreElements())//2
{ 

//#if 1555966641 
xStr = st.nextToken();
//#endif 


//#if 1147142416 
yStr = st.nextToken();
//#endif 


//#if 1964790866 
wStr = st.nextToken();
//#endif 


//#if -492780351 
hStr = st.nextToken();
//#endif 

} 

//#endif 


//#if -751661225 
if(xStr != null && !xStr.equals(""))//1
{ 

//#if -185141893 
int x = Integer.parseInt(xStr);
//#endif 


//#if 2061245211 
int y = Integer.parseInt(yStr);
//#endif 


//#if 1863438299 
int w = Integer.parseInt(wStr);
//#endif 


//#if -1767597189 
int h = Integer.parseInt(hStr);
//#endif 


//#if -234432059 
setBounds(x, y, w, h);
//#endif 

} 

//#endif 


//#if -1234981491 
PGMLStackParser.setCommonAttrs(this, attributes);
//#endif 


//#if -1896458179 
String ownerRef = attributes.getValue("href");
//#endif 


//#if 1290556458 
if(ownerRef != null)//1
{ 

//#if 744171155 
Object owner = parser.findOwner(ownerRef);
//#endif 


//#if 1516505158 
if(owner != null)//1
{ 

//#if 1386344559 
setOwner(owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1859477364 
parser.registerFig(this, attributes.getValue("name"));
//#endif 


//#if -1877525686 
((Container) container).addObject(this);
//#endif 


//#if 1912630895 
return new FigLifeLineHandler(parser, this);
//#endif 

} 

//#endif 


//#if 1507800381 
final void removeActivations()
    { 

//#if -753123067 
List activations = new ArrayList(activationFigs);
//#endif 


//#if -1945147567 
activationFigs.clear();
//#endif 


//#if 2012648509 
for (Iterator it = activations.iterator(); it.hasNext();) //1
{ 

//#if -978006843 
removeFig((Fig) it.next());
//#endif 

} 

//#endif 


//#if -769539029 
calcBounds();
//#endif 

} 

//#endif 


//#if 2020873907 
static class FigLifeLineHandler extends 
//#if -330969497 
FigGroupHandler
//#endif 

  { 

//#if -21279339 
protected DefaultHandler getElementHandler(
            HandlerStack stack,
            Object container,
            String uri,
            String localname,
            String qname,
            Attributes attributes) throws SAXException
        { 

//#if -1286815250 
DefaultHandler result = null;
//#endif 


//#if 1063873857 
String description = attributes.getValue("description");
//#endif 


//#if 799553198 
if(qname.equals("group")
                    && description != null
                    && description.startsWith(FigMessagePort.class.getName()))//1
{ 

//#if 381161317 
PGMLStackParser parser = (PGMLStackParser) stack;
//#endif 


//#if -2080612056 
String ownerRef = attributes.getValue("href");
//#endif 


//#if 1265882949 
Object owner = parser.findOwner(ownerRef);
//#endif 


//#if -222437560 
FigMessagePort fmp = new FigMessagePort(owner);
//#endif 


//#if 390329597 
((FigGroupHandler) container).getFigGroup().addFig(fmp);
//#endif 


//#if 72286129 
result = new FigGroupHandler((PGMLStackParser) stack, fmp);
//#endif 


//#if -1816434367 
PGMLStackParser.setCommonAttrs(fmp, attributes);
//#endif 


//#if 300156056 
parser.registerFig(fmp, attributes.getValue("name"));
//#endif 

} 
else
{ 

//#if -1428514917 
result = new UnknownHandler(stack);
//#endif 

} 

//#endif 


//#if -1669294275 
return result;
//#endif 

} 

//#endif 


//#if -675640917 
FigLifeLineHandler(PGMLStackParser parser,
                           FigLifeLine lifeLine)
        { 

//#if 1576813687 
super(parser, lifeLine);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

