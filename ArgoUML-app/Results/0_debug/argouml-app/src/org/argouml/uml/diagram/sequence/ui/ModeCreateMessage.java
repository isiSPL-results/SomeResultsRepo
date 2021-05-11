
//#if 773359048 
// Compilation Unit of /ModeCreateMessage.java 
 

//#if 408722562 
package org.argouml.uml.diagram.sequence.ui;
//#endif 


//#if 1067793598 
import java.awt.Cursor;
//#endif 


//#if 539357298 
import java.awt.Point;
//#endif 


//#if 967495275 
import java.awt.event.MouseEvent;
//#endif 


//#if -2140437322 
import org.apache.log4j.Logger;
//#endif 


//#if -125666333 
import org.argouml.i18n.Translator;
//#endif 


//#if -292900823 
import org.argouml.model.Model;
//#endif 


//#if -350157028 
import org.tigris.gef.base.Editor;
//#endif 


//#if -114487267 
import org.tigris.gef.base.Globals;
//#endif 


//#if -327072950 
import org.tigris.gef.base.ModeCreate;
//#endif 


//#if -2138722731 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 1592959813 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 1218359584 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1966992116 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if 1816541673 
public class ModeCreateMessage extends 
//#if 1978581515 
ModeCreate
//#endif 

  { 

//#if -2118444770 
private static final Logger LOG =
        Logger.getLogger(ModeCreateMessage.class);
//#endif 


//#if 1214652110 
private Object startPort;
//#endif 


//#if 808953741 
private Fig startPortFig;
//#endif 


//#if 306691135 
private FigClassifierRole sourceFigClassifierRole;
//#endif 


//#if -1612249910 
private Object message;
//#endif 


//#if 2139432883 
private static final long serialVersionUID = 6004200950886660909L;
//#endif 


//#if -304502484 
public String instructions()
    { 

//#if -1259558041 
return Translator.localize("action.sequence.new."
                                   + getArg("actionName"));
//#endif 

} 

//#endif 


//#if -260144678 
public void mousePressed(MouseEvent me)
    { 

//#if -2023862831 
if(me.isConsumed())//1
{ 

//#if -396680462 
return;
//#endif 

} 

//#endif 


//#if 1827876737 
int x = me.getX(), y = me.getY();
//#endif 


//#if -442410610 
Editor ce = Globals.curEditor();
//#endif 


//#if 2050564141 
Fig underMouse = ce.hit(x, y);
//#endif 


//#if 1584871196 
if(underMouse == null)//1
{ 

//#if -1429242700 
underMouse = ce.hit(x - 16, y - 16, 32, 32);
//#endif 

} 

//#endif 


//#if 322391573 
if(underMouse == null)//2
{ 

//#if 732247563 
done();
//#endif 


//#if 1695732519 
me.consume();
//#endif 


//#if -7803266 
return;
//#endif 

} 

//#endif 


//#if 296413846 
if(!(underMouse instanceof FigClassifierRole))//1
{ 

//#if -176573957 
done();
//#endif 


//#if -1237935337 
me.consume();
//#endif 


//#if -916624786 
return;
//#endif 

} 

//#endif 


//#if 960684288 
sourceFigClassifierRole = (FigClassifierRole) underMouse;
//#endif 


//#if 928599236 
startPort = sourceFigClassifierRole.deepHitPort(x, y);
//#endif 


//#if -927763470 
if(startPort == null)//1
{ 

//#if 947395154 
done();
//#endif 


//#if -989518290 
me.consume();
//#endif 


//#if 207344325 
return;
//#endif 

} 

//#endif 


//#if -743183175 
startPortFig = sourceFigClassifierRole.getPortFig(startPort);
//#endif 


//#if -385218557 
start();
//#endif 


//#if -619433632 
Point snapPt = new Point();
//#endif 


//#if 333361887 
synchronized (snapPt) //1
{ 

//#if 1945221072 
snapPt.setLocation(
                startPortFig.getX() + FigClassifierRole.ROLE_WIDTH / 2,
                startPortFig.getY());
//#endif 


//#if 398884675 
editor.snap(snapPt);
//#endif 


//#if 39021219 
anchorX = snapPt.x;
//#endif 


//#if -1757930109 
anchorY = snapPt.y;
//#endif 

} 

//#endif 


//#if -2142405560 
_newItem = createNewItem(me, anchorX, anchorY);
//#endif 


//#if 179454601 
me.consume();
//#endif 


//#if -911997437 
setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
//#endif 

} 

//#endif 


//#if 1174098989 
public void mouseReleased(MouseEvent me)
    { 

//#if 2061525227 
if(me.isConsumed())//1
{ 

//#if 833649802 
return;
//#endif 

} 

//#endif 


//#if -1892126263 
if(sourceFigClassifierRole == null)//1
{ 

//#if 587380444 
done();
//#endif 


//#if -263802056 
me.consume();
//#endif 


//#if -152670385 
return;
//#endif 

} 

//#endif 


//#if -215810905 
int x = me.getX(), y = me.getY();
//#endif 


//#if -1626180300 
Editor ce = Globals.curEditor();
//#endif 


//#if 1996655500 
Fig f = ce.hit(x, y);
//#endif 


//#if 363401647 
if(f == null)//1
{ 

//#if -692601532 
f = ce.hit(x - 16, y - 16, 32, 32);
//#endif 

} 

//#endif 


//#if 1452863518 
GraphModel gm = ce.getGraphModel();
//#endif 


//#if 1353076431 
if(!(gm instanceof MutableGraphModel))//1
{ 

//#if -1160903950 
f = null;
//#endif 

} 

//#endif 


//#if -420089173 
MutableGraphModel mgm = (MutableGraphModel) gm;
//#endif 


//#if 81717015 
if(f instanceof FigClassifierRole)//1
{ 

//#if 748218593 
FigClassifierRole destFigClassifierRole = (FigClassifierRole) f;
//#endif 


//#if -1970755258 
Object foundPort = null;
//#endif 


//#if -1461635031 
if(destFigClassifierRole != sourceFigClassifierRole)//1
{ 

//#if 107851320 
y = startPortFig.getY();
//#endif 


//#if -1345867810 
foundPort = destFigClassifierRole.deepHitPort(x, y);
//#endif 

} 
else
{ 

//#if 1063312194 
foundPort = destFigClassifierRole.deepHitPort(x, y);
//#endif 

} 

//#endif 


//#if -1998667044 
if(foundPort != null && foundPort != startPort)//1
{ 

//#if 1076192065 
Fig destPortFig = destFigClassifierRole.getPortFig(foundPort);
//#endif 


//#if -486944616 
Object edgeType = Model.getMetaTypes().getMessage();
//#endif 


//#if -159360200 
message = mgm.connect(startPort, foundPort, edgeType);
//#endif 


//#if -1322827121 
if(null != message)//1
{ 

//#if -417822878 
ce.damaged(_newItem);
//#endif 


//#if -1263620998 
sourceFigClassifierRole.damage();
//#endif 


//#if -770945837 
destFigClassifierRole.damage();
//#endif 


//#if -1324381618 
_newItem = null;
//#endif 


//#if 212074809 
FigMessage fe =
                        (FigMessage) ce.getLayerManager()
                        .getActiveLayer().presentationFor(message);
//#endif 


//#if -727176951 
fe.setSourcePortFig(startPortFig);
//#endif 


//#if 1896033151 
fe.setSourceFigNode(sourceFigClassifierRole);
//#endif 


//#if 1233212470 
fe.setDestPortFig(destPortFig);
//#endif 


//#if -1161483279 
fe.setDestFigNode(destFigClassifierRole);
//#endif 


//#if 876284675 
if(sourceFigClassifierRole != null)//1
{ 

//#if -1230526472 
sourceFigClassifierRole.updateEdges();
//#endif 

} 

//#endif 


//#if 98559516 
if(destFigClassifierRole != null)//1
{ 

//#if -746868827 
destFigClassifierRole.updateEdges();
//#endif 

} 

//#endif 


//#if 1832508434 
if(fe != null)//1
{ 

//#if 1910093905 
ce.getSelectionManager().select(fe);
//#endif 

} 

//#endif 


//#if 249206197 
done();
//#endif 


//#if -580367535 
me.consume();
//#endif 


//#if -490844632 
return;
//#endif 

} 
else
{ 

//#if -1666833610 
LOG.debug("connection return null");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -665079720 
sourceFigClassifierRole.damage();
//#endif 


//#if -701110208 
ce.damaged(_newItem);
//#endif 


//#if 531646256 
_newItem = null;
//#endif 


//#if -1247956205 
done();
//#endif 


//#if -1490326993 
me.consume();
//#endif 

} 

//#endif 


//#if 601651018 
public void mouseDragged(MouseEvent me)
    { 

//#if 129103598 
if(me.isConsumed())//1
{ 

//#if -1470148038 
return;
//#endif 

} 

//#endif 


//#if 1600266530 
if(_newItem != null)//1
{ 

//#if 636294102 
editor.damaged(_newItem);
//#endif 


//#if 1993092799 
creationDrag(me.getX(), startPortFig.getY());
//#endif 


//#if 2146962108 
editor.damaged(_newItem);
//#endif 


//#if -572605398 
editor.scrollToShow(me.getX(), startPortFig.getY());
//#endif 


//#if -445914192 
me.consume();
//#endif 

} 
else
{ 

//#if -270394592 
super.mouseDragged(me);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -866029110 
public ModeCreateMessage(Editor par)
    { 

//#if 971859813 
super(par);
//#endif 

} 

//#endif 


//#if 1247672027 
public Fig createNewItem(MouseEvent me, int snapX, int snapY)
    { 

//#if -1491205436 
return new FigLine(
                   snapX,
                   snapY,
                   me.getX(),
                   snapY,
                   Globals.getPrefs().getRubberbandColor());
//#endif 

} 

//#endif 


//#if 1353201012 
public ModeCreateMessage()
    { 

//#if -1198613505 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

