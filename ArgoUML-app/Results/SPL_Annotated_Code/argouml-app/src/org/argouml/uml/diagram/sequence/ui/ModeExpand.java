// Compilation Unit of /ModeExpand.java 
 
package org.argouml.uml.diagram.sequence.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.FigModifyingModeImpl;
import org.tigris.gef.base.Globals;
import org.argouml.i18n.Translator;
public class ModeExpand extends FigModifyingModeImpl
  { 
private int startX, startY, currentY;
private Editor editor;
private Color rubberbandColor;
public void mouseDragged(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

currentY = me.getY();
editor.damageAll();
me.consume();
} 

public void mouseReleased(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

SequenceDiagramLayer layer =
            (SequenceDiagramLayer) Globals.curEditor().getLayerManager()
            .getActiveLayer();
int endY = me.getY();
int startOffset = layer.getNodeIndex(startY);
if(startOffset > 0 && endY < startY)//1
{ 
startOffset--;
} 

int diff = layer.getNodeIndex(endY) - startOffset;
if(diff < 0)//1
{ 
diff = -diff;
} 

if(diff > 0)//1
{ 
layer.expandDiagram(startOffset, diff);
} 

me.consume();
done();
} 

public String instructions()
    { 
return Translator.localize("action.sequence-expand");
} 

public ModeExpand()
    { 
editor = Globals.curEditor();
rubberbandColor = Globals.getPrefs().getRubberbandColor();
} 

public void paint(Graphics g)
    { 
g.setColor(rubberbandColor);
g.drawLine(startX, startY, startX, currentY);
} 

public void mousePressed(MouseEvent me)
    { 
if(me.isConsumed())//1
{ 
return;
} 

startY = me.getY();
startX = me.getX();
start();
me.consume();
} 

 } 


