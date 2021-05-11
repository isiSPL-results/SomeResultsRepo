package org.argouml.uml.diagram.sequence.ui;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.ModeCreate;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigLine;
public class ModeCreateMessage extends ModeCreate
  { 
private static final Logger LOG =
        Logger.getLogger(ModeCreateMessage.class);
private Object startPort;
private Fig startPortFig;
private FigClassifierRole sourceFigClassifierRole;
private Object message;
private static final long serialVersionUID = 6004200950886660909L;
public String instructions()
    { 
return Translator.localize("action.sequence.new."
                                   + getArg("actionName"));
} 
public void mousePressed(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 
int x = me.getX(), y = me.getY();
Editor ce = Globals.curEditor();
Fig underMouse = ce.hit(x, y);
if(underMouse == null)//1
{ 
underMouse = ce.hit(x - 16, y - 16, 32, 32);
} 
if(underMouse == null)//2
{ 
done();
me.consume();
return;
} 
if(!(underMouse instanceof FigClassifierRole))//1
{ 
done();
me.consume();
return;
} 
sourceFigClassifierRole = (FigClassifierRole) underMouse;
startPort = sourceFigClassifierRole.deepHitPort(x, y);
if(startPort == null)//1
{ 
done();
me.consume();
return;
} 
startPortFig = sourceFigClassifierRole.getPortFig(startPort);
start();
Point snapPt = new Point();
synchronized (snapPt) //1
{ 
snapPt.setLocation(
                startPortFig.getX() + FigClassifierRole.ROLE_WIDTH / 2,
                startPortFig.getY());
editor.snap(snapPt);
anchorX = snapPt.x;
anchorY = snapPt.y;
} 
_newItem = createNewItem(me, anchorX, anchorY);
me.consume();
setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
} 
public void mouseReleased(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 
if(sourceFigClassifierRole == null)//1
{ 
done();
me.consume();
return;
} 
int x = me.getX(), y = me.getY();
Editor ce = Globals.curEditor();
Fig f = ce.hit(x, y);
if(f == null)//1
{ 
f = ce.hit(x - 16, y - 16, 32, 32);
} 
GraphModel gm = ce.getGraphModel();
if(!(gm instanceof MutableGraphModel))//1
{ 
f = null;
} 
MutableGraphModel mgm = (MutableGraphModel) gm;
if(f instanceof FigClassifierRole)//1
{ 
FigClassifierRole destFigClassifierRole = (FigClassifierRole) f;
Object foundPort = null;
if(destFigClassifierRole != sourceFigClassifierRole)//1
{ 
y = startPortFig.getY();
foundPort = destFigClassifierRole.deepHitPort(x, y);
} 
else
{ 
foundPort = destFigClassifierRole.deepHitPort(x, y);
} 
if(foundPort != null && foundPort != startPort)//1
{ 
Fig destPortFig = destFigClassifierRole.getPortFig(foundPort);
Object edgeType = Model.getMetaTypes().getMessage();
message = mgm.connect(startPort, foundPort, edgeType);
if(null != message)//1
{ 
ce.damaged(_newItem);
sourceFigClassifierRole.damage();
destFigClassifierRole.damage();
_newItem = null;
FigMessage fe =
                        (FigMessage) ce.getLayerManager()
                        .getActiveLayer().presentationFor(message);
fe.setSourcePortFig(startPortFig);
fe.setSourceFigNode(sourceFigClassifierRole);
fe.setDestPortFig(destPortFig);
fe.setDestFigNode(destFigClassifierRole);
if(sourceFigClassifierRole != null)//1
{ 
sourceFigClassifierRole.updateEdges();
} 
if(destFigClassifierRole != null)//1
{ 
destFigClassifierRole.updateEdges();
} 
if(fe != null)//1
{ 
ce.getSelectionManager().select(fe);
} 
done();
me.consume();
return;
} 
else
{ 
LOG.debug("connection return null");
} 
} 
} 
sourceFigClassifierRole.damage();
ce.damaged(_newItem);
_newItem = null;
done();
me.consume();
} 
public void mouseDragged(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 
if(_newItem != null)//1
{ 
editor.damaged(_newItem);
creationDrag(me.getX(), startPortFig.getY());
editor.damaged(_newItem);
editor.scrollToShow(me.getX(), startPortFig.getY());
me.consume();
} 
else
{ 
super.mouseDragged(me);
} 
} 
public ModeCreateMessage(Editor par)
    { 
super(par);
} 
public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 
return new FigLine(
                   snapX,
                   snapY,
                   me.getX(),
                   snapY,
                   Globals.getPrefs().getRubberbandColor());
} 
public ModeCreateMessage()
    { 
super();
} 

 } 
