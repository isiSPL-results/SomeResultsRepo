// Compilation Unit of /FigLifeLine.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.argouml.uml.diagram.sequence.MessageNode;
import org.argouml.uml.diagram.sequence.ui.FigClassifierRole.TempFig;
import org.argouml.uml.diagram.ui.ArgoFigGroup;
import org.tigris.gef.persistence.pgml.Container;
import org.tigris.gef.persistence.pgml.FigGroupHandler;
import org.tigris.gef.persistence.pgml.HandlerFactory;
import org.tigris.gef.persistence.pgml.HandlerStack;
import org.tigris.gef.persistence.pgml.PGMLStackParser;
import org.tigris.gef.persistence.pgml.UnknownHandler;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
import org.tigris.gef.presentation.FigRect;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
class FigLifeLine extends ArgoFigGroup
 implements HandlerFactory
  { 
private static final long serialVersionUID = -1242239243040698287L;
private static final Logger LOG = Logger.getLogger(FigLifeLine.class);
static final int WIDTH = 20;
static final int HEIGHT = 1000;
private FigRect rect;
private FigLine line;
private Set activationFigs;
@Deprecated
    FigLifeLine(int x, int y)
    { 
super();
rect = new FigRect(x, y, WIDTH, HEIGHT, LINE_COLOR, FILL_COLOR);
rect.setFilled(false);
rect.setLineWidth(0);
line =
            new FigLine(x + WIDTH / 2, y, x + WIDTH / 2, HEIGHT, LINE_COLOR);
line.setLineWidth(LINE_WIDTH);
line.setDashed(true);
addFig(rect);
addFig(line);
activationFigs = new HashSet();
} 

final void addActivationFig(Fig f)
    { 
addFig(f);
activationFigs.add(f);
} 

public void calcBounds()
    { 
_x = rect.getX();
_y = rect.getY();
_w = rect.getWidth();
_h = rect.getHeight();
firePropChange("bounds", null, null);
} 

final int getYCoordinate(int nodeIndex)
    { 
return
            nodeIndex * SequenceDiagramLayer.LINK_DISTANCE
            + getY()
            + SequenceDiagramLayer.LINK_DISTANCE / 2;
} 

public Dimension getMinimumSize()
    { 
return new Dimension(20, 100);
} 

final FigMessagePort createFigMessagePort(Object message, TempFig tempFig)
    { 
final MessageNode node = (MessageNode) tempFig.getOwner();
final FigMessagePort fmp =
            new FigMessagePort(message, tempFig.getX1(), tempFig.getY1(),
                               tempFig.getX2());
node.setFigMessagePort(fmp);
fmp.setNode(node);
addFig(fmp);
return fmp;
} 

public void setBoundsImpl(int x, int y, int w, int h)
    { 
rect.setBounds(x, y, WIDTH, h);
line.setLocation(x + w / 2, y);
for (Iterator figIt = getFigs().iterator(); figIt.hasNext();) //1
{ 
Fig fig = (Fig) figIt.next();
if(activationFigs.contains(fig))//1
{ 
fig.setLocation(getX(), y - getY() + fig.getY());
} 

if(fig instanceof FigMessagePort)//1
{ 
fig.setLocation(getX(), y - getY() + fig.getY());
} 

} 

calcBounds();
} 

public final void removeFig(Fig f)
    { 
LOG.info("Removing " + f.getClass().getName());
super.removeFig(f);
activationFigs.remove(f);
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
String ownerRef = attributes.getValue("href");
if(ownerRef != null)//1
{ 
Object owner = parser.findOwner(ownerRef);
if(owner != null)//1
{ 
setOwner(owner);
} 

} 

parser.registerFig(this, attributes.getValue("name"));
((Container) container).addObject(this);
return new FigLifeLineHandler(parser, this);
} 

final void removeActivations()
    { 
List activations = new ArrayList(activationFigs);
activationFigs.clear();
for (Iterator it = activations.iterator(); it.hasNext();) //1
{ 
removeFig((Fig) it.next());
} 

calcBounds();
} 

static class FigLifeLineHandler extends FigGroupHandler
  { 
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
                    && description.startsWith(FigMessagePort.class.getName()))//1
{ 
PGMLStackParser parser = (PGMLStackParser) stack;
String ownerRef = attributes.getValue("href");
Object owner = parser.findOwner(ownerRef);
FigMessagePort fmp = new FigMessagePort(owner);
((FigGroupHandler) container).getFigGroup().addFig(fmp);
result = new FigGroupHandler((PGMLStackParser) stack, fmp);
PGMLStackParser.setCommonAttrs(fmp, attributes);
parser.registerFig(fmp, attributes.getValue("name"));
} 
else
{ 
result = new UnknownHandler(stack);
} 

return result;
} 

FigLifeLineHandler(PGMLStackParser parser,
                           FigLifeLine lifeLine)
        { 
super(parser, lifeLine);
} 

 } 

 } 


