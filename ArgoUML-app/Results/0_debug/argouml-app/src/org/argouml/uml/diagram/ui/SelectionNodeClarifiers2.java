
//#if 1890102833 
// Compilation Unit of /SelectionNodeClarifiers2.java 
 

//#if 971179218 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1285080924 
import java.awt.Graphics;
//#endif 


//#if -706745888 
import java.awt.Rectangle;
//#endif 


//#if -1202274990 
import javax.swing.Icon;
//#endif 


//#if -448888855 
import org.apache.log4j.Logger;
//#endif 


//#if -281060599 
import org.tigris.gef.base.Editor;
//#endif 


//#if 2027502032 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1629762643 
import org.tigris.gef.base.Mode;
//#endif 


//#if 1152160227 
import org.tigris.gef.base.ModeCreateEdgeAndNode;
//#endif 


//#if 1405668150 
import org.tigris.gef.base.ModeManager;
//#endif 


//#if 1545533625 
import org.tigris.gef.base.ModeModify;
//#endif 


//#if 687066908 
import org.tigris.gef.base.ModePlace;
//#endif 


//#if -706100383 
import org.tigris.gef.base.SelectionButtons;
//#endif 


//#if 525170869 
import org.tigris.gef.base.SelectionManager;
//#endif 


//#if 1887009714 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 1575536979 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1076731761 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1321669385 
import org.tigris.gef.presentation.Handle;
//#endif 


