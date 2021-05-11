// Compilation Unit of /SelectionNodeClarifiers2.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.Icon;
import org.apache.log4j.Logger;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Mode;
import org.tigris.gef.base.ModeCreateEdgeAndNode;
import org.tigris.gef.base.ModeManager;
import org.tigris.gef.base.ModeModify;
import org.tigris.gef.base.ModePlace;
import org.tigris.gef.base.SelectionButtons;
import org.tigris.gef.base.SelectionManager;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.presentation.Fig;
import org.tigris.gef.presentation.FigNode;
import org.tigris.gef.presentation.Handle;
public abstract class SelectionNodeClarifiers2 extends SelectionButtons
  { 
private static final Logger LOG =
        Logger.getLogger(SelectionNodeClarifiers2.class);
protected static final int BASE = 10;
protected static final int TOP = 10;
protected static final int BOTTOM = 11;
protected static final int LEFT = 12;
protected static final int RIGHT = 13;
protected static final int LOWER_LEFT = 14;
private static final int OFFSET = 2;
private int button;
protected Object createEdgeUnder(MutableGraphModel gm, Object newNode)
    { 
return createEdge(gm, newNode, BOTTOM);
} 

protected Object createEdgeToSelf(MutableGraphModel gm)
    { 
Object edge = gm.connect(
                          getContent().getOwner(), getContent().getOwner(),
                          getNewEdgeType(LOWER_LEFT));
return edge;
} 

protected Object createEdgeLeft(MutableGraphModel gm, Object newNode)
    { 
return createEdge(gm, newNode, LEFT);
} 

public void hitHandle(Rectangle cursor, Handle h)
    { 
super.hitHandle(cursor, h);
if(h.index != -1)//1
{ 
return;
} 

if(!isPaintButtons())//1
{ 
return;
} 

Icon[] icons = getIcons();
if(icons == null)//1
{ 
return;
} 

Editor ce = Globals.curEditor();
SelectionManager sm = ce.getSelectionManager();
if(sm.size() != 1)//1
{ 
return;
} 

ModeManager mm = ce.getModeManager();
if(mm.includes(ModeModify.class) && getPressedButton() == -1)//1
{ 
return;
} 

int cx = getContent().getX();
int cy = getContent().getY();
int cw = getContent().getWidth();
int ch = getContent().getHeight();
if(icons[0] != null && hitAbove(cx + cw / 2, cy,
                                         icons[0].getIconWidth(), icons[0].getIconHeight(),
                                         cursor))//1
{ 
h.index = TOP;
} 
else
if(icons[1] != null && hitBelow(cx + cw / 2, cy + ch,
                                                icons[1].getIconWidth(), icons[1].getIconHeight(),
                                                cursor))//1
{ 
h.index = BOTTOM;
} 
else
if(icons[2] != null && hitLeft(cx, cy + ch / 2,
                                               icons[2].getIconWidth(), icons[2].getIconHeight(),
                                               cursor))//1
{ 
h.index = LEFT;
} 
else
if(icons[3] != null && hitRight(cx + cw, cy + ch / 2,
                                                icons[3].getIconWidth(), icons[3].getIconHeight(),
                                                cursor))//1
{ 
h.index = RIGHT;
} 
else
if(icons[4] != null && hitLeft(cx, cy + ch,
                                               icons[4].getIconWidth(), icons[4].getIconHeight(),
                                               cursor))//1
{ 
h.index = LOWER_LEFT;
} 
else
{ 
h.index = -1;
} 





if(h.index == -1)//1
{ 
h.instructions = getInstructions(15);
} 
else
{ 
h.instructions = getInstructions(h.index);
} 

} 

protected abstract String getInstructions(int index);
private Object createEdge(MutableGraphModel gm, Object newNode, int index)
    { 
Object edge;
if(isReverseEdge(index))//1
{ 
edge = gm.connect(
                       newNode, getContent().getOwner(), getNewEdgeType(index));
} 
else
{ 
edge = gm.connect(
                       getContent().getOwner(), newNode, getNewEdgeType(index));
} 

return edge;
} 

@Override
    public void buttonClicked(int buttonCode)
    { 
super.buttonClicked(buttonCode);
} 

protected abstract Object getNewEdgeType(int index);
@Override
    public void paint(Graphics g)
    { 
final Mode topMode = Globals.curEditor().getModeManager().top();
if(!(topMode instanceof ModePlace))//1
{ 
((Clarifiable) getContent()).paintClarifiers(g);
} 

super.paint(g);
} 

public void dragHandle(int mX, int mY, int anX, int anY, Handle hand)
    { 
mX = Math.max(mX, 0);
mY = Math.max(mY, 0);
if(hand.index < 10)//1
{ 
setPaintButtons(false);
super.dragHandle(mX, mY, anX, anY, hand);
return;
} 

if(!isDraggableHandle(hand.index))//1
{ 
return;
} 

int cx = getContent().getX(), cy = getContent().getY();
int cw = getContent().getWidth(), ch = getContent().getHeight();
int bx = mX, by = mY;
button = hand.index;
switch (hand.index) //1
{ 
case TOP://1

by = cy;
bx = cx + cw / 2;
break;


case BOTTOM://1

by = cy + ch;
bx = cx + cw / 2;
break;


case LEFT://1

by = cy + ch / 2;
bx = cx;
break;


case RIGHT://1

by = cy + ch / 2;
bx = cx + cw;
break;


case LOWER_LEFT://1

by = cy + ch;
bx = cx;
break;


default://1

LOG.warn("invalid handle number");
break;


} 

Object nodeType = getNewNodeType(hand.index);
Object edgeType = getNewEdgeType(hand.index);
boolean reverse = isReverseEdge(hand.index);
if(edgeType != null && nodeType != null)//1
{ 
Editor ce = Globals.curEditor();
ModeCreateEdgeAndNode m =
                new ModeCreateEdgeAndNode(ce,
                                          edgeType, isEdgePostProcessRequested(), this);
m.setup((FigNode) getContent(), getContent().getOwner(),
                    bx, by, reverse);
ce.pushMode(m);
} 

} 

protected Object createEdgeRight(MutableGraphModel gm, Object newNode)
    { 
return createEdge(gm, newNode, RIGHT);
} 

protected int getButton()
    { 
return button;
} 

protected abstract Icon[] getIcons();
public final void paintButtons(Graphics g)
    { 
final Mode topMode = Globals.curEditor().getModeManager().top();
if(!(topMode instanceof ModePlace))//1
{ 
Icon[] icons = getIcons();
if(icons == null)//1
{ 
return;
} 

int cx = getContent().getX();
int cy = getContent().getY();
int cw = getContent().getWidth();
int ch = getContent().getHeight();
if(icons[0] != null)//1
{ 
paintButtonAbove(icons[0], g, cx + cw / 2, cy - OFFSET, TOP);
} 

if(icons[1] != null)//1
{ 
paintButtonBelow(icons[1], g, cx + cw / 2, cy + ch + OFFSET,
                                 BOTTOM);
} 

if(icons[2] != null)//1
{ 
paintButtonLeft(icons[2], g, cx - OFFSET, cy + ch / 2, LEFT);
} 

if(icons[3] != null)//1
{ 
paintButtonRight(icons[3], g, cx + cw + OFFSET, cy + ch / 2,
                                 RIGHT);
} 

if(icons[4] != null)//1
{ 
paintButtonLeft(icons[4], g, cx - OFFSET, cy + ch, LOWER_LEFT);
} 

} 

} 

protected abstract Object getNewNodeType(int index);
protected Object createEdgeAbove(MutableGraphModel gm, Object newNode)
    { 
return createEdge(gm, newNode, TOP);
} 

protected boolean isDraggableHandle(int index)
    { 
return true;
} 

protected Object getNewNode(int arg0)
    { 
return null;
} 

public SelectionNodeClarifiers2(Fig f)
    { 
super(f);
} 

protected boolean isEdgePostProcessRequested()
    { 
return false;
} 

protected boolean isReverseEdge(int index)
    { 
return false;
} 

 } 