//#if 1759895450 
public abstract class SelectionNodeClarifiers2 extends 
//#if 896263738 
SelectionButtons
//#endif 

  { 

//#if -2055828167 
private static final Logger LOG =
        Logger.getLogger(SelectionNodeClarifiers2.class);
//#endif 


//#if -732132384 
protected static final int BASE = 10;
//#endif 


//#if 1940314212 
protected static final int TOP = 10;
//#endif 


//#if -322084263 
protected static final int BOTTOM = 11;
//#endif 


//#if -1587176876 
protected static final int LEFT = 12;
//#endif 


//#if -970809848 
protected static final int RIGHT = 13;
//#endif 


//#if -4730320 
protected static final int LOWER_LEFT = 14;
//#endif 


//#if -724675922 
private static final int OFFSET = 2;
//#endif 


//#if 1982427416 
private int button;
//#endif 


//#if -114101508 
protected Object createEdgeUnder(MutableGraphModel gm, Object newNode)
    { 

//#if -81581345 
return createEdge(gm, newNode, BOTTOM);
//#endif 

} 

//#endif 


//#if 223722146 
protected Object createEdgeToSelf(MutableGraphModel gm)
    { 

//#if 815491206 
Object edge = gm.connect(
                          getContent().getOwner(), getContent().getOwner(),
                          getNewEdgeType(LOWER_LEFT));
//#endif 


//#if -1235499004 
return edge;
//#endif 

} 

//#endif 


//#if -1019003125 
protected Object createEdgeLeft(MutableGraphModel gm, Object newNode)
    { 

//#if 88001245 
return createEdge(gm, newNode, LEFT);
//#endif 

} 

//#endif 


//#if -420046113 
public void hitHandle(Rectangle cursor, Handle h)
    { 

//#if 552407387 
super.hitHandle(cursor, h);
//#endif 


//#if -1395986944 
if(h.index != -1)//1
{ 

//#if -39740845 
return;
//#endif 

} 

//#endif 


//#if -1882407357 
if(!isPaintButtons())//1
{ 

//#if 642231803 
return;
//#endif 

} 

//#endif 


//#if 216030561 
Icon[] icons = getIcons();
//#endif 


//#if 44213141 
if(icons == null)//1
{ 

//#if 1565787758 
return;
//#endif 

} 

//#endif 


//#if 2016818370 
Editor ce = Globals.curEditor();
//#endif 


//#if 325449092 
SelectionManager sm = ce.getSelectionManager();
//#endif 


//#if 460624539 
if(sm.size() != 1)//1
{ 

//#if -906143565 
return;
//#endif 

} 

//#endif 


//#if 1465730372 
ModeManager mm = ce.getModeManager();
//#endif 


//#if -1686008598 
if(mm.includes(ModeModify.class) && getPressedButton() == -1)//1
{ 

//#if -1746834806 
return;
//#endif 

} 

//#endif 


//#if -236433570 
int cx = getContent().getX();
//#endif 


//#if 2020507228 
int cy = getContent().getY();
//#endif 


//#if -1995373007 
int cw = getContent().getWidth();
//#endif 


//#if -532988217 
int ch = getContent().getHeight();
//#endif 


//#if -30545992 
if(icons[0] != null && hitAbove(cx + cw / 2, cy,
                                         icons[0].getIconWidth(), icons[0].getIconHeight(),
                                         cursor))//1
{ 

//#if -1617296998 
h.index = TOP;
//#endif 

} 
else

//#if 1171866494 
if(icons[1] != null && hitBelow(cx + cw / 2, cy + ch,
                                                icons[1].getIconWidth(), icons[1].getIconHeight(),
                                                cursor))//1
{ 

//#if -492909000 
h.index = BOTTOM;
//#endif 

} 
else

//#if 2138747557 
if(icons[2] != null && hitLeft(cx, cy + ch / 2,
                                               icons[2].getIconWidth(), icons[2].getIconHeight(),
                                               cursor))//1
{ 

//#if -35578370 
h.index = LEFT;
//#endif 

} 
else

//#if -1429832756 
if(icons[3] != null && hitRight(cx + cw, cy + ch / 2,
                                                icons[3].getIconWidth(), icons[3].getIconHeight(),
                                                cursor))//1
{ 

//#if -1335561714 
h.index = RIGHT;
//#endif 

} 
else

//#if -1193705587 
if(icons[4] != null && hitLeft(cx, cy + ch,
                                               icons[4].getIconWidth(), icons[4].getIconHeight(),
                                               cursor))//1
{ 

//#if 550890224 
h.index = LOWER_LEFT;
//#endif 

} 
else
{ 

//#if 1536230448 
h.index = -1;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 158062180 
if(h.index == -1)//1
{ 

//#if -545788147 
h.instructions = getInstructions(15);
//#endif 

} 
else
{ 

//#if 1829408939 
h.instructions = getInstructions(h.index);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1545858141 
protected abstract String getInstructions(int index);
//#endif 


//#if -327336730 
private Object createEdge(MutableGraphModel gm, Object newNode, int index)
    { 

//#if 1354571565 
Object edge;
//#endif 


//#if -1645474517 
if(isReverseEdge(index))//1
{ 

//#if 2098644758 
edge = gm.connect(
                       newNode, getContent().getOwner(), getNewEdgeType(index));
//#endif 

} 
else
{ 

//#if -1641563524 
edge = gm.connect(
                       getContent().getOwner(), newNode, getNewEdgeType(index));
//#endif 

} 

//#endif 


//#if -522359812 
return edge;
//#endif 

} 

//#endif 


//#if 69442610 
@Override
    public void buttonClicked(int buttonCode)
    { 

//#if -1176432968 
super.buttonClicked(buttonCode);
//#endif 

} 

//#endif 


//#if -1489622327 
protected abstract Object getNewEdgeType(int index);
//#endif 


//#if 1148584027 
@Override
    public void paint(Graphics g)
    { 

//#if -948034911 
final Mode topMode = Globals.curEditor().getModeManager().top();
//#endif 


//#if 710918398 
if(!(topMode instanceof ModePlace))//1
{ 

//#if -1273880678 
((Clarifiable) getContent()).paintClarifiers(g);
//#endif 

} 

//#endif 


//#if -603565027 
super.paint(g);
//#endif 

} 

//#endif 


//#if -684895866 
public void dragHandle(int mX, int mY, int anX, int anY, Handle hand)
    { 

//#if -208606683 
mX = Math.max(mX, 0);
//#endif 


//#if 1145626535 
mY = Math.max(mY, 0);
//#endif 


//#if 412012305 
if(hand.index < 10)//1
{ 

//#if 1722552358 
setPaintButtons(false);
//#endif 


//#if -274548690 
super.dragHandle(mX, mY, anX, anY, hand);
//#endif 


//#if 1889381119 
return;
//#endif 

} 

//#endif 


//#if 416711519 
if(!isDraggableHandle(hand.index))//1
{ 

//#if 1455863243 
return;
//#endif 

} 

//#endif 


//#if 2033759088 
int cx = getContent().getX(), cy = getContent().getY();
//#endif 


//#if -1454813178 
int cw = getContent().getWidth(), ch = getContent().getHeight();
//#endif 


//#if -756377306 
int bx = mX, by = mY;
//#endif 


//#if 766110665 
button = hand.index;
//#endif 


//#if 1234960325 
switch (hand.index) //1
{ 
case TOP://1


//#if 1278727192 
by = cy;
//#endif 


//#if 1806543452 
bx = cx + cw / 2;
//#endif 


//#if 1273451829 
break;

//#endif 


case BOTTOM://1


//#if 718428431 
by = cy + ch;
//#endif 


//#if -1770565699 
bx = cx + cw / 2;
//#endif 


//#if -841869516 
break;

//#endif 


case LEFT://1


//#if 851116682 
by = cy + ch / 2;
//#endif 


//#if 1551245241 
bx = cx;
//#endif 


//#if 1546893430 
break;

//#endif 


case RIGHT://1


//#if 525727502 
by = cy + ch / 2;
//#endif 


//#if -1354359934 
bx = cx + cw;
//#endif 


//#if -722796174 
break;

//#endif 


case LOWER_LEFT://1


//#if -933776738 
by = cy + ch;
//#endif 


//#if 1917658952 
bx = cx;
//#endif 


//#if 1913307141 
break;

//#endif 


default://1


//#if -389225373 
LOG.warn("invalid handle number");
//#endif 


//#if 1350568009 
break;

//#endif 


} 

//#endif 


//#if -2010260527 
Object nodeType = getNewNodeType(hand.index);
//#endif 


//#if -1045545679 
Object edgeType = getNewEdgeType(hand.index);
//#endif 


//#if 1980678063 
boolean reverse = isReverseEdge(hand.index);
//#endif 


//#if 1644795520 
if(edgeType != null && nodeType != null)//1
{ 

//#if -105204554 
Editor ce = Globals.curEditor();
//#endif 


//#if 1542851593 
ModeCreateEdgeAndNode m =
                new ModeCreateEdgeAndNode(ce,
                                          edgeType, isEdgePostProcessRequested(), this);
//#endif 


//#if -1513752699 
m.setup((FigNode) getContent(), getContent().getOwner(),
                    bx, by, reverse);
//#endif 


//#if -1467701475 
ce.pushMode(m);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1312951608 
protected Object createEdgeRight(MutableGraphModel gm, Object newNode)
    { 

//#if -596503247 
return createEdge(gm, newNode, RIGHT);
//#endif 

} 

//#endif 


//#if -991867997 
protected int getButton()
    { 

//#if -1954871632 
return button;
//#endif 

} 

//#endif 


//#if -2123071477 
protected abstract Icon[] getIcons();
//#endif 


//#if 16340150 
public final void paintButtons(Graphics g)
    { 

//#if -1519803729 
final Mode topMode = Globals.curEditor().getModeManager().top();
//#endif 


//#if 1449462540 
if(!(topMode instanceof ModePlace))//1
{ 

//#if 2067583369 
Icon[] icons = getIcons();
//#endif 


//#if 1871197805 
if(icons == null)//1
{ 

//#if -838716761 
return;
//#endif 

} 

//#endif 


//#if -891712970 
int cx = getContent().getX();
//#endif 


//#if 1365227828 
int cy = getContent().getY();
//#endif 


//#if -1095166711 
int cw = getContent().getWidth();
//#endif 


//#if 1603603183 
int ch = getContent().getHeight();
//#endif 


//#if 1463669141 
if(icons[0] != null)//1
{ 

//#if 1327724012 
paintButtonAbove(icons[0], g, cx + cw / 2, cy - OFFSET, TOP);
//#endif 

} 

//#endif 


//#if 1592751860 
if(icons[1] != null)//1
{ 

//#if 2023174995 
paintButtonBelow(icons[1], g, cx + cw / 2, cy + ch + OFFSET,
                                 BOTTOM);
//#endif 

} 

//#endif 


//#if 1721834579 
if(icons[2] != null)//1
{ 

//#if 1305731550 
paintButtonLeft(icons[2], g, cx - OFFSET, cy + ch / 2, LEFT);
//#endif 

} 

//#endif 


//#if 1850917298 
if(icons[3] != null)//1
{ 

//#if 249368291 
paintButtonRight(icons[3], g, cx + cw + OFFSET, cy + ch / 2,
                                 RIGHT);
//#endif 

} 

//#endif 


//#if 1980000017 
if(icons[4] != null)//1
{ 

//#if 842597892 
paintButtonLeft(icons[4], g, cx - OFFSET, cy + ch, LOWER_LEFT);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1659768398 
protected abstract Object getNewNodeType(int index);
//#endif 


//#if 1414296599 
protected Object createEdgeAbove(MutableGraphModel gm, Object newNode)
    { 

//#if -1353494882 
return createEdge(gm, newNode, TOP);
//#endif 

} 

//#endif 


//#if 1677408010 
protected boolean isDraggableHandle(int index)
    { 

//#if -300786860 
return true;
//#endif 

} 

//#endif 


//#if 2026472244 
protected Object getNewNode(int arg0)
    { 

//#if 17566249 
return null;
//#endif 

} 

//#endif 


//#if 1838677149 
public SelectionNodeClarifiers2(Fig f)
    { 

//#if -1456838999 
super(f);
//#endif 

} 

//#endif 


//#if -13707098 
protected boolean isEdgePostProcessRequested()
    { 

//#if 2104721043 
return false;
//#endif 

} 

//#endif 


//#if -1733359692 
protected boolean isReverseEdge(int index)
    { 

//#if -158237745 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

